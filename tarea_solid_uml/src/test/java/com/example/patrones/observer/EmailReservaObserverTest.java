package com.example.patrones.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.interfaces.Notificador;
import com.example.mensajes.ConstructorMensaje;
import com.example.usuarios_y_roles.Email;
import com.example.usuarios_y_roles.Usuario;

public class EmailReservaObserverTest {

    private EmailReservaObserver observer;
    private TestNotificador notificador;

    private static class TestNotificador implements Notificador {
        String mensajeEnviado;
        Usuario usuarioRecibido;

        @Override
        public void enviar(String mensaje, Usuario usuario) {
            this.mensajeEnviado = mensaje;
            this.usuarioRecibido = usuario;
        }
    }

    @BeforeEach
    void setUp() {
        notificador = new TestNotificador();
        observer = new EmailReservaObserver(notificador);
    }

    @Test
    void testOnReservaCreada_enviaAsuntoYMensaje() {
        Usuario usuario = new Usuario(1, "Miriam", new Email("miriam@example.com"));
        String mensaje = "Reserva confirmada";

        observer.onReservaCreada(mensaje, usuario);

        String esperado = "Confirmación de reserva TravelStay\n" +
                ConstructorMensaje.construirReservaCreada(usuario, mensaje);

        assertEquals(esperado, notificador.mensajeEnviado);
        assertEquals(usuario, notificador.usuarioRecibido);
    }

    @Test
    void testOnReservaCancelada_enviaAsuntoYMensaje() {
        Usuario usuario = new Usuario(2, "Samuel", new Email("samuel@example.com"));
        String mensaje = "Reserva cancelada";

        observer.onReservaCancelada(mensaje, usuario);

        String esperado = "Cancelación de reserva TravelStay\n" +
                ConstructorMensaje.construirReservaCancelada(usuario, mensaje);

        assertEquals(esperado, notificador.mensajeEnviado);
        assertEquals(usuario, notificador.usuarioRecibido);
    }

}
