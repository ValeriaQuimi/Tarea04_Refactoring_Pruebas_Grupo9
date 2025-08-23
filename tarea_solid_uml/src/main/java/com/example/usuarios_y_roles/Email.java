package com.example.usuarios_y_roles;

public class Email {
    private final String valor;

    public Email(String valor) {
        if (valor == null || !valor.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Correo electrónico inválido");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Email email = (Email) obj;
        return valor.equals(email.valor);
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }
}
