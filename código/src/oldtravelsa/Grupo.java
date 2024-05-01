package oldtravelsa;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Grupo {
    private static int contadorGrupos = 0; // Variable estática para contar los grupos
    private final int id;
    private String nombre;
    private final Usuario creador;
    private String descripcion;
    private final LocalDate fechaCreacion;
    private List<Usuario> miembros;
    private List<Gasto> gastos;

    public Grupo(String nombre, Usuario creador, String descripcion, LocalDate fechaCreacion) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del grupo no puede ser nulo o vacío");
        }
        if (creador == null) {
            throw new IllegalArgumentException("El creador del grupo no puede ser nulo");
        }
        if (descripcion == null) {
            throw new IllegalArgumentException("La descripción del grupo no puede ser nula");
        }

        this.id = ++contadorGrupos;
        this.setNombre(nombre);
        this.creador = creador;
        this.setDescripcion(descripcion);
        this.fechaCreacion = fechaCreacion;
        this.miembros = new ArrayList<>();
        this.miembros.add(creador); // Se agrega automáticamente al creador como miembro inicial
        this.gastos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del grupo no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public Usuario getCreador() {
        return creador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null) {
            throw new IllegalArgumentException("La descripción del grupo no puede ser nula");
        }
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<Usuario> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Usuario> miembros) {
        this.miembros = miembros;
    }

    public void añadirMiembro(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario a añadir no puede ser nulo");
        }
        if (!miembros.contains(usuario)) {
            miembros.add(usuario);
        } else {
            throw new IllegalArgumentException("El usuario ya está en el grupo");
        }
    }

    public void eliminarMiembro(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario a eliminar no puede ser nulo");
        }
        if (usuario.equals(creador)) {
            throw new IllegalArgumentException("No se puede eliminar al creador del grupo");
        }
        if (!miembros.contains(usuario)) {
            throw new IllegalArgumentException("Este usuario no está en el grupo");
        }
        miembros.remove(usuario);
    }
    
    public void añadirGasto(Gasto gasto) {
    	if (gasto == null) {
            throw new IllegalArgumentException("El gasto a añadir no puede ser nulo");
        }
        if (!gastos.contains(gasto)) {
            gastos.add(gasto);
        } else {
            throw new IllegalArgumentException("El gasto ya está registrado");
        }
    }
}
