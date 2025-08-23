package com.example.patrones.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccesoExclusivoDecoratorTest {
    static class TestHabitacion implements IHabitacion {
        boolean reservado = false;
        @Override public double calcularPrecio() { return 100.0; }
        @Override public void mostrarDetalles() { /* no-op */ }
        @Override public boolean estaDisponible() { return !reservado; }
        @Override public void reservar() { reservado = true; }
    }

    @Test
    void testPrecioConAccesoExclusivo() {
        IHabitacion hab = new TestHabitacion();
        hab = new AccesoExclusivoDecorator(hab, 35.0);
        assertEquals(135.0, hab.calcularPrecio(), 0.01);
    }

    @Test
    void testDetallesIncluyenAcceso() {
        IHabitacion hab = new TestHabitacion();
        hab = new AccesoExclusivoDecorator(hab, 35.0);
        // Solo verificamos que no lanza excepción y muestra detalles
        assertDoesNotThrow(hab::mostrarDetalles);
    }

    @Test
    void testCombinacionConDesayunoYAcceso() {
        IHabitacion hab = new TestHabitacion();
        hab = new DesayunoDecorator(hab, 20.0);
        hab = new AccesoExclusivoDecorator(hab, 35.0);
        assertEquals(155.0, hab.calcularPrecio(), 0.01);
    }
}
