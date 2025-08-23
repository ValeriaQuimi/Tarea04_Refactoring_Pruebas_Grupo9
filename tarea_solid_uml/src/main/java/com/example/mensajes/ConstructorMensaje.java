package com.example.mensajes;

import com.example.usuarios_y_roles.Usuario;

public class ConstructorMensaje {

    public static String construirReservaCreada(Usuario usuario, String mensaje) {
        return String.format("Hola %s,\n\n%s\n\nGracias por elegir TravelStay.",
                usuario.getNombre(),
                mensaje);
    }

    public static String construirReservaCancelada(Usuario usuario, String mensaje) {
        return String.format("Hola %s,\n\n%s\n\nLamentamos que hayas cancelado. Esperamos verte pronto.",
                usuario.getNombre(),
                mensaje);
    }
}
