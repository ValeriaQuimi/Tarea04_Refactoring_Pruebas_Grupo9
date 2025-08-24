package com.example.patrones.decorator;

import java.util.logging.Logger;

public class SpaDecorator extends PaqueteDecorator {
    private static final Logger logger = Logger.getLogger(SpaDecorator.class.getName());
    private double costoSpa;

    public SpaDecorator(IPaqueteTuristico paquete, double costoSpa) {
        super(paquete);
        this.costoSpa = costoSpa;
    }

    @Override
    public double calcularPrecio() {
        return paquete.calcularPrecio() + costoSpa;
    }

    @Override
    public void mostrarDetalles() {
        paquete.mostrarDetalles();
        logger.info(" + Paquete de spa incluido ($" + costoSpa + ")");
    }
}
