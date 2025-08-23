package com.example.interfaces;

import com.example.usuarios_y_roles.Usuario;

public interface Notificador {
    void enviar(String mensaje, Usuario usuario);
}
