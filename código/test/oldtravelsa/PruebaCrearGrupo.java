package oldtravelsa;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.Test;

public class PruebaCrearGrupo {

    @Test
    public void testParametrosValidos() {
        Usuario mockUsuario = mock(Usuario.class);
        when(mockUsuario.getNombre()).thenReturn("Usuario de prueba");
        when(mockUsuario.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockUsuario.getDni()).thenReturn("12345678A");
        when(mockUsuario.getTelefono()).thenReturn("123456789");

        String nombre = "Grupo de prueba";
        String descripcion = "Descripción de prueba";
        LocalDate fecha = LocalDate.now();

        Grupo grupo = new Grupo(nombre, mockUsuario, descripcion, fecha);

        assertNotNull(grupo);
        assertEquals(nombre, grupo.getNombre());
        assertEquals(mockUsuario, grupo.getCreador());
        assertEquals(descripcion, grupo.getDescripcion());
        assertEquals(fecha, grupo.getFechaCreacion());
    }

    @Test
    public void testNombreNull() {
        Usuario mockUsuario = mock(Usuario.class);

        String descripcion = "Descripción de prueba";
        LocalDate fecha = LocalDate.now();
        
        assertThrows(IllegalArgumentException.class, () -> {
        	new Grupo(null, mockUsuario, descripcion, fecha);
        });

        
    }

    @Test
    public void testNombreVacio() {
        Usuario mockUsuario = mock(Usuario.class);

        String nombre = "";
        String descripcion = "Descripción de prueba";
        LocalDate fecha = LocalDate.now();

        assertThrows(IllegalArgumentException.class, () -> {
        	new Grupo(null, mockUsuario, descripcion, fecha);
        });
    }

    @Test
    public void testNombreDemasiadoLargo() {
        Usuario mockUsuario = mock(Usuario.class);

        String nombre = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String descripcion = "Descripción de prueba";
        LocalDate fecha = LocalDate.now();

        assertThrows(IllegalArgumentException.class, () -> {
        	new Grupo(null, mockUsuario, descripcion, fecha);
        });
    }

    @Test
    public void testCreadorInvalido() {
        String nombre = "Grupo de prueba";
        String descripcion = "Descripción de prueba";
        LocalDate fecha = LocalDate.now();

        assertThrows(IllegalArgumentException.class, () -> {
        	new Grupo(nombre, null, descripcion, fecha);
        });
    }
    
    @Test
    public void testDescripcionVacia() {
        Usuario mockUsuario = mock(Usuario.class);
        when(mockUsuario.getNombre()).thenReturn("Usuario de prueba");
        when(mockUsuario.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockUsuario.getDni()).thenReturn("12345678A");
        when(mockUsuario.getTelefono()).thenReturn("123456789");

        String nombre = "Grupo de prueba";
        String descripcion = "";
        LocalDate fecha = LocalDate.now();

        Grupo grupo = new Grupo(nombre, mockUsuario, descripcion, fecha);

        assertNotNull(grupo);
        assertEquals(nombre, grupo.getNombre());
        assertEquals(mockUsuario, grupo.getCreador());
        assertEquals(descripcion, grupo.getDescripcion());
        assertEquals(fecha, grupo.getFechaCreacion());
    }
    
    @Test
    public void testDescripcionDemasiadoLarga() {
        Usuario mockUsuario = mock(Usuario.class);

        String nombre = "Grupo de prueba";
        String descripcion = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        LocalDate fecha = LocalDate.now();

        assertThrows(IllegalArgumentException.class, () -> {
        	new Grupo(null, mockUsuario, descripcion, fecha);
        });
    }
    
    @Test
    public void testFechaNull() {
        Usuario mockUsuario = mock(Usuario.class);

        String nombre = "Grupo de prueba";
        String descripcion = "Descripción de prueba";

        assertThrows(IllegalArgumentException.class, () -> {
        	new Grupo(null, mockUsuario, descripcion, null);
        });
    }
    
    @Test
    public void testFechaFutura() {
        Usuario mockUsuario = mock(Usuario.class);

        String nombre = "Grupo de prueba";
        String descripcion = "Descripción de prueba";
        LocalDate fecha = LocalDate.of(2025, 01, 01);

        new Grupo(nombre, mockUsuario, descripcion, fecha);
    }
}
