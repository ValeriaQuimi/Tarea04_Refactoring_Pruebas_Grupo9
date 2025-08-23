package com.example.patrones.factory;

public interface IHabitacionCreator {
    Habitacion crearHabitacion(int idHotel, int numero);
}