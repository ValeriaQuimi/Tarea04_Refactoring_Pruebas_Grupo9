package com.example.patrones.decorator;

public class DesayunoDecorator extends HabitacionDecorator {
    private double costoDesayuno;

    public DesayunoDecorator(IHabitacion habitacion, double costoDesayuno) {
        super(habitacion);
        if (habitacion == null) {
            throw new NullPointerException("La habitación no puede ser null");
        }
        this.costoDesayuno = costoDesayuno;
    }

    @Override
    public double calcularPrecio() {
        return habitacion.calcularPrecio() + costoDesayuno;
    }

    @Override
    public void mostrarDetalles() {
        habitacion.mostrarDetalles();
        System.out.println(" + Desayuno incluido ($" + costoDesayuno + ")");
    }
}
