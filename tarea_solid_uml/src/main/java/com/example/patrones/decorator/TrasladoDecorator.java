package com.example.patrones.decorator;

public class TrasladoDecorator extends PaqueteDecorator {
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
        System.out.println(" + Traslado incluido ($" + costoTraslado + ")");
    }
}
