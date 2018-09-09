package ar.edu.untref.dyasc;

import java.time.LocalDate;

public class Cliente {

    private String nombre;
    private String apellido;

    public Cliente(String nombre, String apellido, String direccion, LocalDate fechaNacimiento) {
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

    public LocalDate obtenerFechaNacimiento() {
        return LocalDate.of(1978, 2, 2);
    }

    public String obtenerDireccion() {
        return "Junin 320";
    }
}
