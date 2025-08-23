package com.example.patrones.decorator;

import com.example.patrones.factory.HabitacionEstandar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HabitacionDecoratorTest {

    @Test
    void testPrecioConDesayuno() {
        IHabitacion hab = new HabitacionEstandar(1, 101);
        hab = new DesayunoDecorator(hab, 20.0);
        assertEquals(100.0, hab.calcularPrecio(), 0.01);
    }

    @Test
    void testPrecioConVariosDecoradores() {
        IHabitacion hab = new HabitacionEstandar(1, 101);
        hab = new DesayunoDecorator(hab, 20.0);
        hab = new AccesoExclusivoDecorator(hab, 30.0);
        assertEquals(130.0, hab.calcularPrecio(), 0.01);
    }

    @Test
    void testDisponibilidadHabitacion() {
        IHabitacion hab = new HabitacionEstandar(1, 101);
        assertTrue(hab.estaDisponible());
        hab.reservar();
        assertFalse(hab.estaDisponible());
    }

    @Test
    void testNullDecoratorThrows() {
        assertThrows(NullPointerException.class, () -> {
            new DesayunoDecorator(null, 10.0);
        });
    }
}
