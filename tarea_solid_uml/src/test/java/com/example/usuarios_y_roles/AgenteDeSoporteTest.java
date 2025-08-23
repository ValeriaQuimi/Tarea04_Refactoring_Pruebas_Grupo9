/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.usuarios_y_roles;

import com.example.enums.EstadoIncidente;
import com.example.interfaces.GestorDeAccion;
import com.example.soporte.Incidente;
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
public class AgenteDeSoporteTest {
    
    public AgenteDeSoporteTest() {
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
     * Test of gestionarIncidente method, of class AgenteDeSoporte.
     */
  @Test
public void testGestionarIncidente_resolver_sinMockito() {
    Usuario usuario = new Usuario(1, "Juan", "juan@mail.com");
    Incidente incidente = new Incidente(1, usuario, "Problema X");
    AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente1", "agente@mail.com");

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
    public void testGestionarIncidente_escalar() {
        Usuario usuario = new Usuario(1, "Juan", "juan@mail.com");
        Incidente incidente = new Incidente(2, usuario, "Problema Y");
        AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente2", "agente2@mail.com");

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
    public void testGestionarIncidente_accionNoValida() {
        Usuario usuario = new Usuario(1, "Juan", "juan@mail.com");
        Incidente incidente = new Incidente(3, usuario, "Problema Z");
        AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente3", "agente3@mail.com");

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
public void testGestionarIncidente_incidenteNull() {
    AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente4", "agente4@mail.com");
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
public void testGestionarIncidente_gestorNull() {
    Usuario usuario = new Usuario(1, "Juan", "juan@mail.com");
    Incidente incidente = new Incidente(4, usuario, "Problema W");
    AgenteDeSoporte agente = new AgenteDeSoporte(2, "Agente5", "agente5@mail.com");

    // No debería lanzar excepción, solo no hace nada
    assertDoesNotThrow(() -> {
        agente.gestionarIncidente(incidente, null);
    });
}
}
