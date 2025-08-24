package com.example.patrones.factory;

import com.example.enums.EstadoHabitacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HabitacionSuiteTest {

    @Test
    void reservarTestCambiaReservado() {
        HabitacionSuite suite = new HabitacionSuite(2, 201);
        suite.estado = EstadoHabitacion.OCUPADA;
        suite.reservar();
        assertEquals(EstadoHabitacion.RESERVADA, suite.estado);
    }

    @Test
    void mostrarDetallesTestSinErrores() {
        HabitacionSuite suite = new HabitacionSuite(3, 303);
        suite.reservar();
        assertDoesNotThrow(suite::mostrarDetalles);
        assertEquals(EstadoHabitacion.RESERVADA, suite.estado);
    }
     @Test
    void estaDisponibleRetornaTrueSiDisponible() {
        HabitacionSuite suite = new HabitacionSuite(5, 501);
        assertTrue(suite.estaDisponible());
    }

    @Test
    void calcularPrecioLanzaUnsupportedOperation() {
    HabitacionSuite suite = new HabitacionSuite(5, 501);
    assertEquals(180.00, suite.calcularPrecio(), 0.01, "calcularPrecio debe retornar 180.00");
    }

}