package oldtravelsa;

import java.util.Queue;
import java.util.LinkedList;

public class Usuario {
	private String dni; // DNI como clave primaria
    private String nombre;
    private String correo;
    private String telefono;
    private Queue<String> buzon;
    private double balance;
    
    public Usuario(String nombre, String correo, String dni, String telefono) {
        if (dni == null) {
            throw new IllegalArgumentException("El DNI no puede ser nulo");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.buzon = new LinkedList<>();
        this.balance = 0.0;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getDni() {
        return dni;
    }
    
    // No hay setter para DNI porque se entiende que no puede cambiar
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Método para manejar los mensajes de gastos
    public void recibirMensajeGasto(String mensaje, double cantidad) {
        buzon.offer(mensaje); // Añadir mensaje al buzón
        balance -= cantidad; // Restar la cantidad del balance
    }
    
    // Sobrescribir el método equals para comparar por DNI
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) obj;
        return dni.equals(usuario.dni);
    }
}