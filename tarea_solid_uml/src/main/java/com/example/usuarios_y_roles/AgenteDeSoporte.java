package com.example.usuarios_y_roles;

import com.example.enums.EstadoIncidente;
import com.example.interfaces.GestorDeAccion;
import com.example.soporte.Incidente;
import java.util.logging.Logger;

public class AgenteDeSoporte extends Usuario{
    private static final Logger logger = Logger.getLogger(AgenteDeSoporte.class.getName());


    public AgenteDeSoporte(int id, String nombre, Email correo) {
        super(id, nombre, correo);
    }
 
    public void gestionarIncidente(Incidente incidente, GestorDeAccion gestorDeAccion) {
        if (incidente == null) {
            logger.warning("Error: incidente es null. No se puede gestionar.");
            return;
        }

        if (gestorDeAccion == null) {
            logger.warning("Error: gestorDeAccion es null. No se puede obtener acción.");
            return;
        }

        logger.info("Gestionando incidente de: " + incidente.getDescripcion());

        incidente.setEstado(EstadoIncidente.EN_PROCESO);
        logger.info("Incidente en proceso");
        
        String accion = gestorDeAccion.obtenerAccion(incidente);

        switch (accion) {
            case "resolver":
                incidente.resolverIncidente();
                break;
            case "escalar":
                incidente.escalarIncidente();
                break;
            default:
                logger.warning("Acción no válida.");
        }
    }
}
