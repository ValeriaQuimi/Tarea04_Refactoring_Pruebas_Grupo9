/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.pagos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SRoman
 */
public class PagoServiceTest {
    /**
     * Test of procesarPago method, of class PagoService.
     */
    @Test
    void testProcesarPagoMontoPositivo() {
        PagoService pagoService = new PagoService();
        double monto = 100.0;
        boolean resultado = pagoService.procesarPago(monto);
        assertTrue(resultado, "El pago con monto positivo debe procesarse correctamente");
    }

    @Test
    void testProcesarPagoMontoCero() {
        PagoService pagoService = new PagoService();
        double monto = 0.0;
        boolean resultado = pagoService.procesarPago(monto);
        assertTrue(resultado, "El pago con monto cero debe procesarse (según implementación actual)");
    }

    @Test
    void testProcesarPagoMontoNegativo() {
        PagoService pagoService = new PagoService();
        double monto = -50.0;
        boolean resultado = pagoService.procesarPago(monto);
        assertTrue(resultado, "Actualmente la implementación no valida monto negativo, devuelve true");
    }

}
