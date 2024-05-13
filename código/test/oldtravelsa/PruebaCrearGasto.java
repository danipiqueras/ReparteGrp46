package oldtravelsa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class PruebaCrearGasto {

	@Test
    public void testParametrosValidos() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = 1;
        String descripcion = "Comida";
        double cantidadPagada = 50.00;
        LocalDate fecha = LocalDate.of(2024, 4, 27);

        Gasto gasto = new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);

        assertNotNull(gasto);
        assertEquals(id, gasto.getId());
        assertEquals(mockGrupo, gasto.getGrupo());
        assertEquals(mockPagador, gasto.getPagador());
        assertEquals(descripcion, gasto.getDescripcion());
        assertEquals(cantidadPagada, gasto.getCantidadPagada(), 0.01);
        assertEquals(fecha, gasto.getFecha());
    }

    @Test
    public void testCantidadPagadaInvalidaNegativa() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = 2;
        String descripcion = "Transporte";
        double cantidadPagada = -10.00;
        LocalDate fecha = LocalDate.of(2024, 4, 27);

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }

    @Test
    public void testCantidadPagadaInvalidaCero() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = 2;
        String descripcion = "Transporte";
        double cantidadPagada = 0.00;
        LocalDate fecha = LocalDate.of(2024, 4, 27);

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }

    @Test
    public void testIDInvalida() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = -1;
        String descripcion = "Comida";
        double cantidadPagada = 50.00;
        LocalDate fecha = LocalDate.of(2024, 4, 27);

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }

    @Test
    public void testGrupoInvalido() {
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");

        int id = 1;
        Grupo mockGrupo = null; // Grupo nulo
        String descripcion = "Comida";
        double cantidadPagada = 50.00;
        LocalDate fecha = LocalDate.of(2024, 4, 27);

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }

    @Test
    public void testPagadorInvalido() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = 1;
        Usuario mockPagadorInvalido = mock(Usuario.class); // Usuario no perteneciente al grupo
        String descripcion = "Comida";
        double cantidadPagada = 50.00;
        LocalDate fecha = LocalDate.of(2024, 4, 27);

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagadorInvalido, descripcion, cantidadPagada, fecha);
        });
    }

    @Test
    public void testDescripcionNula() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = 1;
        double cantidadPagada = 50.00;
        LocalDate fecha = LocalDate.of(2024, 4, 27);


        Gasto gasto = new Gasto(id, mockGrupo, mockPagador, null, cantidadPagada, fecha);

        assertNotNull(gasto);
        assertEquals(id, gasto.getId());
        assertEquals(mockGrupo, gasto.getGrupo());
        assertEquals(mockPagador, gasto.getPagador());
        assertEquals("", gasto.getDescripcion());
        assertEquals(cantidadPagada, gasto.getCantidadPagada(), 0.01);
        assertEquals(fecha, gasto.getFecha());
    }

    @Test
    public void testDescripcionInvalidaLarga() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = 1;
        String descripcion = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestib";
        double cantidadPagada = 50.00;
        LocalDate fecha = LocalDate.of(2024, 4, 27);

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }

    @Test
    public void testCantidadPagadaInvalida() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = 1;
        String descripcion = "Comida";
        double cantidadPagada = 0.00; // Cantidad pagada igual a 0
        LocalDate fecha = LocalDate.of(2024, 4, 27);

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }

    @Test
    public void testFechaInvalidaNula() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = 1;
        String descripcion = "Comida";
        double cantidadPagada = 50.00;
        LocalDate fecha = null; // Fecha nula

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }

    @Test
    public void testFechaInvalidaFutura() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(mockPagador);
        when(mockGrupo.getMiembros()).thenReturn(usuarios);

        int id = 1;
        String descripcion = "Comida";
        double cantidadPagada = 50.00;
        LocalDate fecha = LocalDate.of(2025, 01, 01); // Fecha futura

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }
}
