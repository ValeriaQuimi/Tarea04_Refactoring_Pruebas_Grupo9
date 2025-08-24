package com.example.usuarios_y_roles;

import com.example.enums.EstadoIncidente;
import com.example.interfaces.GestorDeAccion;
import com.example.soporte.Incidente;

public class AgenteDeSoporte extends Usuario{


    public AgenteDeSoporte(int id, String nombre, Email correo) {
        super(id, nombre, correo);
    }
 
    public void gestionarIncidente(Incidente incidente, GestorDeAccion gestorDeAccion) {
        if (incidente == null) {
            System.out.println("Error: incidente es null. No se puede gestionar.");
            return;
        }

        if (gestorDeAccion == null) {
            System.out.println("Error: gestorDeAccion es null. No se puede obtener acción.");
            return;
        }

        System.out.println("Gestionando incidente de: " + incidente.getDescripcion());

        incidente.setEstado(EstadoIncidente.EN_PROCESO);
        System.out.println("Incidente en proceso");
        
        String accion = gestorDeAccion.obtenerAccion(incidente);

        switch (accion) {
            case "resolver":
                incidente.resolverIncidente();
                break;
            case "escalar":
                incidente.escalarIncidente();
                break;
            default:
                System.out.println("Acción no válida.");
        }
    }
}
