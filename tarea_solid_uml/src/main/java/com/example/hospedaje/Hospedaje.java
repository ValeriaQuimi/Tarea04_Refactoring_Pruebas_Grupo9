package com.example.hospedaje;

import com.example.patrones.decorator.IHabitacion;
import com.example.interfaces.Reservable;

public class Hospedaje implements Reservable {
    private IHabitacion habitacion;

    public Hospedaje(IHabitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public double calcularPrecio() {
        return habitacion.calcularPrecio();
    }

    @Override
    public boolean verificarDisponibilidad() {
        return habitacion.estaDisponible();
    }

    public void mostrarDetalles() {
        System.out.println("Hospedaje:");
        if (habitacion != null) {
            habitacion.mostrarDetalles();
        }
    }

    public void bloquearTemporalmente() {
        if (habitacion.estaDisponible()) {
            habitacion.reservar();
        }
    }

    public IHabitacion getHabitacion() {
        return habitacion;
    }

}
