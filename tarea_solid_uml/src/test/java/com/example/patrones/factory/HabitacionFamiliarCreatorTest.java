package com.example.patrones.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HabitacionFamiliarCreatorTest {
    
    @Test
void crearHabitacionConValoresInvalidosDebeLanzarExcepcion() {
    HabitacionFamiliarCreator creator = new HabitacionFamiliarCreator();
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> creator.crearHabitacion(-1, -100)
    );

    assertTrue(exception.getMessage().toLowerCase().contains("negativo"),
        "El mensaje debe indicar que el valor es negativo");
}

    @Test
    void crearHabitacionConValoresMaximos() {
        HabitacionFamiliarCreator creator = new HabitacionFamiliarCreator();
        Habitacion habitacion = creator.crearHabitacion(Integer.MAX_VALUE, 999);

        assertAll("Validar atributos con valores máximos",
            () -> assertNotNull(habitacion),
            () -> assertEquals(Integer.MAX_VALUE, habitacion.idHotel),
            () -> assertEquals(999, habitacion.numero)
        );
    }

    @Test
    void crearHabitacionConValoresCero() {
        HabitacionFamiliarCreator creator = new HabitacionFamiliarCreator();
        Habitacion habitacion = creator.crearHabitacion(0, 0);

        assertTrue(habitacion.idHotel == 0 && habitacion.numero == 0,
            "Tanto idHotel como número deberían ser cero");
    }

}
