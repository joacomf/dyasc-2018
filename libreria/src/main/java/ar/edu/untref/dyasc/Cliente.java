package ar.edu.untref.dyasc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<Integer, Producto> obtenerListadoCompletoDeProductosComprados() {
        return new HashMap<Integer, Producto>();
    }

    public List<Suscribible> obtenerListaDeSuscripciones() {
        return new ArrayList<Suscribible>();
    }

    public List<Producto> obtenerListadoDeProductosEnElMesDelAño(int mes, int año) {
        return new ArrayList<Producto>();
    }

}
