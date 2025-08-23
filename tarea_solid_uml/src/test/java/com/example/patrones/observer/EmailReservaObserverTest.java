package com.example.patrones.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.interfaces.Notificador;
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

    // EMR01
    @Test
    void testOnReservaCreada_mensajeNormal() {
        Usuario usuario = new Usuario(1, "Miriam", "miriam@example.com");
        String mensaje = "Reserva confirmada para el 05/10";

        observer.onReservaCreada(mensaje, usuario);

        String esperado = "Confirmación de reserva TravelStay\nHola Miriam,\n\nReserva confirmada para el 05/10\n\nGracias por elegir TravelStay.";
        assertEquals(esperado, notificador.mensajeEnviado);
        assertEquals(usuario, notificador.usuarioRecibido);
    }

    // EMR02
    @Test
    void testOnReservaCreada_mensajeVacio() {
        Usuario usuario = new Usuario(2, "Miriam", "miriam@example.com");
        String mensaje = "";

        observer.onReservaCreada(mensaje, usuario);

        String esperado = "Confirmación de reserva TravelStay\nHola Miriam,\n\n\n\nGracias por elegir TravelStay.";
        assertEquals(esperado, notificador.mensajeEnviado);
        assertEquals(usuario, notificador.usuarioRecibido);
    }

    // EMR03
    @Test
    void testOnReservaCreada_nombreVacio() {
        Usuario usuario = new Usuario(3, "", "usuario3@example.com");
        String mensaje = "Reserva para el 05/10";

        observer.onReservaCreada(mensaje, usuario);

        String esperado = "Confirmación de reserva TravelStay\nHola ,\n\nReserva para el 05/10\n\nGracias por elegir TravelStay.";
        assertEquals(esperado, notificador.mensajeEnviado);
        assertEquals(usuario, notificador.usuarioRecibido);
    }

    // EMR04
    @Test
    void testOnReservaCreada_mensajeNulo() {
        Usuario usuario = new Usuario(4, "Miriam", "miriam@gmail.com");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            observer.onReservaCreada(null, usuario);
        });

        assertEquals("El mensaje no puede ser nulo.", ex.getMessage());
    }

    // EMR05 - usuario null
    @Test
    void testOnReservaCreada_usuarioNulo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            observer.onReservaCreada("Reserva para el 05/10", null);
        });

        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }

    // EMR05 - mensaje y usuario null
    @Test
    void testOnReservaCreada_mensajeYUsuarioNulo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            observer.onReservaCreada(null, null);
        });

        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }

    // EMR07
    @Test
    void testOnReservaCancelada_mensajeNormal() {
        Usuario usuario = new Usuario(5, "Samuel", "samuel@gmail.com");
        String mensaje = "Reserva cancelada para el 10/05";

        observer.onReservaCancelada(mensaje, usuario);

        String esperado = "Cancelación de reserva TravelStay\nHola Samuel,\n\nReserva cancelada para el 10/05\n\nLamentamos que hayas cancelado. Esperamos verte pronto.";
        assertEquals(esperado, notificador.mensajeEnviado);
        assertEquals(usuario, notificador.usuarioRecibido);
    }

    // EMR08
    @Test
    void testOnReservaCancelada_mensajeVacio() {
        Usuario usuario = new Usuario(6, "Samuel", "samuel@gmail.com");
        String mensaje = "";

        observer.onReservaCancelada(mensaje, usuario);

        String esperado = "Cancelación de reserva TravelStay\nHola Samuel,\n\n\n\nLamentamos que hayas cancelado. Esperamos verte pronto.";
        assertEquals(esperado, notificador.mensajeEnviado);
        assertEquals(usuario, notificador.usuarioRecibido);
    }

    // EMR09
    @Test
    void testOnReservaCancelada_usuarioNulo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            observer.onReservaCancelada("Reserva cancelada", null);
        });

        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }

    // EMR10
    @Test
    void testOnReservaCancelada_mensajeNulo() {
        Usuario usuario = new Usuario(7, "Samuel", "samuel@gmail.com");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            observer.onReservaCancelada(null, usuario);
        });

        assertEquals("El mensaje no puede ser nulo.", ex.getMessage());
    }

    // EMR11
    @Test
    void testOnReservaCancelada_mensajeYUsuarioNulo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            observer.onReservaCancelada(null, null);
        });

        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }

    // EMR12
    @Test
    void testOnReservaCancelada_nombreVacio() {
        Usuario usuario = new Usuario(8, "", "usuario@gmail.com");
        String mensaje = "Reserva cancelada para el 05/10";

        observer.onReservaCancelada(mensaje, usuario);

        String esperado = "Cancelación de reserva TravelStay\nHola ,\n\nReserva cancelada para el 05/10\n\nLamentamos que hayas cancelado. Esperamos verte pronto.";
        assertEquals(esperado, notificador.mensajeEnviado);
        assertEquals(usuario, notificador.usuarioRecibido);
    }
}
