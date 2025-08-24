/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.soporte;

import com.example.enums.EstadoIncidente;
import com.example.usuarios_y_roles.Email;
import com.example.usuarios_y_roles.Usuario;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SRoman
 */
public class IncidenteTest {

    public IncidenteTest() {
    }

    @Test
    void testConstructorYGetters() {
        Email correo = new Email("axel@example.com");
        Usuario usuario = new Usuario(1, "Axel", correo);
        Incidente incidente = new Incidente(10, usuario, "Falla en la conexión");

        assertEquals(10, incidente.getId());
        assertEquals(usuario, incidente.getUsuarioReportante());
        assertEquals("Falla en la conexión", incidente.getDescripcion());
        assertEquals(EstadoIncidente.NUEVO, incidente.getEstado());
    }

    @Test
    void testSetDescripcion() {
        Email correo = new Email("axel@example.com");
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", correo), "Inicial");
        incidente.setDescripcion("Nueva descripción");
        assertEquals("Nueva descripción", incidente.getDescripcion());
    }

    @Test
    void testSetId() {
        Email correo = new Email("axel@example.com");
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", correo), "Desc");
        incidente.setId(5);
        assertEquals(5, incidente.getId());
    }

    @Test
    void testSetUsuarioReportante() {
        Email correo = new Email("axel@example.com");
        Usuario u1 = new Usuario(1, "Axel", correo);
        Email correo1 = new Email("maria@example.com");
        Usuario u2 = new Usuario(2, "Maria", correo1);
        Incidente incidente = new Incidente(1, u1, "Desc");
        incidente.setUsuarioReportante(u2);
        assertEquals(u2, incidente.getUsuarioReportante());
    }

    @Test
    void testSetEstado() {
        Email correo = new Email("axel@example.com");
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", correo), "Desc");
        incidente.setEstado(EstadoIncidente.ESCALADO);
        assertEquals(EstadoIncidente.ESCALADO, incidente.getEstado());
    }

    @Test
    void testResolverIncidente() {
        Email correo = new Email("axel@example.com");
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", correo), "Desc");
        incidente.resolverIncidente();
        assertEquals(EstadoIncidente.RESUELTO, incidente.getEstado());
    }

    @Test
    void testEscalar() {
        Email correo = new Email("axel@example.com");
        Incidente incidente = new Incidente(1, new Usuario(1, "Axel", correo), "Desc");
        incidente.escalarIncidente();
        assertEquals(EstadoIncidente.ESCALADO, incidente.getEstado());
    }

}
