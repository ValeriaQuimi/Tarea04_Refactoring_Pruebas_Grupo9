package com.example.patrones.decorator;

public abstract class HabitacionDecorator implements IHabitacion {
    protected IHabitacion habitacion;

    protected HabitacionDecorator(IHabitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public double calcularPrecio() {
        return habitacion.calcularPrecio();
    }

    @Override
    public void mostrarDetalles() {
        habitacion.mostrarDetalles();
    }

    @Override
    public boolean estaDisponible() {
        return habitacion.estaDisponible();
    }

    @Override
    public void reservar() {
        habitacion.reservar();
    }
}
