package com.example.patrones.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpaDecoratorTest {
    static class TestPaquete implements IPaqueteTuristico {
        boolean disponible = true;
        @Override public double calcularPrecio() { return 300.0; }
        @Override public void mostrarDetalles() { /* no-op */ }
        @Override public boolean verificarDisponibilidad() { return disponible; }
    }

    @Test
    void testCalcularPrecioSumaCorrecta() {
        IPaqueteTuristico base = new TestPaquete();
        IPaqueteTuristico deco = new SpaDecorator(base, 80.0);
        assertEquals(380.0, deco.calcularPrecio(), 0.01);
        assertNotEquals(300.0, deco.calcularPrecio());
    }

    @Test
    void testMostrarDetallesNoLanzaExcepcion() {
        IPaqueteTuristico base = new TestPaquete();
        IPaqueteTuristico deco = new SpaDecorator(base, 50.0);
        assertDoesNotThrow(deco::mostrarDetalles);
    }

    @Test
    void testDisponibilidad() {
        TestPaquete base = new TestPaquete();
        IPaqueteTuristico deco = new SpaDecorator(base, 10.0);
        assertTrue(deco.verificarDisponibilidad());
        base.disponible = false;
        assertFalse(deco.verificarDisponibilidad());
    }

    @Test
    void testReferenciaNoNula() {
        IPaqueteTuristico base = new TestPaquete();
        SpaDecorator deco = new SpaDecorator(base, 5.0);
        assertNotNull(deco.paquete);
    }
}
