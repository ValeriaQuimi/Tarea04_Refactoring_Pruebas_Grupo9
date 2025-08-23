/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.soporte;

import com.example.enums.EstadoIncidente;
import com.example.usuarios_y_roles.Usuario;
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
public class IncidenteTest {
    
    public IncidenteTest() {
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
     * Test of getDescripcion method, of class Incidente.
     */
   @Test
    public void testConstructorYGetters() {
        Usuario usuario = new Usuario(1, "Axel", "axel@example.com");
        Incidente incidente = new Incidente(10, usuario, "Falla en la conexión");

        assertEquals(10, incidente.getId());
        assertEquals(usuario, incidente.getUsuarioReportante());
        assertEquals("Falla en la conexión", incidente.getDescripcion());
        assertEquals(EstadoIncidente.NUEVO, incidente.getEstado());
    }

    @Test
    public void testSetDescripcion() {
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", "axel@example.com"), "Inicial");
        incidente.setDescripcion("Nueva descripción");
        assertEquals("Nueva descripción", incidente.getDescripcion());
    }

    @Test
    public void testSetId() {
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", "axel@example.com"), "Desc");
        incidente.setId(5);
        assertEquals(5, incidente.getId());
    }

    @Test
    public void testSetUsuarioReportante() {
        Usuario u1 = new Usuario(1, "Axel", "axel@example.com");
        Usuario u2 = new Usuario(2, "Maria", "maria@example.com");
        Incidente incidente = new Incidente(1, u1, "Desc");
        incidente.setUsuarioReportante(u2);
        assertEquals(u2, incidente.getUsuarioReportante());
    }

    @Test
    public void testSetEstado() {
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", "axel@example.com"), "Desc");
        incidente.setEstado(EstadoIncidente.ESCALADO);
        assertEquals(EstadoIncidente.ESCALADO, incidente.getEstado());
    }

    @Test
    public void testResolverIncidente() {
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", "axel@example.com"), "Desc");
        incidente.resolverIncidente();
        assertEquals(EstadoIncidente.RESUELTO, incidente.getEstado());
    }

    @Test
    public void testEscalar() {
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", "axel@example.com"), "Desc");
        incidente.escalar();
        assertEquals(EstadoIncidente.ESCALADO, incidente.getEstado());
    }
    
}
