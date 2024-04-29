package oldtravelsa;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestGasto {

    @Test
    void testCantidadPagadaNegativa() {
        // Arrange
        Usuario creador = new Usuario("Creador", "creador@example.com", "12345678A", "987654321");
        Grupo grupo = new Grupo("Grupo", creador, "Descripción", LocalDate.now());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(1, grupo, creador, "Descripción del gasto", -50.0, LocalDate.now());
        });
    }

    @Test
    void testPagadorNoEsMiembroDelGrupo() {
        // Arrange
        Usuario creador = new Usuario("Creador", "creador@example.com", "12345678A", "987654321");
        Usuario usuarioNoMiembro = new Usuario("Usuario", "usuario@example.com", "87654321B", "123456789");
        Grupo grupo = new Grupo("Grupo", creador, "Descripción", LocalDate.now());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Gasto(1, grupo, usuarioNoMiembro, "Descripción del gasto", 50.0, LocalDate.now());
        });
    }
}
