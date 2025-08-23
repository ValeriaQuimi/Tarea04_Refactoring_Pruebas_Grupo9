package com.example.patrones.decorator;

import com.example.hospedaje.Hospedaje;
import com.example.patrones.factory.HabitacionEstandar;
import com.example.turismo_y_paseos.PaseoTuristico;
import com.example.turismo_y_paseos.PaqueteTuristico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CenaTematicaDecoratorTest {

    @Test
    void testPrecioConCenaTematica() {
        IHabitacion hab = new HabitacionEstandar(1, 201);
        Hospedaje hospedaje = new Hospedaje(hab);
        PaseoTuristico paseo = new PaseoTuristico("Tour Cultural", 80.0);
        PaqueteTuristico paqueteBase = new PaqueteTuristico(hospedaje, paseo, 10.0);
        IPaqueteTuristico paquete = new CenaTematicaDecorator(paqueteBase, 50.0);
    assertEquals(200.0, paquete.calcularPrecio(), 0.01);
    }

    @Test
    void testDetallesIncluyenCena() {
        IHabitacion hab = new HabitacionEstandar(1, 202);
        Hospedaje hospedaje = new Hospedaje(hab);
        PaseoTuristico paseo = new PaseoTuristico("Tour Cultural", 80.0);
        PaqueteTuristico paqueteBase = new PaqueteTuristico(hospedaje, paseo, 10.0);
        IPaqueteTuristico paquete = new CenaTematicaDecorator(paqueteBase, 50.0);
        // Solo verificamos que no lanza excepción y muestra detalles
        assertDoesNotThrow(paquete::mostrarDetalles);
    }

    @Test
    void testCombinacionConSpaYCena() {
        IHabitacion hab = new HabitacionEstandar(1, 203);
        Hospedaje hospedaje = new Hospedaje(hab);
        PaseoTuristico paseo = new PaseoTuristico("Tour Cultural", 80.0);
        PaqueteTuristico paqueteBase = new PaqueteTuristico(hospedaje, paseo, 10.0);
        IPaqueteTuristico paquete = new CenaTematicaDecorator(paqueteBase, 50.0);
        paquete = new SpaDecorator(paquete, 70.0);
    assertEquals(270.0, paquete.calcularPrecio(), 0.01);
    }
}
