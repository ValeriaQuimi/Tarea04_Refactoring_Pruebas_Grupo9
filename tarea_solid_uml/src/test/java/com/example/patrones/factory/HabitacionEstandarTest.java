package com.example.patrones.factory;

import com.example.enums.EstadoHabitacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HabitacionEstandarTest {

    @Test
    void mostrarDetallesTestSinErrores() {
        HabitacionEstandar habitacion = new HabitacionEstandar(1, 101);
        assertDoesNotThrow(habitacion::mostrarDetalles);
    }

    @Test
    void reservarTestCambiaEstado() {
        HabitacionEstandar habitacion = new HabitacionEstandar(1, 101);
        habitacion.reservar();
        assertEquals(EstadoHabitacion.RESERVADA, habitacion.estado);
    }

    @Test
    void constructorTestEstadoInicialDisponible() {
        HabitacionEstandar habitacion = new HabitacionEstandar(1, 101);
        assertNotNull(habitacion);
        assertEquals(EstadoHabitacion.DISPONIBLE, habitacion.estado);
        assertEquals(1, habitacion.idHotel);
        assertEquals(101, habitacion.numero);
    }

}
