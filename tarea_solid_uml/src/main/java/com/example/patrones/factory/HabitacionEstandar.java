package com.example.patrones.factory;

import com.example.enums.TipoHabitacion;

public class HabitacionEstandar extends Habitacion {
    public HabitacionEstandar(int idHotel, int numero) {
        super(idHotel, numero, TipoHabitacion.ESTANDAR);
    }

    @Override
    public double calcularPrecio() {
        return 80.0;
    }
}