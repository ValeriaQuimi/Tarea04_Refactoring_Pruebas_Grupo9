package com.example.turismo_y_paseos;

import com.example.enums.EstadoPaseo;
import com.example.interfaces.Reservable;


public class PaseoTuristico implements Reservable {
    private String nombre;
    private EstadoPaseo estado; // disponible, agotado, cancelado
    private double precioBase;

    public PaseoTuristico(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.estado = EstadoPaseo.DISPONIBLE;
    }

    // Método preparado para lógica de negocio futura
    public double calcularPrecio() {
        return precioBase;
    }

    public boolean verificarDisponibilidad() {
        return estado == EstadoPaseo.DISPONIBLE;
    }

    public void mostrarDetalles() {
        System.out.println("Paseo turístico: " + nombre);
        System.out.println("Precio: $" + precioBase);
        System.out.println("Estado: " + estado);
    }

    // Getters para encapsular campos
    public String getNombre() {
        return nombre;
    }

    public EstadoPaseo getEstado() {
        return estado;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
