package ar.edu.untref.dyasc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String direccion;
    private Map<Integer, List<Producto>> mapaDeProductos;

    public Cliente(String nombre, String apellido, String direccion, LocalDate fechaNacimiento) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setFechaNacimiento(fechaNacimiento);
        this.setDireccion(direccion);

        this.mapaDeProductos = new HashMap<>();
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

    public List<Producto> obtenerListadoDeProductosEnElMesYAñoDeLaFecha(LocalDate fecha) {
        Integer fechaEnClave = obtenerFechaClave(fecha);

        return this.mapaDeProductos.get(fechaEnClave);
    }

    public void comprarProducto(Producto producto, LocalDate fecha) {
        Integer fechaEnClave = obtenerFechaClave(fecha);

        List<Producto> listaDeProductos = this.mapaDeProductos.get(fechaEnClave);

        if (listaDeProductos == null) {
            listaDeProductos = new ArrayList<>();
            mapaDeProductos.put(fechaEnClave, listaDeProductos);
        }

        listaDeProductos.add(producto);
    }

    public double obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(LocalDate fecha) {
        List<Producto> listadoDeProductosDelMes = this.obtenerListadoDeProductosEnElMesYAñoDeLaFecha(fecha);
        double resumenDelMes = listadoDeProductosDelMes.stream()
                                                       .mapToDouble(Producto::obtenerPrecio)
                                                       .sum();

        return resumenDelMes;
    }

    private Integer obtenerFechaClave(LocalDate fecha) {
        DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("yyyyM");
        String fechaFormateada = fecha.format(formateadorDeFecha);
        Integer fechaEnClave = Integer.valueOf(fechaFormateada);
        return fechaEnClave;
    }

}
