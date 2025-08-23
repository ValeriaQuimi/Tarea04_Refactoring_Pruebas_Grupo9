package com.example.validaciones;



import com.example.patrones.observer.ReservaObserver;
import com.example.usuarios_y_roles.Usuario;

public class Validador {
    
    public static void validarReserva(Usuario usuario, String mensaje) {
        if (usuario == null || usuario.getNombre() == null) {
            throw new IllegalArgumentException("El usuario y su nombre no pueden ser nulos.");
        }
        if (mensaje == null) {
            throw new IllegalArgumentException("El mensaje no puede ser nulo.");
        }
    }

    public static void validarObsever(ReservaObserver observer){
         if (observer == null) {
            throw new IllegalArgumentException("Observer no puede ser null");
        }
    }
}
