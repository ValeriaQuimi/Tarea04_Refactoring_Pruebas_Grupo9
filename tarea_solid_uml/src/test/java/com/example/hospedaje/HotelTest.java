/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.hospedaje;

import com.example.patrones.factory.Habitacion;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SRoman
 */
public class HotelTest {

    static class HabitacionStub extends Habitacion {
        public HabitacionStub(int idHotel, int numero) {
            super(idHotel, numero);
        }

        @Override
        public double calcularPrecio() {
            return 100.0;
        }

        @Override
        public void mostrarDetalles() {
            // no necesario para el test
        }
    }

    @Test
    public void testAgregarHabitacion() {
        Hotel hotel = new Hotel(1, "Hotel Test", "Calle Falsa 123");
        Habitacion habitacion = new HabitacionStub(1, 101);

        hotel.agregarHabitacion(habitacion);

        List<Habitacion> habitaciones = hotel.getHabitaciones();
        assertNotNull(habitaciones);
        assertTrue(habitaciones.contains(habitacion));
    }

    @Test
    public void testGetHabitaciones() {
        Hotel hotel = new Hotel(2, "Hotel Otro", "Av. Siempre Viva 456");
        assertNotNull(hotel.getHabitaciones());
        assertEquals(0, hotel.getHabitaciones().size());
    }
}

