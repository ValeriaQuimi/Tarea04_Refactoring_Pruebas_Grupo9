package com.example.patrones.observer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.usuarios_y_roles.Email;
import com.example.usuarios_y_roles.Usuario;

public class ReservaSubjectTest {

    static class TestObserver implements ReservaObserver {
        String mensajeRecibido;
        Usuario usuarioRecibido;
        boolean llamadaCreada = false;
        boolean llamadaCancelada = false;

        @Override
        public void onReservaCreada(String mensaje, Usuario usuario) {
            llamadaCreada = true;
            mensajeRecibido = mensaje;
            usuarioRecibido = usuario;
        }

        @Override
        public void onReservaCancelada(String mensaje, Usuario usuario) {
            llamadaCancelada = true;
            mensajeRecibido = mensaje;
            usuarioRecibido = usuario;
        }
    }

    ReservaSubject reservaSubject;
    TestObserver testObserver;
    Usuario usuario;

    @BeforeEach
    void setUp() {
        reservaSubject = new ReservaSubject();
        testObserver = new TestObserver();
        usuario = new Usuario(1, "Samuel", new Email("samuel@gmail.com"));
    }

    // RS1
    @Test
    void testAgregarObserver_valido() {
        reservaSubject.agregarObserver(testObserver);
        reservaSubject.notificarReservaCreada("Reserva creada para el 10/05", usuario);

        assertAll(
                () -> assertTrue(testObserver.llamadaCreada),
                () -> assertEquals("Reserva creada para el 10/05", testObserver.mensajeRecibido),
                () -> assertSame(usuario, testObserver.usuarioRecibido) 
        );
    }

    // RS2
    @Test
    void testAgregarObserver_null() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            reservaSubject.agregarObserver(null);
        });
        assertEquals("Observer no puede ser null", ex.getMessage());
    }

    // RS3
    @Test
    void testRemoverObserver_observerExistente() {
        reservaSubject.agregarObserver(testObserver);
        reservaSubject.removerObserver(testObserver);
        reservaSubject.notificarReservaCreada("Reserva creada para el 10/05", usuario);
        assertFalse(testObserver.llamadaCreada);
    }

    // RS4
    @Test
    void testRemoverObserver_null() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            reservaSubject.removerObserver(null);
        });
        assertEquals("Observer no puede ser null", ex.getMessage());
    }

    // RS5
    @Test
    void testNotificarReservaCreada_valido() {
        reservaSubject.agregarObserver(testObserver);
        reservaSubject.notificarReservaCreada("Reserva creada para el 10/05", usuario);
        assertTrue(testObserver.llamadaCreada);
        assertEquals("Reserva creada para el 10/05", testObserver.mensajeRecibido);
        assertEquals(usuario, testObserver.usuarioRecibido);
    }

    // RS6
    @Test
    void testNotificarReservaCreada_mensajeYUsuarioNull() {
        reservaSubject.agregarObserver(testObserver);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            reservaSubject.notificarReservaCreada(null, null);
        });
        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }

    // RS7
    @Test
    void testNotificarReservaCreada_usuarioNull() {
        reservaSubject.agregarObserver(testObserver);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            reservaSubject.notificarReservaCreada("Reserva creada para el 10/05", null);
        });
        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }

    // RS8
    @Test
    void testNotificarReservaCancelada_valido() {
        reservaSubject.agregarObserver(testObserver);
        reservaSubject.notificarReservaCancelada("Reserva cancelada para el 10/05", usuario);
        assertTrue(testObserver.llamadaCancelada);
        assertEquals("Reserva cancelada para el 10/05", testObserver.mensajeRecibido);
        assertEquals(usuario, testObserver.usuarioRecibido);
    }

    // RS9
    @Test
    void testNotificarReservaCancelada_mensajeYUsuarioNull() {
        reservaSubject.agregarObserver(testObserver);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            reservaSubject.notificarReservaCancelada(null, null);
        });
        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }

    // RS10
    @Test
    void testNotificarReservaCancelada_usuarioNull() {
        reservaSubject.agregarObserver(testObserver);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            reservaSubject.notificarReservaCancelada("Reserva cancelada para el 10/05", null);
        });
        assertEquals("El usuario y su nombre no pueden ser nulos.", ex.getMessage());
    }
}
