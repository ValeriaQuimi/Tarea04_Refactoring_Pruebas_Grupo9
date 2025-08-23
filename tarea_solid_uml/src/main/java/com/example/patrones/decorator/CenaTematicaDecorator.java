package com.example.patrones.decorator;

public class CenaTematicaDecorator extends PaqueteDecorator {
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
        System.out.println(" + Cena temática incluida ($" + costoCena + ")");
    }
}
