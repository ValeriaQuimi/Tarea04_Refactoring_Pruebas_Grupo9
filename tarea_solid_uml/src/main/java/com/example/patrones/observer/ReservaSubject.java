package com.example.patrones.observer;

import java.util.ArrayList;
import java.util.List;

import com.example.usuarios_y_roles.Usuario;
import com.example.validaciones.Validador;

public class ReservaSubject {

    private List<ReservaObserver> observers = new ArrayList<>();

    public void agregarObserver(ReservaObserver observer) {
        
        Validador.validarObsever(observer);
        observers.add(observer);
    }

    public void removerObserver(ReservaObserver observer) {
        
        Validador.validarObsever(observer);
        observers.remove(observer);

    }

    public void notificarReservaCreada(String mensaje, Usuario usuario) {

       Validador.validarReserva(usuario, mensaje);

        for (ReservaObserver observer : observers) {
            observer.onReservaCreada(mensaje, usuario);
        }
    }

    public void notificarReservaCancelada(String mensaje, Usuario usuario) {

        Validador.validarReserva(usuario, mensaje);

        for (ReservaObserver observer : observers) {
            observer.onReservaCancelada(mensaje, usuario);
        }
    }

}
