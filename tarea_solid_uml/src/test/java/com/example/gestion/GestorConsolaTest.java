/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.gestion;

import com.example.interfaces.GestorDeAccion;
import com.example.soporte.Incidente;
import com.example.usuarios_y_roles.Email;
import com.example.usuarios_y_roles.Usuario;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SRoman
 */
public class GestorConsolaTest {

    /**
     * Test of obtenerAccion method, of class GestorConsola.
     */
    @Test
    void testObtenerAccionResolver() {
        String simulatedInput = "resolver\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        GestorDeAccion gestor = new GestorConsola();
        Email email = new Email("juan@mail.com");
        Usuario usuario = new Usuario(1, "Juan", email);
        Incidente incidente = new Incidente(1, usuario, "Error en el sistema");

        String accion = gestor.obtenerAccion(incidente);

        assertEquals("resolver", accion);
    }

    @Test
    void testObtenerAccionEscalar() {
        String simulatedInput = "escalar\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        GestorDeAccion gestor = new GestorConsola();
        Email email = new Email("ana@mail.com");
        Usuario usuario = new Usuario(2, "Ana", email);
        Incidente incidente = new Incidente(2, usuario, "Problema de red");

        String accion = gestor.obtenerAccion(incidente);

        assertEquals("escalar", accion);
    }

    @Test
    void testObtenerAccionMayusculas() {
        String simulatedInput = "RESOLVER\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        GestorDeAccion gestor = new GestorConsola();
        Email email = new Email("luis@mail.com");
        Usuario usuario = new Usuario(3, "Luis", email);
        Incidente incidente = new Incidente(3, usuario, "Pantalla congelada");

        String accion = gestor.obtenerAccion(incidente);

        assertEquals("resolver", accion);
    }

    @Test
    void testObtenerAccionVacio() {
        String simulatedInput = "\n"; // Entrada vacía
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        GestorDeAccion gestor = new GestorConsola();
        Email email = new Email("pedro@mail.com");
        Usuario usuario = new Usuario(4, "Pedro", email);
        Incidente incidente = new Incidente(4, usuario, "Sin descripción");

        String accion = gestor.obtenerAccion(incidente);

        assertEquals("", accion);
    }

}
