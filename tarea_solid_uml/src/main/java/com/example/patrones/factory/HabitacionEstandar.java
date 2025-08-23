package com.example.patrones.factory;

public class HabitacionEstandar extends Habitacion {
    public HabitacionEstandar(int idHotel, int numero) {
        super(idHotel, numero);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Habitación ESTÁNDAR Nº " + numero + " - Hotel ID: " + idHotel + " - Estado: " + estado);
    }


    @Override
    public double calcularPrecio() {
        return 80.0;
    }
}