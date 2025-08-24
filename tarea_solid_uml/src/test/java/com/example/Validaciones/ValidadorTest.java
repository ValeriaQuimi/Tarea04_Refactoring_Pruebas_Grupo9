package com.example.Validaciones;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.interfaces.Notificador;
import com.example.patrones.observer.EmailReservaObserver;
import com.example.patrones.observer.ReservaObserver;
import com.example.usuarios_y_roles.Email;
import com.example.usuarios_y_roles.Usuario;
import com.example.validaciones.Validador;

public class ValidadorTest {

    private static class TestNotificador implements Notificador {
        @Override
        public void enviar(String mensaje, Usuario usuario) {
            // vacía
        }
    }

    // Caso 1: usuario nulo
    @Test
    void testValidarReservaUsuarioNulo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            Validador.validarReserva(null, "mensaje ejemplo");
        });
        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }

    // Caso 2: nombre del usuario nulo
    @Test
    void testValidarReservaNombreUsuarioNulo() {
        Usuario usuario = new Usuario(1, null, new Email("correo@example.com"));
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            Validador.validarReserva(usuario, "mensaje ejemplo");
        });
        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }

    // Caso 3: mensaje nulo
    @Test
    void testValidarReservaMensajeNulo() {
        Usuario usuario = new Usuario(2, "Miriam", new Email("miriam@example.com"));
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            Validador.validarReserva(usuario, null);
        });
        assertEquals("El mensaje no puede ser nulo.", ex.getMessage());
    }

    // Caso 4: datos válidos → no lanza excepción
    @Test
    void testValidarReserva_valido() {
        Usuario usuario = new Usuario(3, "Samuel", new Email("samuel@example.com"));
        assertDoesNotThrow(() -> Validador.validarReserva(usuario, "Mensaje válido"));
    }

    // Caso 5: observer nulo
    @Test
    void testValidarObserver_nulo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            Validador.validarObsever(null);
        });
        assertEquals("Observer no puede ser null", ex.getMessage());
    }

    // Caso 6: observer válido → no lanza excepción
    @Test
    void testValidarObserver_valido() {
        ReservaObserver observer = new EmailReservaObserver(new TestNotificador());
        assertDoesNotThrow(() -> Validador.validarObsever(observer));
    }

}
