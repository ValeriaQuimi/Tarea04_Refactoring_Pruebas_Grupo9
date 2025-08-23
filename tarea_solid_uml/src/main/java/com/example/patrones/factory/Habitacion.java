
package com.example.patrones.factory;

import com.example.enums.EstadoHabitacion;
import com.example.patrones.decorator.IHabitacion;

public abstract class Habitacion implements IHabitacion {
    protected int idHotel;
    protected int numero;
    protected EstadoHabitacion estado; // disponible, reservada, ocupada, mantenimiento

    public Habitacion(int idHotel, int numero) {
        if (idHotel < 0) {
            throw new IllegalArgumentException("El id del hotel no puede ser negativo");
        }
        if (numero < 0) {
            throw new IllegalArgumentException("El número de habitación no puede ser negativo");
        }
        this.idHotel = idHotel;
        this.numero = numero;
        this.estado = EstadoHabitacion.DISPONIBLE;
    }

    public boolean estaDisponible() {
        return estado.equals(EstadoHabitacion.DISPONIBLE);

    }

    public void reservar() {
        this.estado = EstadoHabitacion.RESERVADA;
    }

}
