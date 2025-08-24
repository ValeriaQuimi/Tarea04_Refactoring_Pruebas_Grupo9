package com.example.turismo_y_paseos;

import com.example.hospedaje.Hospedaje;
import com.example.patrones.decorator.IPaqueteTuristico;

import java.util.logging.Logger;

public class PaqueteTuristico implements IPaqueteTuristico {
    private static final Logger logger = Logger.getLogger(PaqueteTuristico.class.getName());
    private Hospedaje hospedaje;
    private PaseoTuristico paseo;
    private double descuento;

    public PaqueteTuristico(Hospedaje hospedaje, PaseoTuristico paseo, double descuento) {
        this.hospedaje = hospedaje;
        this.paseo = paseo;
        this.descuento = descuento;
    }

    @Override
    public double calcularPrecio() {
        if (hospedaje.getHabitacion() != null) {
            return hospedaje.getHabitacion().calcularPrecio() + paseo.calcularPrecio() - descuento;
        }
        else{ return  paseo.calcularPrecio() - descuento; }
    }

    @Override
    public boolean verificarDisponibilidad() {
        return hospedaje.verificarDisponibilidad() && paseo.verificarDisponibilidad();
    }
    @Override
    public void mostrarDetalles() {
        logger.info("Paquete turístico:");
        if (hospedaje != null) {
            hospedaje.mostrarDetalles();
        }
        if (paseo != null) {
            paseo.mostrarDetalles();
        }
        logger.info("Descuento aplicado: $" + descuento);
    }


}
