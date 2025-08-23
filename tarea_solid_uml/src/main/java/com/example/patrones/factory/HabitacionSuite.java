package com.example.patrones.factory;

public class HabitacionSuite extends Habitacion {
    public HabitacionSuite(int idHotel, int numero) {
        super(idHotel, numero);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Habitación SUITE Nº " + numero + " - Hotel ID: " + idHotel + " - Estado: " + estado);
    }

    @Override
    public double calcularPrecio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPrecio'");
    }
}