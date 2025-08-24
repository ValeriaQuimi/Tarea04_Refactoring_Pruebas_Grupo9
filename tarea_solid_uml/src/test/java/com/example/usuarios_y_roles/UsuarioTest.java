/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.usuarios_y_roles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UsuarioTest {
    
    @Test
    void testGetId() {
        Email email = new Email("maria@mail.com");
        Usuario usuario = new Usuario(1, "Maria", email);
        assertEquals(1, usuario.getId());
    }

    @Test
   void testGetNombre() {
        Email email = new Email("juan@mail.com");
        Usuario usuario = new Usuario(2, "Juan", email);
        assertEquals("Juan", usuario.getNombre());
    }

    @Test
   void testGetCorreo() {
        Email email = new Email("ana@mail.com");
        Usuario usuario = new Usuario(3, "Ana", email);
        assertEquals(email, usuario.getCorreo());
    }

    @Test
   void testUsuarioConEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(4, "Bad", new Email("bademail"));
        });
    }

    @Test
 void testUsuarioConEmailNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Usuario(5, "Null", null);
        });
    }
    
}
