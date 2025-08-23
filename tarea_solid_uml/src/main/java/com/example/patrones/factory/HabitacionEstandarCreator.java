package com.example.patrones.factory;

public class HabitacionEstandarCreator implements IHabitacionCreator{
    public Habitacion crearHabitacion(int idHotel, int numero) {
        return new HabitacionEstandar(idHotel, numero);
    }
}
