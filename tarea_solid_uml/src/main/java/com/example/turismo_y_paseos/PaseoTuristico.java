package com.example.turismo_y_paseos;

import com.example.enums.EstadoPaseo;
import com.example.interfaces.Reservable;

public class PaseoTuristico implements Reservable {
    private String nombre;
    private EstadoPaseo estado; // disponible, agotado, cancelado
    private double precio;

    public PaseoTuristico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.estado = EstadoPaseo.DISPONIBLE;
    }

    public double calcularPrecio() {
        return precio;
    }

    public boolean verificarDisponibilidad() {
        if(estado.equals(EstadoPaseo.DISPONIBLE) ) return true;
        else{return false;}    
    }
}