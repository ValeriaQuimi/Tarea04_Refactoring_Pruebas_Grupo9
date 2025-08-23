package com.example.patrones.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HabitacionEstandarCreatorTest {

    @Test
    void crearHabitacionSinError() {
        HabitacionEstandarCreator creator = new HabitacionEstandarCreator();
        Habitacion habitacion = creator.crearHabitacion(4, 404);

        assertNotNull(habitacion);
        assertEquals(4, habitacion.idHotel);
        assertEquals(404, habitacion.numero);
        assertTrue(habitacion instanceof HabitacionEstandar);
    }
    
    @Test
    void crearHabitacionConNumerosGrandes() {
        HabitacionEstandarCreator creator = new HabitacionEstandarCreator();
        Habitacion habitacion = creator.crearHabitacion(9999, 999);

        assertAll(
            () -> assertNotNull(habitacion, "La habitación no debería ser nula"),
            () -> assertEquals(9999, habitacion.idHotel, "El id del hotel no coincide"),
            () -> assertEquals(999, habitacion.numero, "El número de la habitación no coincide")
        );
    }
    @Test
    void crearHabitacionConValoresLimite() {
        HabitacionEstandarCreator creator = new HabitacionEstandarCreator();
        Habitacion habitacion = creator.crearHabitacion(0, 0);

        assertNotNull(habitacion, "La habitación debería crearse incluso con valores límite");
        assertEquals(0, habitacion.idHotel);
        assertEquals(0, habitacion.numero);
    }

    @Test
    void lanzarExcepcionSiNumeroNegativo() {
        HabitacionEstandarCreator creator = new HabitacionEstandarCreator();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            // Aquí asumimos que HabitacionEstandar lanza excepción si el número es negativo
            creator.crearHabitacion(1, -10);
        });
        assertTrue(ex.getMessage().contains("número de habitación"));
    }
}

