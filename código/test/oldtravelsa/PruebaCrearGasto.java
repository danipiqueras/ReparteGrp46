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
    public void testDescripcionInvalidaVacia() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");

        int id = 1;
        String descripcion = ""; // Descripción vacía
        double cantidadPagada = 50.00;
        LocalDate fecha = LocalDate.of(2024, 4, 27);

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }

    @Test
    public void testDescripcionInvalidaLarga() {
        Grupo mockGrupo = mock(Grupo.class);
        Usuario mockPagador = mock(Usuario.class);
        when(mockPagador.getNombre()).thenReturn("Usuario de prueba");
        when(mockPagador.getCorreo()).thenReturn("usuario@prueba.com");
        when(mockPagador.getDni()).thenReturn("12345678A");
        when(mockPagador.getTelefono()).thenReturn("123456789");

        int id = 1;
        String descripcion = "Lorem ipsum bla bla bla (TODO)"; // Descripción demasiado larga
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

        int id = 1;
        String descripcion = "Comida";
        double cantidadPagada = 50.00;
        LocalDate fecha = LocalDate.of(2025, 01, 01); // Fecha futura

        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(id, mockGrupo, mockPagador, descripcion, cantidadPagada, fecha);
        });
    }
}
