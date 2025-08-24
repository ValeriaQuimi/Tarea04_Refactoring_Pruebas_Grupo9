package com.example.patrones.factory;

import com.example.enums.EstadoHabitacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HabitacionFamiliarTest {

    @Test
    void estaDisponiblenRetornaFalse() {
        HabitacionFamiliar familiar = new HabitacionFamiliar(3, 301);
        familiar.estado = EstadoHabitacion.RESERVADA;
        assertFalse(familiar.estaDisponible());
    }

    @Test
    void estaDisponibleRetornaTruePorDefecto() {
        HabitacionFamiliar familiar = new HabitacionFamiliar(3, 301);
        assertTrue(familiar.estaDisponible(), "La habitación recién creada debería estar disponible");
    }

    @Test
    void estaDisponibleRetornaFalseSiReservada() {
        HabitacionFamiliar familiar = new HabitacionFamiliar(3, 301);
        familiar.estado = EstadoHabitacion.RESERVADA;
        assertFalse(familiar.estaDisponible(), "La habitación no debería estar disponible si está reservada");
    }

    @Test
    void mostrarDetallesNoLanzaExcepcion() {
        HabitacionFamiliar familiar = new HabitacionFamiliar(3, 301);
        assertDoesNotThrow(() -> familiar.mostrarDetalles(),
                "mostrarDetalles no debería lanzar excepción");
    }

    @Test
    void calcularPrecioLanzaUnsupportedOperation() {
        HabitacionFamiliar familiar = new HabitacionFamiliar(3, 301);
        assertEquals(120.00, familiar.calcularPrecio(), 0.01, "calcularPrecio debe retornar 120.00");
    }

}
