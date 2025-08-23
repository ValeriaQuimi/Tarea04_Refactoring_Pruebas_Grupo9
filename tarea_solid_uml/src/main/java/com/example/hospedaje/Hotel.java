package com.example.hospedaje;

import com.example.patrones.factory.Habitacion;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int id;
    private String nombre;
    private String direccion;
    private List<Habitacion> habitaciones;

    public Hotel(int id, String nombre, String dire) {

        if (nombre == null || dire == null) {
            throw new IllegalArgumentException("Los parametros no pueden ser nulos");
        }

        habitaciones = new ArrayList<>();
        this.id = id;
        this.nombre = nombre;
        this.direccion = dire;
    }

    public void agregarHabitacion(Habitacion hab) {
        if (hab == null) {
            throw new IllegalArgumentException("La habitacion no puede ser null");
        }
        habitaciones.add(hab);
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}
