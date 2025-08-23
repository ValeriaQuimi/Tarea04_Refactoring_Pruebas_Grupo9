package com.example.hospedaje;

import com.example.patrones.factory.Habitacion;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int id;
    private String nombre;
    private String direccion;
    private List<Habitacion> habitaciones;

    public Hotel(int id, String nombre, String dire){
        habitaciones = new ArrayList<>();
        this.id = id;
        this.nombre = nombre;
        this.direccion = dire;
    }

    public void agregarHabitacion(Habitacion hab){
        habitaciones.add(hab);
    }
    public List<Habitacion> getHabitaciones() {
    return habitaciones;
}
}
