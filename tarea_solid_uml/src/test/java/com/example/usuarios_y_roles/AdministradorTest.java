/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.usuarios_y_roles;

import com.example.turismo_y_paseos.PaseoTuristico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SRoman
 */
public class AdministradorTest {

    /**
     * Test of configurarPoliticas method, of class Administrador.
     */
    @Test
    void crearAdministradorCorrectamente() {
        Administrador admin = new Administrador(1, "Juan Pérez", "juan@example.com");

        assertEquals(1, admin.getId());
        assertEquals("Juan Pérez", admin.getNombre());
        assertEquals("juan@example.com", admin.getCorreo().getValor());
    }

    @Test
    void configurarPoliticasSinErrores() {
        Administrador admin = new Administrador(2, "Ana López", "ana@example.com");
        assertDoesNotThrow(admin::configurarPoliticas);
    }

    @Test
    void ajustarPlazasSinErrores() {
        Administrador admin = new Administrador(3, "Pedro Gómez", "pedro@example.com");
        PaseoTuristico paseo = new PaseoTuristico("Paseo en lancha", 20.5);
        assertDoesNotThrow(() -> admin.ajustarPlazas(paseo));  
}

    @Test
    void integrarServicioSinErrores() {
        Administrador admin = new Administrador(4, "Laura Torres", "laura@example.com");
        assertDoesNotThrow(admin::integrarServicio);
    }
}
