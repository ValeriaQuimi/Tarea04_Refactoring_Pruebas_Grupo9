package com.example.patrones.factory;

public class HabitacionSuiteCreator implements IHabitacionCreator{
    public Habitacion crearHabitacion(int idHotel, int numero) {
        return new HabitacionSuite(idHotel, numero);
    }
}
