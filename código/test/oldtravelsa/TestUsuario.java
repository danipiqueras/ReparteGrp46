package oldtravelsa;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestUsuario {

    @Test
    public void testUsuarioConDNIVacio() {
        // Arrange
        String nombre = "Juan";
        String correo = "juan@example.com";
        String dni = "";
        String telefono = "123456789";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, telefono);
        });
    }

    @Test
    public void testUsuarioConCorreoSinArroba() {
        // Arrange
        String nombre = "Ana";
        String dni = "12345678A";
        String telefono = "987654321";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, "anaexample.com", dni, telefono);
        });
    }

    @Test
    public void testUsuarioConParametrosNulos() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(null, "correo@example.com", "12345678A", "987654321");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Juan", null, "12345678A", "987654321");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Juan", "correo@example.com", null, "987654321");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Juan", "correo@example.com", "12345678A", null);
        });
    }

    @Test
    public void testUsuarioConDNINulo() {
        // Arrange
        String nombre = "Juan";
        String correo = "juan@example.com";
        String telefono = "123456789";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, null, telefono);
        });
    }

    @Test
    public void testUsuarioConTelefonoVacio() {
        // Arrange
        String nombre = "Juan";
        String correo = "juan@example.com";
        String dni = "12345678A";
        String telefono = "";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, telefono);
        });
    }

    @Test
    public void testUsuarioConTelefonoNulo() {
        // Arrange
        String nombre = "Juan";
        String correo = "juan@example.com";
        String dni = "12345678A";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, null);
        });
    }

    @Test
    public void testUsuarioConDNINoValido() {
        // Arrange
        String nombre = "Juan";
        String correo = "juan@example.com";
        String dni = "12345678"; // DNI inválido (debería ser una letra al final)

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, "123456789");
        });
    }

    @Test
    public void testUsuarioConCorreoVacio() {
        // Arrange
        String nombre = "Juan";
        String dni = "12345678A";
        String telefono = "123456789";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, "", dni, telefono);
        });
    }

    @Test
    public void testUsuarioConNombreVacio() {
        // Arrange
        String correo = "juan@example.com";
        String dni = "12345678A";
        String telefono = "123456789";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("", correo, dni, telefono);
        });
    }
    
    @Test
    public void testUsuarioGettersSetters() {
        // Arrange
        String nombre = "Juan";
        String correo = "juan@example.com";
        String dni = "12345678A";
        String telefono = "123456789";
        Usuario usuario = new Usuario(nombre, correo, dni, telefono);

        // Act & Assert
        assertEquals(nombre, usuario.getNombre());
        assertEquals(correo, usuario.getCorreo());
        assertEquals(dni, usuario.getDni());
        assertEquals(telefono, usuario.getTelefono());

        // Modificamos valores con setters
        String nuevoNombre = "Pedro";
        String nuevoCorreo = "pedro@example.com";
        String nuevoTelefono = "987654321";

        usuario.setNombre(nuevoNombre);
        usuario.setCorreo(nuevoCorreo);
        usuario.setTelefono(nuevoTelefono);

        // Verificamos que los valores hayan cambiado
        assertEquals(nuevoNombre, usuario.getNombre());
        assertEquals(nuevoCorreo, usuario.getCorreo());
        assertEquals(nuevoTelefono, usuario.getTelefono());
    }

    @Test
    public void testUsuarioEquals() {
        // Arrange
        String nombre1 = "Juan";
        String correo1 = "juan@example.com";
        String dni1 = "12345678A";
        String telefono1 = "123456789";
        Usuario usuario1 = new Usuario(nombre1, correo1, dni1, telefono1);

        String nombre2 = "Pedro";
        String correo2 = "pedro@example.com";
        String dni2 = "12345678B";
        String telefono2 = "987654321";
        Usuario usuario2 = new Usuario(nombre2, correo2, dni2, telefono2);

        // Act & Assert
        assertTrue(usuario1.equals(usuario1)); // Comprobación de igualdad consigo mismo
        assertFalse(usuario1.equals(null)); // Comprobación de no igualdad con null
        assertFalse(usuario1.equals("Juan")); // Comprobación de no igualdad con otro tipo de objeto

        // Dos usuarios con el mismo DNI deben ser considerados iguales
        Usuario usuario3 = new Usuario("Otro", "otro@example.com", "12345678A", "987654321");
        assertTrue(usuario1.equals(usuario3));

        // Dos usuarios con DNI diferente no deben ser considerados iguales
        assertFalse(usuario1.equals(usuario2));
    }
    
    @Test
    public void testUsuarioRecibirMensajeGasto() {
        // Arrange
        String nombre = "Juan";
        String correo = "juan@example.com";
        String dni = "12345678A";
        String telefono = "123456789";
        Usuario usuario = new Usuario(nombre, correo, dni, telefono);
        
        double cantidad = 50.0;
        double cantidadInicial = usuario.getBalance();
        String mensaje = "Se ha realizado un gasto";
        
        // Act
        usuario.recibirMensajeGasto(mensaje, cantidad);
        
        // Assert
        assertEquals(cantidadInicial - cantidad, usuario.getBalance(), 0.01); // Se espera que el balance se haya reducido correctamente
        assertTrue(usuario.getBalance() < cantidadInicial); // Verificar que el balance se haya reducido
    }
}
