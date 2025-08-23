package com.example.reservas;

import java.time.LocalDateTime;

import com.example.interfaces.Reservable;
import com.example.patrones.observer.ReservaSubject;
import com.example.usuarios_y_roles.Usuario;

public class Reserva extends ReservaSubject {
    private Usuario usuario;
    private Reservable item;
    private LocalDateTime fecha;
    private String estado;
    private String id;

    public Reserva(Usuario usuario, Reservable item) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        if (item == null) {
            throw new IllegalArgumentException("El ítem a reservar no puede ser nulo");
        }
        this.usuario = usuario;
        this.item = item;
        this.fecha = LocalDateTime.now();
        this.estado = "pendiente";
        this.id = java.util.UUID.randomUUID().toString();
    }

    public void confirmar() {
        this.estado = "confirmada";
        notificarReservaCreada("Reserva confirmada ID: " + id, usuario);
    }

    public void cancelar() {
        this.estado = "cancelada";
        notificarReservaCancelada("Reserva cancelada ID: " + id, usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Reservable getItem() {
        return item;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public String getId() {
        return id;
    }

}
