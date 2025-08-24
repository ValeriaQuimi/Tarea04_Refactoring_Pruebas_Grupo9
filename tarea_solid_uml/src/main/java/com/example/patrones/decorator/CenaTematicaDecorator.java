package com.example.patrones.decorator;

import java.util.logging.Logger;

public class CenaTematicaDecorator extends PaqueteDecorator {
    private static final Logger logger = Logger.getLogger(CenaTematicaDecorator.class.getName());
    private double costoCena;

    public CenaTematicaDecorator(IPaqueteTuristico paquete, double costoCena) {
        super(paquete);
        this.costoCena = costoCena;
    }

    @Override
    public double calcularPrecio() {
        return paquete.calcularPrecio() + costoCena;
    }

    @Override
    public void mostrarDetalles() {
        paquete.mostrarDetalles();
        logger.info(" + Cena temática incluida ($" + costoCena + ")");
    }
}
