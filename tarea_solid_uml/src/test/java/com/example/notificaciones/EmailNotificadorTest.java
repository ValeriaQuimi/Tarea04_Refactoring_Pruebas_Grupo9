package com.example.notificaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.usuarios_y_roles.Email;
import com.example.usuarios_y_roles.Usuario;

public class EmailNotificadorTest {
    
    private EmailNotificador notificador;
    private Usuario samuel;

    @BeforeEach
    void setUp() {
        notificador = new EmailNotificador();
        samuel = new Usuario(1, "Samuel", new Email("samuel@gmail.com"));
    }

    @Test
    void testEnviar_usuarioNull() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> notificador.enviar("Hola", null)
        );
        assertEquals("El usuario no puede ser null", ex.getMessage());
    }

    @Test
    void testEnviar_mensajeNull() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> notificador.enviar(null, samuel)
        );
        assertEquals("El mensaje no puede ser null", ex.getMessage());
    }

    @Test
    void testEnviar_datosValidos() {
        // Capturamos la salida de consola
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        notificador.enviar("Hola", samuel);

        String salida = outContent.toString().trim();
        assertEquals("Email enviado a samuel@gmail.com: Hola", salida);
    }
}
