package com.example.patrones.factory;

import com.example.enums.TipoHabitacion;

public class HabitacionFamiliar extends Habitacion {
    public HabitacionFamiliar(int idHotel, int numero) {
        super(idHotel, numero, TipoHabitacion.FAMILIAR);
    }

    @Override
    public double calcularPrecio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPrecio'");
    }
}