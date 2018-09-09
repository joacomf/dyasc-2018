package ar.edu.untref.dyasc;

public class Cliente {

    private String nombre;
    private String apellido;

    public Cliente(String nombre, String apellido) {
        this.setNombre(nombre);
        this.setApellido(apellido);
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerApellido() {
        return this.apellido;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
