/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.turismo_y_paseos;

import com.example.hospedaje.Hospedaje;
import com.example.patrones.decorator.IHabitacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaqueteTuristicoTest {

    // Clase interna para IHabitacion de prueba
    static class HabitacionTest implements IHabitacion {
        private double precio;
        private boolean disponible;

        public HabitacionTest(double precio, boolean disponible) {
            this.precio = precio;
            this.disponible = disponible;
        }

        @Override
        public double calcularPrecio() {
            return precio;
        }

        @Override
        public void mostrarDetalles() {
            // no hace nada
        }

        @Override
        public boolean estaDisponible() {
            return disponible;
        }

        @Override
        public void reservar() {
            // no hace nada
        }
    }

    @Test
     void testCalcularPrecio() {
        IHabitacion habitacion = new HabitacionTest(200.0, true);
        Hospedaje hospedaje = new Hospedaje(habitacion);

        PaseoTuristico paseo = new PaseoTuristico("Tour Cultural", 150.0);

        double descuento = 30.0;
        PaqueteTuristico paquete = new PaqueteTuristico(hospedaje, paseo, descuento);

        double esperado = 200.0 + 150.0 - 30.0;
        assertEquals(esperado, paquete.calcularPrecio(), 0.01);
    }

    @Test
    void testVerificarDisponibilidad_true() {
        IHabitacion habitacion = new HabitacionTest(100.0, true);
        Hospedaje hospedaje = new Hospedaje(habitacion);

        PaseoTuristico paseo = new PaseoTuristico("Tour Aventura", 75.0);

        PaqueteTuristico paquete = new PaqueteTuristico(hospedaje, paseo, 0.0);

        assertTrue(paquete.verificarDisponibilidad());
    }

    @Test
     void testVerificarDisponibilidad_false() {
        IHabitacion habitacion = new HabitacionTest(100.0, true);
        Hospedaje hospedaje = new Hospedaje(habitacion);

        PaseoTuristico paseo = new PaseoTuristico("Tour Aventura", 75.0);

        // Cambiamos el estado para simular no disponible
        // Como tu clase no tiene setter para estado, vamos a crear un subclase para el test:
        PaseoTuristico paseoNoDisponible = new PaseoTuristico("Tour Cancelado", 75.0) {
            @Override
            public boolean verificarDisponibilidad() {
                return false;
            }
        };

        PaqueteTuristico paquete = new PaqueteTuristico(hospedaje, paseoNoDisponible, 0.0);

        assertFalse(paquete.verificarDisponibilidad());
    }
}
