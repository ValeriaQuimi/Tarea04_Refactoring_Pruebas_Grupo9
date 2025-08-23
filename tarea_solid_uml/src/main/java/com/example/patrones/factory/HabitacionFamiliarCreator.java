
package com.example.patrones.factory;

public class HabitacionFamiliarCreator implements IHabitacionCreator {
    public Habitacion crearHabitacion(int idHotel, int numero) {
        return new HabitacionFamiliar(idHotel, numero);
    }
}