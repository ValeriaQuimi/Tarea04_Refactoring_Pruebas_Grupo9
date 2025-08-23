package com.example.patrones.factory;

import com.example.enums.TipoHabitacion;

public class HabitacionSuite extends Habitacion {
    public HabitacionSuite(int idHotel, int numero) {
        super(idHotel, numero, TipoHabitacion.SUITE);
    }

    @Override
    public double calcularPrecio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPrecio'");
    }
}