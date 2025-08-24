/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.usuarios_y_roles;

import com.example.enums.EstadoIncidente;
import com.example.interfaces.GestorDeAccion;
import com.example.soporte.Incidente;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SRoman
 */
public class AgenteDeSoporteTest {

    /**
     * Test of gestionarIncidente method, of class AgenteDeSoporte.
     */
    @Test
    void testGestionarIncidente_resolver_sinMockito() {
        Email correo = new Email("agente@mail.com");
        Usuario usuario = new Usuario(1, "Juan", correo);
        Incidente incidente = new Incidente(1, usuario, "Problema X");

        AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente1", correo);
        GestorDeAccion gestor = new GestorDeAccion() {
            @Override
            public String obtenerAccion(Incidente inc) {
                return "resolver";
            }
        };

        agente.gestionarIncidente(incidente, gestor);

        assertEquals(EstadoIncidente.RESUELTO, incidente.getEstado());
    }

    @Test
    void testGestionarIncidente_escalar() {
        Email correo = new Email("agente2@mail.com");
        Usuario usuario = new Usuario(1, "Juan", correo);
        Incidente incidente = new Incidente(2, usuario, "Problema Y");

        AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente2", correo);
        GestorDeAccion gestor = new GestorDeAccion() {
            @Override
            public String obtenerAccion(Incidente inc) {
                return "escalar";
            }
        };

        agente.gestionarIncidente(incidente, gestor);

        assertEquals(EstadoIncidente.ESCALADO, incidente.getEstado());
    }

    @Test
    void testGestionarIncidente_accionNoValida() {
        Email correo = new Email("agente3@mail.com");
        Usuario usuario = new Usuario(1, "Juan", correo);
        Incidente incidente = new Incidente(3, usuario, "Problema Z");

        AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente3", correo);
        GestorDeAccion gestor = new GestorDeAccion() {
            @Override
            public String obtenerAccion(Incidente inc) {
                return "ignorar"; // acción no válida
            }
        };

        agente.gestionarIncidente(incidente, gestor);

        // Estado debe ser EN_PROCESO porque se cambia antes del switch
        assertEquals(EstadoIncidente.EN_PROCESO, incidente.getEstado());
    }

    @Test
    void testGestionarIncidente_incidenteNull() {

        Email correo = new Email("agente4@mail.com");
        AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente4", correo);
        GestorDeAccion gestor = new GestorDeAccion() {
            @Override
            public String obtenerAccion(Incidente inc) {
                return "resolver";
            }
        };

        // No debería lanzar excepción, solo no hace nada
        assertDoesNotThrow(() -> {
            agente.gestionarIncidente(null, gestor);
        });
    }

    @Test
    void testGestionarIncidente_gestorNull() {
        Email correo = new Email("agente5@mail.com");
        Usuario usuario = new Usuario(1, "Juan", correo);

        Incidente incidente = new Incidente(4, usuario, "Problema W");

        AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente5", correo);
        // No debería lanzar excepción, solo no hace nada
        assertDoesNotThrow(() -> {
            agente.gestionarIncidente(incidente, null);
        });
    }
}
