/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.gestion;

import com.example.interfaces.GestorDeAccion;
import com.example.soporte.Incidente;
import com.example.usuarios_y_roles.Usuario;
import java.io.ByteArrayInputStream;
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
public class GestorConsolaTest {
    
    public GestorConsolaTest() {
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
     * Test of obtenerAccion method, of class GestorConsola.
     */
   @Test
    public void testObtenerAccionResolver() {
        String simulatedInput = "resolver\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        GestorDeAccion gestor = new GestorConsola();
        Usuario usuario = new Usuario(1, "Juan", "juan@mail.com");
        Incidente incidente = new Incidente(1, usuario, "Error en el sistema");

        String accion = gestor.obtenerAccion(incidente);

        assertEquals("resolver", accion);
    }

    @Test
    public void testObtenerAccionEscalar() {
        String simulatedInput = "escalar\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        GestorDeAccion gestor = new GestorConsola();
        Usuario usuario = new Usuario(2, "Ana", "ana@mail.com");
        Incidente incidente = new Incidente(2, usuario, "Problema de red");

        String accion = gestor.obtenerAccion(incidente);

        assertEquals("escalar", accion);
    }

    @Test
    public void testObtenerAccionMayusculas() {
        String simulatedInput = "RESOLVER\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        GestorDeAccion gestor = new GestorConsola();
        Usuario usuario = new Usuario(3, "Luis", "luis@mail.com");
        Incidente incidente = new Incidente(3, usuario, "Pantalla congelada");

        String accion = gestor.obtenerAccion(incidente);

        assertEquals("resolver", accion);
    }

    @Test
    public void testObtenerAccionVacio() {
        String simulatedInput = "\n"; // Entrada vacía
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        GestorDeAccion gestor = new GestorConsola();
        Usuario usuario = new Usuario(4, "Pedro", "pedro@mail.com");
        Incidente incidente = new Incidente(4, usuario, "Sin descripción");

        String accion = gestor.obtenerAccion(incidente);

        assertEquals("", accion);
    }
    
}
