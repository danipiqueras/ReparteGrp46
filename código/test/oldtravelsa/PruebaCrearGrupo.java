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
        	new Grupo(nombre, mockUsuario, descripcion, fecha);
        });
    }

    @Test
    public void testNombreDemasiadoLargo() {
        Usuario mockUsuario = mock(Usuario.class);

        String nombre = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String descripcion = "Descripción de prueba";
        LocalDate fecha = LocalDate.now();

        assertThrows(IllegalArgumentException.class, () -> {
        	new Grupo(nombre, mockUsuario, descripcion, fecha);
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
    public void testDescripcionNula() {
        Usuario mockUsuario = mock(Usuario.class);
        when(mockUsuario.getNombre()).thenReturn("Usuario de prueba");
        when(mockUsuario.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockUsuario.getDni()).thenReturn("12345678A");
        when(mockUsuario.getTelefono()).thenReturn("123456789");

        String nombre = "Grupo de prueba";
        LocalDate fecha = LocalDate.now();

        Grupo grupo = new Grupo(nombre, mockUsuario, null, fecha);

        assertNotNull(grupo);
        assertEquals(nombre, grupo.getNombre());
        assertEquals(mockUsuario, grupo.getCreador());
        assertEquals("", grupo.getDescripcion()); //Se debe poner a string vacia si es null
        assertEquals(fecha, grupo.getFechaCreacion());
    }
    
    @Test
    public void testDescripcionDemasiadoLarga() {
        Usuario mockUsuario = mock(Usuario.class);

        String nombre = "Grupo de prueba";
        String descripcion = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestib";
        LocalDate fecha = LocalDate.now();

        assertThrows(IllegalArgumentException.class, () -> {
        	new Grupo(nombre, mockUsuario, descripcion, fecha);
        });
    }
    
    @Test
    public void testFechaNull() {
        Usuario mockUsuario = mock(Usuario.class);

        String nombre = "Grupo de prueba";
        String descripcion = "Descripción de prueba";

        assertThrows(IllegalArgumentException.class, () -> {
        	new Grupo(nombre, mockUsuario, descripcion, null);
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
