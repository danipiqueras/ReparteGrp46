package oldtravelsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

class PruebaRepartirGasto {

	@Test
    void testUnicoMiembro() {
        // Crear usuario valido
        Usuario juan = new Usuario("Juan", "juan@example.com", "12345678A", "123456789");

        // Crear grupo valido
        Grupo grupo = new Grupo("Grupo", juan, "Grupo de prueba", LocalDate.now());

        // Crear gasto no valido
        Gasto gasto = new Gasto(1, grupo, juan, "Gasto de prueba", 10, LocalDate.now());
        
		gasto.calcularPagoEquitativo();
    }

	@Test
    void testGastosGrupoLosCuatro() {
        // Crear usuarios validos
        Usuario juan = new Usuario("Juan", "juan@example.com", "12345678A", "123456789");
        Usuario luis = new Usuario("Luis", "luis@example.com", "87654321B", "987654321");
        Usuario eva = new Usuario("Eva", "eva@example.com", "11111111X", "111111111");
        Usuario marta = new Usuario("Marta", "marta@example.com", "22222222Y", "222222222");

        // Crear grupo LosCuatro
        Grupo losCuatro = new Grupo("LosCuatro", juan, "Grupo de los cuatro amigos", LocalDate.now());

        // Añadir miembros al grupo
        losCuatro.añadirMiembro(luis);
        losCuatro.añadirMiembro(eva);
        losCuatro.añadirMiembro(marta);

        // Realizar los gastos
        Gasto gasto1 = new Gasto(1, losCuatro, eva, "Gasto de Eva", 11.30, LocalDate.now());
        Gasto gasto2 = new Gasto(2, losCuatro, eva, "Otro gasto de Eva", 23.15, LocalDate.now());
        Gasto gasto3 = new Gasto(3, losCuatro, eva, "Más gastos de Eva", 2.05, LocalDate.now());
        Gasto gasto4 = new Gasto(4, losCuatro, luis, "Gasto de Luis", 12.00, LocalDate.now());
        Gasto gasto5 = new Gasto(5, losCuatro, luis, "Otro gasto de Luis", 17.49, LocalDate.now());
        Gasto gasto6 = new Gasto(6, losCuatro, marta, "Gasto de Marta", 20.22, LocalDate.now());
        Gasto gasto7 = new Gasto(7, losCuatro, juan, "Gasto de Juan", 5.75, LocalDate.now());

        // Obtener gastos del grupo
        List<Gasto> gastosGrupo = losCuatro.getGastos();

        // Verificar los gastos
        assertEquals(7, gastosGrupo.size()); // Se esperan 7 gastos en total

        // Verificar que cada gasto está en la lista de gastos del grupo
        assertTrue(gastosGrupo.contains(gasto1));
        assertTrue(gastosGrupo.contains(gasto2));
        assertTrue(gastosGrupo.contains(gasto3));
        assertTrue(gastosGrupo.contains(gasto4));
        assertTrue(gastosGrupo.contains(gasto5));
        assertTrue(gastosGrupo.contains(gasto6));
        assertTrue(gastosGrupo.contains(gasto7));
        
        for (Gasto gasto : losCuatro.getGastos()) {
            gasto.calcularPagoEquitativo();
        }
        
     // Verificar que se han cobrado
        assertEquals(eva.getBalance(), (-12.00-17.49-20.22-5.75)/4);
        assertEquals(luis.getBalance(), (-11.30-23.15-2.05-20.22-5.75)/4);
        assertEquals(marta.getBalance(), (-11.30-23.15-2.05-12.00-17.49-5.75)/4);
        assertEquals(juan.getBalance(), (-11.30-23.15-2.05-12.00-17.49-20.22)/4);
    }

}

