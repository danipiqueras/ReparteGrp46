package oldtravelsa;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestGrupo {

    @Test
    void testAñadirMiembroExistente() {
        // Arrange
        Usuario creador = new Usuario("Creador", "creador@example.com", "12345678A", "987654321");
        Grupo grupo = new Grupo("Grupo", creador, "Descripción", LocalDate.now());
        Usuario miembroExistente = new Usuario("Miembro", "miembro@example.com", "87654321B", "123456789");

        // Act
        grupo.añadirMiembro(miembroExistente);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            grupo.añadirMiembro(miembroExistente);
        });
    }

    @Test
    void testEliminarCreador() {
        // Arrange
        Usuario creador = new Usuario("Creador", "creador@example.com", "12345678A", "987654321");
        Grupo grupo = new Grupo("Grupo", creador, "Descripción", LocalDate.now());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            grupo.eliminarMiembro(creador);
        });
    }

    @Test
    void testEliminarMiembroQueNoExiste() {
        // Arrange
        Usuario creador = new Usuario("Creador", "creador@example.com", "12345678A", "987654321");
        Grupo grupo = new Grupo("Grupo", creador, "Descripción", LocalDate.now());
        Usuario noMiembro = new Usuario("No Miembro", "nomiembro@example.com", "11111111X", "123456789");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            grupo.eliminarMiembro(noMiembro);
        });
    }

    @Test
    void testObtenerMiembros() {
        // Arrange
        Usuario creador = new Usuario("Creador", "creador@example.com", "12345678A", "987654321");
        Grupo grupo = new Grupo("Grupo", creador, "Descripción", LocalDate.now());
        Usuario miembro1 = new Usuario("Miembro 1", "miembro1@example.com", "11111111X", "123456789");
        Usuario miembro2 = new Usuario("Miembro 2", "miembro2@example.com", "22222222Y", "123456789");
        grupo.añadirMiembro(miembro1);
        grupo.añadirMiembro(miembro2);

        // Act
        List<Usuario> miembros = grupo.getMiembros();

        // Assert
        assertEquals(3, miembros.size()); // Se espera el tamaño 3 porque incluye al creador y a los dos miembros añadidos
        assertTrue(miembros.contains(creador)); // Verificar que el creador esté en la lista de miembros
        assertTrue(miembros.contains(miembro1)); // Verificar que el miembro1 esté en la lista de miembros
        assertTrue(miembros.contains(miembro2)); // Verificar que el miembro2 esté en la lista de miembros
    }
    
    @Test
    void testGrupoValoresValidos() {
        // Arrange
        Usuario creador = new Usuario("Creador", "creador@example.com", "12345678A", "987654321");
        String nombre = "Grupo de Viajes";
        String descripcion = "Grupo para organizar viajes en familia";
        LocalDate fechaCreacion = LocalDate.now();

        // Act
        Grupo grupo = new Grupo(nombre, creador, descripcion, fechaCreacion);

        // Assert
        assertNotNull(grupo);
        assertEquals(nombre, grupo.getNombre());
        assertEquals(creador, grupo.getCreador());
        assertEquals(descripcion, grupo.getDescripcion());
        assertEquals(fechaCreacion, grupo.getFechaCreacion());
        assertTrue(grupo.getMiembros().contains(creador)); // Verificar que el creador esté en la lista de miembros
    }

}
