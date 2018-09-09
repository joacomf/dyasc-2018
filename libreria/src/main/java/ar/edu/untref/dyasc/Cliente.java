package ar.edu.untref.dyasc;

public class Cliente {

    private String nombre;

    public Cliente(String nombre, String apellido) {
        this.setNombre(nombre);
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerApellido() {
        return "Diaz";
    }
}
