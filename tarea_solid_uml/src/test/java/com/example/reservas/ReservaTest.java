package com.example.reservas;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.hospedaje.Hospedaje;

import com.example.patrones.factory.HabitacionEstandar;
import com.example.usuarios_y_roles.Email;
import com.example.usuarios_y_roles.Usuario;

public class ReservaTest {

    private Usuario usuarioSamuel;
    private Hospedaje hospedaje;
    private HabitacionEstandar habitacion;

    @BeforeEach
    void setUp() {
        Email correo = new Email("axel@example.com");
        usuarioSamuel = new Usuario(1, "Samuel", correo);
        habitacion = new HabitacionEstandar(101, 1);
        hospedaje = new Hospedaje(habitacion);
    }

    // R1
    @Test
    void testConstructor_valido() {
        Reserva reserva = new Reserva(usuarioSamuel, hospedaje);
        assertEquals("pendiente", reserva.getEstado());
        assertNotNull(reserva.getId());
        assertNotNull(reserva.getFecha());
    }

    // R2
    @Test
    void testConstructor_itemNulo() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Reserva(usuarioSamuel, null);
        });
        assertEquals("El ítem a reservar no puede ser nulo", ex.getMessage());
    }

    // r3
    @Test
    void testConstructor_usuarioNulo() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Reserva(null, hospedaje);
        });
        assertEquals("El usuario no puede ser nulo", ex.getMessage());
    }

    // R4
    @Test
    void testConfirmar() {
        Reserva reserva = new Reserva(usuarioSamuel, hospedaje);
        reserva.confirmar();
        assertEquals("confirmada", reserva.getEstado());
    }

    // R5
    @Test
    void testCancelar() {
        Reserva reserva = new Reserva(usuarioSamuel, hospedaje);
        reserva.cancelar();
        assertEquals("cancelada", reserva.getEstado());
    }

    // R6
    @Test
    void testGetUsuario() {
        Reserva reserva = new Reserva(usuarioSamuel, hospedaje);
        Usuario u = reserva.getUsuario();
        assertEquals("Samuel", u.getNombre());
        assertEquals("axel@example.com", u.getCorreo().getValor());
    }

    // R7
    @Test
    void testGetItem() {
        Reserva reserva = new Reserva(usuarioSamuel, hospedaje);
        assertTrue(reserva.getItem() instanceof Hospedaje);
    }

    // R8
    @Test
    void testGetFecha() {
        Reserva reserva = new Reserva(usuarioSamuel, hospedaje);
        LocalDateTime ahora = LocalDateTime.now();
        assertTrue(reserva.getFecha().isBefore(ahora.plusSeconds(2)));
        assertTrue(reserva.getFecha().isAfter(ahora.minusSeconds(2)));
    }

    // R9
    @Test
    void testGetEstado() {
        Reserva reserva = new Reserva(usuarioSamuel, hospedaje);
        assertEquals("pendiente", reserva.getEstado()); // Estado inicial
        reserva.confirmar();
        assertEquals("confirmada", reserva.getEstado()); // Estado después de confirmar
    }

    // R10
    @Test
    void tesGetId() {
        Reserva reserva = new Reserva(usuarioSamuel, hospedaje);
        assertDoesNotThrow(() -> UUID.fromString(reserva.getId()));
    }
}
