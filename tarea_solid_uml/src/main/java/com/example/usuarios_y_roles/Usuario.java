package com.example.usuarios_y_roles;

public class Usuario {
    private int id;
    private String nombre;
    private Email correo;

    public Usuario(int id, String nombre, Email correo) {
        if (correo == null) {
            throw new NullPointerException("El correo no puede ser null");
        }
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }


    public Email getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}
