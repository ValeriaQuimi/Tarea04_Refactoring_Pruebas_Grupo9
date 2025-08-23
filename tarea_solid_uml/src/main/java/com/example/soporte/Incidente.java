package com.example.soporte;

import com.example.enums.EstadoIncidente;
import com.example.usuarios_y_roles.Usuario;

public class Incidente {

    private int id;
    private Usuario usuarioReportante; 
    private String descripcion;
    private EstadoIncidente estado;


    public Incidente(int id, Usuario usuarioReportante, String descripcion) {
        this.id = id;
        this.usuarioReportante= usuarioReportante;
        this.descripcion = descripcion;
        this.estado = EstadoIncidente.NUEVO;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuarioReportante() {
        return usuarioReportante;
    }

    public void setUsuarioReportante(Usuario usuarioReportante) {
        this.usuarioReportante = usuarioReportante;
    }

    public EstadoIncidente getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidente estado) {
        this.estado = estado;
    }

    public void resolverIncidente(){
        this.estado= EstadoIncidente.RESUELTO;
        System.out.println("Incidente resuelto");

    }

    public void escalar(){
        this.estado= EstadoIncidente.ESCALADO;
        System.out.println("Incidente escalado");

    }
    
}
