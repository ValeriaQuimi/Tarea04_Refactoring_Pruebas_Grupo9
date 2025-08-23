package com.example.notificaciones;

import com.example.interfaces.Notificador;
import com.example.usuarios_y_roles.Usuario;

public class EmailNotificador implements Notificador {

    public void enviar(String mensaje, Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser null");
        }
        
        if (mensaje == null) {
            throw new IllegalArgumentException("El mensaje no puede ser null");
        }

        System.out.println("Email enviado a " + usuario.getCorreo() + ": " + mensaje);
    }
}
