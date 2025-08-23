package com.example.patrones.decorator;

public class SpaDecorator extends PaqueteDecorator {
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
        System.out.println(" + Paquete de spa incluido ($" + costoSpa + ")");
    }
}
