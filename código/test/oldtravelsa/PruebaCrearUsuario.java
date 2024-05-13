package oldtravelsa;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Queue;

public class PruebaCrearUsuario {

    @Test
    public void testCreacionUsuarioExitosa() {
        String nombre = "Pepe";
        String dni = "11111111A";
        String telefono = "564231234";
        String correo = "hola@gmail.com";

        Usuario usuario = new Usuario(nombre, correo, dni, telefono);

        assertNotNull(usuario);
        assertEquals(nombre, usuario.getNombre());
        assertEquals(dni, usuario.getDni());
        assertEquals(telefono, usuario.getTelefono());
        assertEquals(correo, usuario.getCorreo());
        
        Queue<String> buzon = usuario.getBuzon();
        assertNotNull(buzon);
        assertTrue(buzon.isEmpty());
    }
    
    @Test
    public void testNombreNulo() {
        String dni = "11111111A";
        String telefono = "564231234";
        String correo = "hola@gmail.com";

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(null, correo, dni, telefono);
        });
    }

    @Test
    public void testNombreVacio() {
        String nombre = "";
        String dni = "11111111A";
        String telefono = "564231234";
        String correo = "hola@gmail.com";

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, telefono);
        });
    }
    
    @Test
    public void testNombreLargo() {
        String nombre = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String dni = "11111111A";
        String telefono = "564231234";
        String correo = "hola@gmail.com";

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, telefono);
        });
    }
    
    @Test
    public void testDniInvalido() {
        String nombre = "Pepe";
        String dni = "1111111A"; // DNI inválido, longitud incorrecta
        String telefono = "564231234";
        String correo = "hola@gmail.com";

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, telefono);
        });
    }
    
    @Test
    public void testDniNulo() {
        String nombre = "Pepe";
        String telefono = "564231234";
        String correo = "hola@gmail.com";

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, null, telefono);
        });
    }
    
    @Test
    public void testTelefonoNulo() {
        String nombre = "Pepe";
        String dni = "11111111A";
        String correo = "hola@gmail.com";

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, null);
        });
    }

    @Test
    public void testTelefonoInvalido() {
        String nombre = "Pepe";
        String dni = "11111111A";
        String telefono = "34567821"; // Teléfono inválido, longitud incorrecta
        String correo = "hola@gmail.com";

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, telefono);
        });
    }
    
    @Test
    public void testCorreoNulo() {
        String nombre = "Pepe";
        String dni = "11111111A";
        String telefono = "564231234";

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, null, dni, telefono);
        });
    }

    @Test
    public void testCorreoInvalido() {
        String nombre = "Pepe";
        String dni = "11111111A";
        String telefono = "564231234";
        String correo = "hola"; // Correo inválido, formato incorrecto

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(nombre, correo, dni, telefono);
        });
    }

    


}
