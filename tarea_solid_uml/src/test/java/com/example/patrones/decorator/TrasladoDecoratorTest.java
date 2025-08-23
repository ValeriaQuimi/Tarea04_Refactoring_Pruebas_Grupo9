package com.example.patrones.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrasladoDecoratorTest {
    static class TestPaquete implements IPaqueteTuristico {
        boolean disponible = true;
        @Override public double calcularPrecio() { return 180.0; }
        @Override public void mostrarDetalles() { /* no-op */ }
        @Override public boolean verificarDisponibilidad() { return disponible; }
    }

    @Test
    void testCalcularPrecioSumaCorrecta() {
        IPaqueteTuristico base = new TestPaquete();
        IPaqueteTuristico deco = new TrasladoDecorator(base, 20.0);
        assertEquals(200.0, deco.calcularPrecio(), 0.01);
        assertNotEquals(180.0, deco.calcularPrecio());
    }

    @Test
    void testMostrarDetallesNoLanzaExcepcion() {
        IPaqueteTuristico base = new TestPaquete();
        IPaqueteTuristico deco = new TrasladoDecorator(base, 15.0);
        assertDoesNotThrow(deco::mostrarDetalles);
    }

    @Test
    void testDisponibilidad() {
        TestPaquete base = new TestPaquete();
        IPaqueteTuristico deco = new TrasladoDecorator(base, 10.0);
        assertTrue(deco.verificarDisponibilidad());
        base.disponible = false;
        assertFalse(deco.verificarDisponibilidad());
    }

    @Test
    void testReferenciaNoNula() {
        IPaqueteTuristico base = new TestPaquete();
        TrasladoDecorator deco = new TrasladoDecorator(base, 5.0);
        assertNotNull(deco.paquete);
    }
}
