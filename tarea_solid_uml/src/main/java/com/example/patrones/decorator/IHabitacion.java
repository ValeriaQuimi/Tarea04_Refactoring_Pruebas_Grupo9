package com.example.patrones.decorator;

public interface IHabitacion {
    double calcularPrecio();
    void mostrarDetalles();
    boolean estaDisponible();
    void reservar();
}
