package oldtravelsa;

import java.time.LocalDate;
import java.util.List;

public class Gasto {
    private final int id;
    private final Grupo grupo;
    private final Usuario pagador;
    private String descripcion;
    private final double cantidadPagada;
    private final LocalDate fecha;
    
    public Gasto(int id, Grupo grupo, Usuario pagador, String descripcion, double cantidadPagada, LocalDate fecha) {
        this.id = id;
        this.grupo = grupo;
        this.pagador = pagador;
        this.descripcion = descripcion;
        this.cantidadPagada = cantidadPagada;
        this.fecha = fecha;
        
        // Comprueba que la cantidad sea mayor a 0
        if (cantidadPagada <= 0) {
            throw new IllegalArgumentException("La cantidad pagada debe ser mayor a 0");
        }
        
        // Comprueba que el pagador forme parte del grupo
        if (!grupo.getMiembros().contains(pagador)) {
            throw new IllegalArgumentException("El pagador debe ser miembro del grupo");
        }
    }
    
    public int getId() {
        return id;
    }
    
    public Grupo getGrupo() {
        return grupo;
    }
    
    public Usuario getPagador() {
        return pagador;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getCantidadPagada() {
        return cantidadPagada;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    // Método para calcular lo que cada usuario debe pagar al pagador
    public void calcularPagoEquitativo() {
    	List<Usuario> usuarios = this.grupo.getMiembros();
    	double cantidad = this.cantidadPagada / usuarios.size();
        for (Usuario usuario : usuarios) {
			if (!usuario.equals(pagador)) {
				usuario.recibirMensajeGasto(String.format("Se debe pagar %f a %d",cantidad,this.pagador), cantidad);
			}
		}
    }
}
