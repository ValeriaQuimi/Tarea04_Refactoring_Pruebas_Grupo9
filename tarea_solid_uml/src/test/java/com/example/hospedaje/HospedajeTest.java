/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.hospedaje;

import com.example.patrones.decorator.IHabitacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SRoman
 */
public class HospedajeTest {

    // Stub para IHabitacion
    static class HabitacionStub implements IHabitacion {
        private double precio;
        private boolean disponible;
        private boolean reservadoLlamado = false;

        public HabitacionStub(double precio, boolean disponible) {
            this.precio = precio;
            this.disponible = disponible;
        }

        @Override
        public double calcularPrecio() {
            return precio;
        }

        @Override
        public void mostrarDetalles() {
            /* no necesario */ }

        @Override
        public boolean estaDisponible() {
            return disponible;
        }

        @Override
        public void reservar() {
            reservadoLlamado = true;
        }

        public boolean isReservadoLlamado() {
            return reservadoLlamado;
        }
    }

    @Test
    void testCalcularPrecio() {
        HabitacionStub h = new HabitacionStub(100.0, true);
        Hospedaje hospedaje = new Hospedaje(h);
        assertEquals(100.0, hospedaje.calcularPrecio(), 0.0001);
    }

    @Test
    void testVerificarDisponibilidad() {
        HabitacionStub h = new HabitacionStub(50.0, true);
        Hospedaje hospedaje = new Hospedaje(h);
        assertTrue(hospedaje.verificarDisponibilidad());
    }

    @Test
    void testBloquearTemporalmente_ReservarSiDisponible() {
        HabitacionStub h = new HabitacionStub(80.0, true);
        Hospedaje hospedaje = new Hospedaje(h);
        hospedaje.bloquearTemporalmente();
        assertTrue(h.isReservadoLlamado(), "Debe llamar a reservar() cuando está disponible");
    }

    @Test
    void testBloquearTemporalmente_NoReservarSiNoDisponible() {
        HabitacionStub h = new HabitacionStub(80.0, false);
        Hospedaje hospedaje = new Hospedaje(h);
        hospedaje.bloquearTemporalmente();
        assertFalse(h.isReservadoLlamado(), "No debe llamar a reservar() cuando no está disponible");
    }

    @Test
    void testGetHabitacion() {
        HabitacionStub h = new HabitacionStub(40.0, true);
        Hospedaje hospedaje = new Hospedaje(h);
        assertSame(h, hospedaje.getHabitacion());
    }

    // Test complementarios
    @Test
    void testCalcularPrecioCero() {
        HabitacionStub h = new HabitacionStub(0.0, true);
        Hospedaje hospedaje = new Hospedaje(h);
        assertEquals(0.0, hospedaje.calcularPrecio(), 0.0001);
    }

    @Test
    void testCalcularPrecioNegativo() {
        HabitacionStub h = new HabitacionStub(-50.0, true);
        Hospedaje hospedaje = new Hospedaje(h);
        assertEquals(-50.0, hospedaje.calcularPrecio(), 0.0001);
    }

    @Test
    void testVerificarDisponibilidadNulo() {
        Hospedaje hospedaje = new Hospedaje(null);
        assertThrows(NullPointerException.class, hospedaje::verificarDisponibilidad);
    }

    @Test
    void testCalcularPrecioNulo() {
        Hospedaje hospedaje = new Hospedaje(null);
        assertThrows(NullPointerException.class, hospedaje::calcularPrecio);
    }

    @Test
    void testMostrarDetalles() {
        HabitacionStub h = new HabitacionStub(100.0, true);
        Hospedaje hospedaje = new Hospedaje(h);
        assertDoesNotThrow(hospedaje::mostrarDetalles);
    }

}