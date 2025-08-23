package com.example.patrones.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DesayunoDecoratorTest {
    static class TestHabitacion implements IHabitacion {
        boolean reservado = false;
        @Override public double calcularPrecio() { return 100.0; }
        @Override public void mostrarDetalles() { /* no-op */ }
        @Override public boolean estaDisponible() { return !reservado; }
        @Override public void reservar() { reservado = true; }
    }

    @Test
    void testCalcularPrecioSumaCorrecta() {
        IHabitacion base = new TestHabitacion();
        IHabitacion deco = new DesayunoDecorator(base, 25.0);
        assertEquals(125.0, deco.calcularPrecio(), 0.01);
        assertNotEquals(100.0, deco.calcularPrecio());
    }

    @Test
    void testMostrarDetallesNoLanzaExcepcion() {
        IHabitacion base = new TestHabitacion();
        IHabitacion deco = new DesayunoDecorator(base, 15.0);
        assertDoesNotThrow(deco::mostrarDetalles);
    }

    @Test
    void testNullHabitacionLanzaExcepcion() {
        assertThrows(NullPointerException.class, () -> new DesayunoDecorator(null, 10.0));
    }

    @Test
    void testDisponibilidadYReserva() {
        TestHabitacion base = new TestHabitacion();
        IHabitacion deco = new DesayunoDecorator(base, 10.0);
        assertTrue(deco.estaDisponible());
        deco.reservar();
        assertFalse(deco.estaDisponible());
    }

    @Test
    void testReferenciaNoNula() {
        IHabitacion base = new TestHabitacion();
        DesayunoDecorator deco = new DesayunoDecorator(base, 5.0);
        assertNotNull(deco.habitacion);
    }
}
