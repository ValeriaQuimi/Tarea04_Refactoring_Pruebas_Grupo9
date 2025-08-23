/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.usuarios_y_roles;

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
public class UsuarioTest {
    
    public UsuarioTest() {
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
     * Test of getCorreo method, of class Usuario.
     */
      @Test
    public void testGetId() {
        Usuario usuario = new Usuario(1, "Axel", "axel@mail.com");
        assertEquals(1, usuario.getId());
    }

    @Test
    public void testGetNombre() {
        Usuario usuario = new Usuario(2, "Juan", "juan@mail.com");
        assertEquals("Juan", usuario.getNombre());
    }

    @Test
    public void testGetCorreo() {
        Usuario usuario = new Usuario(3, "Ana", "ana@mail.com");
        assertEquals("ana@mail.com", usuario.getCorreo());
    }
    
}
