package com.example.patrones.decorator;

import java.util.logging.Logger;

public class TrasladoDecorator extends PaqueteDecorator {
    private static final Logger logger = Logger.getLogger(TrasladoDecorator.class.getName());
    private double costoTraslado;

    public TrasladoDecorator(IPaqueteTuristico paquete, double costoTraslado) {
        super(paquete);
        this.costoTraslado = costoTraslado;
    }

    @Override
    public double calcularPrecio() {
        return paquete.calcularPrecio() + costoTraslado;
    }

    @Override
    public void mostrarDetalles() {
        paquete.mostrarDetalles();
        logger.info(" + Traslado incluido ($" + costoTraslado + ")");
    }
}
