package com.example.mensajes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.usuarios_y_roles.Email;
import com.example.usuarios_y_roles.Usuario;

public class ConstructorMensajeTest {

    // CM01
    @Test
    void testConstruirReservaCreadaMensajeNormal() {
        Usuario usuario = new Usuario(1, "Miriam", new Email("miriam@example.com"));
        String mensaje = "Reserva confirmada para el 05/10";

        String resultado = ConstructorMensaje.construirReservaCreada(usuario, mensaje);

        String esperado = "Hola Miriam,\n\nReserva confirmada para el 05/10\n\nGracias por elegir TravelStay.";
        assertEquals(esperado, resultado);
    }

    // CM02
    @Test
    void testConstruirReservaCreadaMensajeVacio() {
        Usuario usuario = new Usuario(2, "Miriam", new Email("miriam@example.com"));
        String mensaje = "";

        String resultado = ConstructorMensaje.construirReservaCreada(usuario, mensaje);

        String esperado = "Hola Miriam,\n\n\n\nGracias por elegir TravelStay.";
        assertEquals(esperado, resultado);
    }

    // CM03
    @Test
    void testConstruirReservaCreadaNombreVacio() {
        Usuario usuario = new Usuario(3, "", new Email("usuario3@example.com"));
        String mensaje = "Reserva para el 05/10";

        String resultado = ConstructorMensaje.construirReservaCreada(usuario, mensaje);

        String esperado = "Hola ,\n\nReserva para el 05/10\n\nGracias por elegir TravelStay.";
        assertEquals(esperado, resultado);
    }

    // CM04
    @Test
    void testConstruirReservaCanceladaMensajeNormal() {
        Usuario usuario = new Usuario(4, "Samuel", new Email("samuel@example.com"));
        String mensaje = "Reserva cancelada para el 10/05";

        String resultado = ConstructorMensaje.construirReservaCancelada(usuario, mensaje);

        String esperado = "Hola Samuel,\n\nReserva cancelada para el 10/05\n\nLamentamos que hayas cancelado. Esperamos verte pronto.";
        assertEquals(esperado, resultado);
    }

    // CM05
    @Test
    void testConstruirReservaCanceladaMensajeVacio() {
        Usuario usuario = new Usuario(5, "Samuel", new Email("samuel@example.com"));
        String mensaje = "";

        String resultado = ConstructorMensaje.construirReservaCancelada(usuario, mensaje);

        String esperado = "Hola Samuel,\n\n\n\nLamentamos que hayas cancelado. Esperamos verte pronto.";
        assertEquals(esperado, resultado);
    }

    // CM06
    @Test
    void testConstruirReservaCanceladaNombreVacio() {
        Usuario usuario = new Usuario(6, "", new Email("samuel@example.com"));
        String mensaje = "Reserva cancelada para el 05/10";

        String resultado = ConstructorMensaje.construirReservaCancelada(usuario, mensaje);

        String esperado = "Hola ,\n\nReserva cancelada para el 05/10\n\nLamentamos que hayas cancelado. Esperamos verte pronto.";
        assertEquals(esperado, resultado);
    }
}
