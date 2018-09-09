package ar.edu.untref.dyasc;

import java.time.LocalDate;

public class Cliente {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Cliente(String nombre, String apellido, String direccion, LocalDate fechaNacimiento) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setFechaNacimiento(fechaNacimiento);
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
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String obtenerDireccion() {
        return "Junin 320";
    }
}
