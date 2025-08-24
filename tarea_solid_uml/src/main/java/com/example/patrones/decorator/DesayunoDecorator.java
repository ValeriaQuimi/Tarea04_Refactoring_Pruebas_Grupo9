package com.example.patrones.decorator;

import java.util.logging.Logger;

public class DesayunoDecorator extends HabitacionDecorator {
    private static final Logger logger = Logger.getLogger(DesayunoDecorator.class.getName());
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
        super.mostrarDetalles();
        logger.info(" + Desayuno incluido ($" + costoDesayuno + ")");
    }
}
