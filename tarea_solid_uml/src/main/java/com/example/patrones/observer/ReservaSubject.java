package com.example.patrones.observer;

import java.util.ArrayList;
import java.util.List;

import com.example.usuarios_y_roles.Usuario;

public class ReservaSubject {

    private List<ReservaObserver> observers = new ArrayList<>();

    public void agregarObserver(ReservaObserver observer) {

        if (observer == null) {
            throw new IllegalArgumentException("Observer no puede ser null");
        }

        observers.add(observer);
    }

    public void removerObserver(ReservaObserver observer) {

        if (observer == null) {
            throw new IllegalArgumentException("Observer no puede ser null");
        }

        observers.remove(observer);

    }

    public void notificarReservaCreada(String mensaje, Usuario usuario) {

        if (mensaje == null || usuario == null) {
            throw new IllegalArgumentException("Mensaje y Usuario no pueden ser null");
        }

        for (ReservaObserver observer : observers) {
            observer.onReservaCreada(mensaje, usuario);
        }
    }

    public void notificarReservaCancelada(String mensaje, Usuario usuario) {

        if (mensaje == null || usuario == null) {
            throw new IllegalArgumentException("Mensaje y Usuario no pueden ser null");
        }

        for (ReservaObserver observer : observers) {
            observer.onReservaCancelada(mensaje, usuario);
        }
    }

}
