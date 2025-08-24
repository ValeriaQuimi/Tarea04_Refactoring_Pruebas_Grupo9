package com.example.patrones.decorator;

import java.util.logging.Logger;

public class AccesoExclusivoDecorator extends HabitacionDecorator {
    private static final Logger logger = Logger.getLogger(AccesoExclusivoDecorator.class.getName());
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
        super.mostrarDetalles();
        logger.info(" + Acceso a áreas exclusivas ($" + costoAcceso + ")");
    }
}
