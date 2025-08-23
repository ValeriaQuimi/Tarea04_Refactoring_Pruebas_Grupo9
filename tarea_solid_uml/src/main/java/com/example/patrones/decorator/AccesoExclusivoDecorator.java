package com.example.patrones.decorator;

public class AccesoExclusivoDecorator extends HabitacionDecorator {
    private double costoAcceso;

    public AccesoExclusivoDecorator(IHabitacion habitacion, double costoAcceso) {
        super(habitacion);
        this.costoAcceso = costoAcceso;
    }

    @Override
    public double calcularPrecio() {
        return habitacion.calcularPrecio() + costoAcceso;
    }

    @Override
    public void mostrarDetalles() {
        habitacion.mostrarDetalles();
        System.out.println(" + Acceso a áreas exclusivas ($" + costoAcceso + ")");
    }
}
