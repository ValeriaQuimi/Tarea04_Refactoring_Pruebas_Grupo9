/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.turismo_y_paseos;

import com.example.enums.EstadoPaseo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SRoman
 */
public class PaseoTuristicoTest {
    
    public PaseoTuristicoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calcularPrecio method, of class PaseoTuristico.
     */
 @Test
    public void testCalcularPrecio() {
        // Crear instancia con precio 150.0
        PaseoTuristico paseo = new PaseoTuristico("Tour cultural", 150.0);
        
        // Esperamos que calcule correctamente el precio
        double esperado = 150.0;
        double resultado = paseo.calcularPrecio();
        
        assertEquals(esperado, resultado, 0.001);
    }

    @Test
    public void testVerificarDisponibilidadDisponible() {
        // Estado por defecto es DISPONIBLE
        PaseoTuristico paseo = new PaseoTuristico("Tour cultural", 150.0);
        
        // Verificar que está disponible
        assertTrue(paseo.verificarDisponibilidad());
    }

    @Test
    public void testVerificarDisponibilidadNoDisponible() throws Exception {
        // Crear instancia
        PaseoTuristico paseo = new PaseoTuristico("Tour cultural", 150.0);
        
        // Cambiar estado a AGOTADO usando reflexión para test (porque no hay setter)
        java.lang.reflect.Field estadoField = paseo.getClass().getDeclaredField("estado");
        estadoField.setAccessible(true);
        estadoField.set(paseo, EstadoPaseo.AGOTADO);
        
        // Verificar que no está disponible
        assertFalse(paseo.verificarDisponibilidad());
    }
}
