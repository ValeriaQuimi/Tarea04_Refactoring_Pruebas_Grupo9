package com.example.patrones.observer;

import com.example.usuarios_y_roles.Usuario;

public interface ReservaObserver {

    void onReservaCreada(String mensaje, Usuario usuario);

    void onReservaCancelada(String mensaje, Usuario usuario);
}
