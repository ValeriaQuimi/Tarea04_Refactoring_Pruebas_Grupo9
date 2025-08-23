package com.example.patrones.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaqueteDecoratorTest {
    
    static class TestPaquete implements IPaqueteTuristico {
        boolean disponible = true;
        @Override public double calcularPrecio() { return 150.0; }
        @Override public void mostrarDetalles() { /* no-op */ }
        @Override public boolean verificarDisponibilidad() { return disponible; }
    }

    // Decorador concreto para pruebas
    static class TestPaqueteDecorator extends PaqueteDecorator {
        public TestPaqueteDecorator(IPaqueteTuristico paquete) { super(paquete); }
    }

    @Test
    void testCalcularPrecioEqualsYNotEquals() {
        IPaqueteTuristico base = new TestPaquete();
        IPaqueteTuristico deco = new TestPaqueteDecorator(base);
        assertEquals(150.0, deco.calcularPrecio(), 0.01);
        assertNotEquals(100.0, deco.calcularPrecio());
    }

    @Test
    void testMostrarDetallesNoLanzaExcepcion() {
        IPaqueteTuristico base = new TestPaquete();
        IPaqueteTuristico deco = new TestPaqueteDecorator(base);
        assertDoesNotThrow(deco::mostrarDetalles);
    }

    @Test
    void testDisponibilidad() {
        TestPaquete base = new TestPaquete();
        IPaqueteTuristico deco = new TestPaqueteDecorator(base);
        assertTrue(deco.verificarDisponibilidad());
        base.disponible = false;
        assertFalse(deco.verificarDisponibilidad());
    }

    @Test
    void testReferenciaNoNula() {
        IPaqueteTuristico base = new TestPaquete();
        TestPaqueteDecorator deco = new TestPaqueteDecorator(base);
        assertNotNull(deco.paquete);
    }
}
