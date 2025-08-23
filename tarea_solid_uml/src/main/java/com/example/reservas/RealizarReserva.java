package com.example.reservas;

import java.util.ArrayList;
import java.util.List;

import com.example.interfaces.Reservable;
import com.example.pagos.PagoService;
import com.example.patrones.observer.ReservaObserver;
import com.example.usuarios_y_roles.Usuario;

public class RealizarReserva {
    private PagoService pagoService;
    private List<ReservaObserver> observers;

    public RealizarReserva(PagoService pagoService, List<ReservaObserver> observers) {

        if (pagoService == null) {
            throw new IllegalArgumentException("PagoService no puede ser null");
        }
        if (observers == null) {
            this.observers = new ArrayList<>();
        } else {
            this.observers = observers;
        }
        this.pagoService = pagoService;
    }

    public void ejecutar(Usuario usuario, Reservable item) {
        if (!item.verificarDisponibilidad()) {

            if (!observers.isEmpty()) {
                observers.get(0).onReservaCancelada("El servicio no está disponible.", usuario);
            }
            return;
        }

        double precio = item.calcularPrecio();

        if (pagoService.procesarPago(precio)) {
            Reserva reserva = new Reserva(usuario, item);

            for (ReservaObserver observer : observers) {
                reserva.agregarObserver(observer);
            }

            reserva.confirmar();
        } else {
            // Pago fallido, notificamos con el primer observer (por ejemplo)
            if (!observers.isEmpty()) {
                observers.get(0).onReservaCancelada("El pago ha fallado. Intente nuevamente.", usuario);
            }
        }
    }
}