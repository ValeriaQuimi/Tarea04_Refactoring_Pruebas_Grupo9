package com.example.usuarios_y_roles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @Test
    public void testCrearEmailValido() {
        Email email = new Email("test@mail.com");
        assertEquals("test@mail.com", email.getValor());
    }

    @Test
    public void testCrearEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Email("noemail");
        });
    }

    @Test
    public void testCrearEmailNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Email(null);
        });
    }

    @Test
    public void testEqualsYHashCode() {
        Email email1 = new Email("a@mail.com");
        Email email2 = new Email("a@mail.com");
        Email email3 = new Email("b@mail.com");
        assertEquals(email1, email2);
        assertEquals(email1.hashCode(), email2.hashCode());
        assertNotEquals(email1, email3);
    }

    @Test
    public void testToString() {
        Email email = new Email("string@mail.com");
        assertEquals("string@mail.com", email.toString());
    }
}
