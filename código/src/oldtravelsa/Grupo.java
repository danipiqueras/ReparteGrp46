package oldtravelsa;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Grupo {
    private String nombre;
    private Usuario creador;
    private String descripcion;
    private LocalDate fechaCreacion;
    private List<Usuario> miembros;
    private List<Gasto> gastos;

    public Grupo(String nombre, Usuario creador, String descripcion, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.creador = creador;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.miembros = new ArrayList<>();
        this.miembros.add(creador); // Se agrega automáticamente al creador como miembro inicial
        this.gastos = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Usuario getCreador() {
        return creador;
    }
    
    public void setCreador(Usuario creador) {
        this.creador = creador;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
        if (!miembros.contains(usuario)) {
            miembros.add(usuario);
        }
    }

    public void eliminarMiembro(Usuario usuario) {
        miembros.remove(usuario);
    }
}
