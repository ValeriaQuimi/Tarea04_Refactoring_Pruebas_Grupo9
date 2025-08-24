/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.turismo_y_paseos;

import com.example.enums.EstadoPaseo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SRoman
 */
public class PaseoTuristicoTest {
    /**
     * Test of calcularPrecio method, of class PaseoTuristico.
     */
 @Test
    void testCalcularPrecio() {
        // Crear instancia con precio 150.0
        PaseoTuristico paseo = new PaseoTuristico("Tour cultural", 150.0);
        
        // Esperamos que calcule correctamente el precio
        double esperado = 150.0;
        double resultado = paseo.calcularPrecio();
        
        assertEquals(esperado, resultado, 0.001);
    }

    @Test
     void testVerificarDisponibilidadDisponible() {
        // Estado por defecto es DISPONIBLE
        PaseoTuristico paseo = new PaseoTuristico("Tour cultural", 150.0);
        
        // Verificar que está disponible
        assertTrue(paseo.verificarDisponibilidad());
    }

    @Test
     void testVerificarDisponibilidadNoDisponible() throws Exception {
        // Crear instancia
        PaseoTuristico paseo = new PaseoTuristico("Tour cultural", 150.0);
        
        // Cambiar estado a AGOTADO usando reflexión para test (porque no hay setter)
        java.lang.reflect.Field estadoField = paseo.getClass().getDeclaredField("estado");
        estadoField.setAccessible(true);
        estadoField.set(paseo, EstadoPaseo.AGOTADO);
        
        // Verificar que no está disponible
        assertFalse(paseo.verificarDisponibilidad());
    }
    @Test
 void testVerificarDisponibilidadCancelado() throws Exception {
    PaseoTuristico paseo = new PaseoTuristico("Tour cultural", 150.0);
    
    java.lang.reflect.Field estadoField = paseo.getClass().getDeclaredField("estado");
    estadoField.setAccessible(true);
    estadoField.set(paseo, EstadoPaseo.CANCELADO);
    
    assertFalse(paseo.verificarDisponibilidad());
}

@Test
 void testCalcularPrecioCero() {
    PaseoTuristico paseo = new PaseoTuristico("Tour gratuito", 0.0);
    
    assertEquals(0.0, paseo.calcularPrecio(), 0.001);
}


@Test
 void testCalcularPrecioNegativo() {
    PaseoTuristico paseo = new PaseoTuristico("Tour especial", -50.0);
    
    assertEquals(-50.0, paseo.calcularPrecio(), 0.001);
}

@Test
void testMostrarDetalles() {
    PaseoTuristico paseo = new PaseoTuristico("Tour cultural", 150.0);
    paseo.mostrarDetalles(); // Manual o usando System.setOut() para capturar
}


}
