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
            return; // o lanzar una excepción controlada si quieres
        }

        if (gestorDeAccion == null) {
            System.out.println("Error: gestorDeAccion es null. No se puede obtener acción.");
            return;
        }

        System.out.println("Gestionando incidente de: " + incidente.getDescripcion());

        incidente.setEstado(EstadoIncidente.EN_PROCESO);
        System.out.println("Incidente en proceso");

        
        // Se consulta al gestor de acción para decidir qué hacer con el incidente
        String accion = gestorDeAccion.obtenerAccion(incidente);

        // Dependiendo de la acción obtenida, se actúa sobre el incidente
        switch (accion) {
            case "resolver":
                // Si la acción es resolver, llamamos al método correspondiente del incidente
                incidente.resolverIncidente();
                break;
            case "escalar":
                // Si la acción es escalar, llamamos al método de escalamiento
                incidente.escalar();
                break;
            default:
                // Si la acción no es reconocida, mostramos un error
                System.out.println("Acción no válida.");
        }
    }
}
