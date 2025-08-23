package com.example.patrones.observer;

import com.example.interfaces.Notificador;
import com.example.mensajes.ConstructorMensaje;
import com.example.usuarios_y_roles.Usuario;
import com.example.validaciones.Validador;

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
       
        Validador.validarReserva(usuario, mensaje);
        String asunto = "Confirmación de reserva TravelStay";
        String cuerpo = ConstructorMensaje.construirReservaCreada(usuario, mensaje);
        notificador.enviar(asunto + "\n" + cuerpo, usuario);
    }

    @Override
    public void onReservaCancelada(String mensaje, Usuario usuario) {

        Validador.validarReserva(usuario, mensaje);

        String asunto = "Cancelación de reserva TravelStay";
        String cuerpo = ConstructorMensaje.construirReservaCancelada(usuario, mensaje);
        notificador.enviar(asunto + "\n" + cuerpo, usuario);
    }
}
