package com.example.patrones.decorator;

public abstract class PaqueteDecorator implements IPaqueteTuristico {
    protected IPaqueteTuristico paquete;

    protected PaqueteDecorator(IPaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    @Override
    public double calcularPrecio() {
        return paquete.calcularPrecio();
    }

    @Override
    public void mostrarDetalles() {
        paquete.mostrarDetalles();
    }

    @Override
    public boolean verificarDisponibilidad() {
        return paquete.verificarDisponibilidad();
    }
}
