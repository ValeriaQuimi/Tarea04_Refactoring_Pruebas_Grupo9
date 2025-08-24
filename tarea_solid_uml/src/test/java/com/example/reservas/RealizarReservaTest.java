package com.example.reservas;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.interfaces.Reservable;
import com.example.pagos.PagoService;
import com.example.patrones.observer.ReservaObserver;
import com.example.usuarios_y_roles.Email;
import com.example.usuarios_y_roles.Usuario;

public class RealizarReservaTest {

    static class PagoServiceTest extends PagoService {
        private boolean resultadoPago;

        public PagoServiceTest(boolean resultadoPago) {
            this.resultadoPago = resultadoPago;
        }

        @Override
        public boolean procesarPago(double monto) {
            return resultadoPago;
        }
    }

    // Clase test para Reservable
    static class ReservableTest implements Reservable {
        boolean disponible;
        double precio;

        ReservableTest(boolean disponible, double precio) {
            this.disponible = disponible;
            this.precio = precio;
        }

        @Override
        public boolean verificarDisponibilidad() {
            return disponible;
        }

        @Override
        public double calcularPrecio() {
            return precio;
        }
    }

    // Clase test para ReservaObserver 
    static class ReservaObserverTest implements ReservaObserver {
        boolean canceladoLlamado = false;
        String mensajeCancelado = null;
        Usuario usuarioCancelado = null;

        @Override
        public void onReservaCreada(String mensaje, Usuario usuario) {
            // No se usa en estas pruebas
        }

        @Override
        public void onReservaCancelada(String mensaje, Usuario usuario) {
            canceladoLlamado = true;
            mensajeCancelado = mensaje;
            usuarioCancelado = usuario;
        }
    }

    Usuario usuario;

    @BeforeEach
    void setUp() {
        Email correo = new Email("axel@example.com");
        usuario = new Usuario(1, "Samuel", correo);
    }

    // RR1 - Item no disponible 
    @Test
    void testEjecutar_itemNoDisponible() {
        PagoServiceTest pagoService = new PagoServiceTest(true);
        ReservaObserverTest observer = new ReservaObserverTest();
        List<ReservaObserver> observers = new ArrayList<>();
        observers.add(observer);

        RealizarReserva rr = new RealizarReserva(pagoService, observers);

        ReservableTest item = new ReservableTest(false, 100.0);

        rr.ejecutar(usuario, item);

        assertTrue(observer.canceladoLlamado);
        assertEquals("El servicio no está disponible.", observer.mensajeCancelado);
        assertEquals(usuario, observer.usuarioCancelado);
    }

    // RR2 - Item disponible y pago exitoso 
    @Test
    void testEjecutar_itemDisponible() {
        PagoServiceTest pagoService = new PagoServiceTest(true);
        ReservaObserverTest observer = new ReservaObserverTest();
        List<ReservaObserver> observers = new ArrayList<>();
        observers.add(observer);

        RealizarReserva rr = new RealizarReserva(pagoService, observers);

        ReservableTest item = new ReservableTest(true, 100.0);

        rr.ejecutar(usuario, item);

        assertFalse(observer.canceladoLlamado);
    }

    // RR3 - Item disponible y pago fallido 
    @Test
    void tesEjecutar_itemDisponible_pagoFallido() {
        PagoServiceTest pagoService = new PagoServiceTest(false);
        ReservaObserverTest observer = new ReservaObserverTest();
        List<ReservaObserver> observers = new ArrayList<>();
        observers.add(observer);

        RealizarReserva rr = new RealizarReserva(pagoService, observers);

        ReservableTest item = new ReservableTest(true, 100.0);

        rr.ejecutar(usuario, item);

        assertTrue(observer.canceladoLlamado);
        assertEquals("El pago ha fallado. Intente nuevamente.", observer.mensajeCancelado);
        assertEquals(usuario, observer.usuarioCancelado);
    }

    // RR4 - Constructor con PagoService null 
    @Test
    void testConstructor_pagoServiceNull() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new RealizarReserva(null, null);
        });
        assertEquals("PagoService no puede ser null", ex.getMessage());
    }

    // RR5 - Constructor con observers null 
    @Test
    void testConstructor_observersNull() {
        PagoServiceTest pagoService = new PagoServiceTest(true);
        RealizarReserva rr = new RealizarReserva(pagoService, null);
        assertNotNull(rr);

        // Ejecutar método para verificar que no falla con observers vacíos
        ReservableTest item = new ReservableTest(false, 50.0);
        Email correo1 = new Email("ana@mail.com");
        Usuario otroUsuario = new Usuario(2, "Ana", correo1);

        assertDoesNotThrow(() -> rr.ejecutar(otroUsuario, item));
    }

}
