package ar.edu.untref.dyasc;

import java.time.LocalDate;

public class Cliente {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String direccion;

    public Cliente(String nombre, String apellido, String direccion, LocalDate fechaNacimiento) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setFechaNacimiento(fechaNacimiento);
        this.setDireccion(direccion);
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
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
