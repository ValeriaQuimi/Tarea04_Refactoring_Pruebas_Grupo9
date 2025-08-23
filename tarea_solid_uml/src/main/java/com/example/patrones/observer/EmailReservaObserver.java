package com.example.patrones.observer;

import com.example.interfaces.Notificador;
import com.example.usuarios_y_roles.Usuario;

public class EmailReservaObserver implements ReservaObserver {

    private Notificador notificador;

    public EmailReservaObserver(Notificador notificador) {
        if (notificador == null) {
            throw new IllegalArgumentException("El notificador no puede ser nulo.");
        }
        this.notificador = notificador;
    }

    @Override
    public void onReservaCreada(String mensaje, Usuario usuario) {
        if (usuario == null || usuario.getNombre() == null) {
            throw new IllegalArgumentException("El usuario y su nombre no pueden ser nulos.");
        }
        if (mensaje == null) {
            throw new IllegalArgumentException("El mensaje no puede ser nulo.");
        }

        String asunto = "Confirmación de reserva TravelStay";
        String cuerpo = String.format("Hola %s,\n\n%s\n\nGracias por elegir TravelStay.", usuario.getNombre(), mensaje);
        notificador.enviar(asunto + "\n" + cuerpo, usuario);
    }

    @Override
    public void onReservaCancelada(String mensaje, Usuario usuario) {

        if (usuario == null || usuario.getNombre() == null) {
            throw new IllegalArgumentException("El usuario y su nombre no pueden ser nulos.");
        }
        if (mensaje == null) {
            throw new IllegalArgumentException("El mensaje no puede ser nulo.");
        }

        String asunto = "Cancelación de reserva TravelStay";
        String cuerpo = String.format(
                "Hola %s,\n\n%s\n\nLamentamos que hayas cancelado. Esperamos verte pronto.",
                usuario.getNombre(),
                mensaje);
        notificador.enviar(asunto + "\n" + cuerpo, usuario);
    }
}
