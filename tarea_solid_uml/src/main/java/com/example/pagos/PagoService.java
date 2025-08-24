package com.example.pagos;

import java.util.logging.Logger;

public class PagoService {
    private static final Logger logger = Logger.getLogger(PagoService.class.getName());

    public boolean procesarPago(double monto) {
        logger.info("Procesando pago: $" + monto);
        return true;
    }
}
