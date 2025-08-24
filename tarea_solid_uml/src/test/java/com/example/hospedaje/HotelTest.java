
package com.example.hospedaje;

import com.example.enums.TipoHabitacion;
import com.example.patrones.factory.Habitacion;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

    static class HabitacionStub extends Habitacion {
        public HabitacionStub(int idHotel, int numero) {
            super(idHotel, numero, TipoHabitacion.ESTANDAR);
        }

        @Override
        public double calcularPrecio() {
            return 100.0;
        }

    }

    @Test
    void testAgregarHabitacion() {
        Hotel hotel = new Hotel(1, "Hotel Test", "Calle Falsa 123");
        Habitacion habitacion = new HabitacionStub(1, 101);

        hotel.agregarHabitacion(habitacion);

        List<Habitacion> habitaciones = hotel.getHabitaciones();
        assertNotNull(habitaciones);
        assertTrue(habitaciones.contains(habitacion));
    }

    @Test
    void testGetHabitaciones() {
        Hotel hotel = new Hotel(2, "Hotel Otro", "Av. Siempre Viva 456");
        assertNotNull(hotel.getHabitaciones());
        assertEquals(0, hotel.getHabitaciones().size());
    }

    // HT01: Agregar habitación nula
    @Test
    void testAgregarHabitacionNula() {
        Hotel hotel = new Hotel(3, "Hotel Nulo", "Calle Null 0");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> hotel.agregarHabitacion(null));
        assertEquals("La habitacion no puede ser null", exception.getMessage());
    }

    // HT02: Crear hotel con nombre nulo
    @Test
    void testCrearHotelConNombreNula() {
        Exception exNombre = assertThrows(IllegalArgumentException.class,
                () -> new Hotel(4, null, "Calle X"));
        assertEquals("Los parametros no pueden ser nulos", exNombre.getMessage());
    }

    // HT02: Crear hotel con direccion nula
    @Test
    void testCrearHotelConDireccionNula() {

        Exception exDireccion = assertThrows(IllegalArgumentException.class,
                () -> new Hotel(5, "Hotel X", null));
        assertEquals("Los parametros no pueden ser nulos", exDireccion.getMessage());
    }
}
