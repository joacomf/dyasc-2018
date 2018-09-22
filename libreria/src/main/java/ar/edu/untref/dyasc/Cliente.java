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
    private Integer dni;
    private LocalDate fechaNacimiento;
    private String direccion;
    private Map<Integer, List<Producto>> mapaDeProductos;
    private List<ProductoSuscribible> listadoDeSuscripciones;

    public Cliente(String nombre, String apellido, Integer dni, String direccion, LocalDate fechaNacimiento) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setFechaNacimiento(fechaNacimiento);
        this.setDireccion(direccion);

        this.mapaDeProductos = new HashMap<>();
        this.listadoDeSuscripciones = new ArrayList<ProductoSuscribible>();
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

    public Map<Integer, List<Producto>> obtenerListadoCompletoDeProductosComprados() {
        return new HashMap<Integer,  List<Producto>>();
    }

    public List<ProductoSuscribible> obtenerListaDeSuscripciones() {
        return this.listadoDeSuscripciones;
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

    public void comprarProducto(ProductoSuscribible producto, LocalDate fecha) {
        int cantidadDeEdicionesPorMes = producto.obtenerPeriodicidad();

        for (int i = 0; i < cantidadDeEdicionesPorMes; i++) {
            this.comprarProducto((Producto) producto, fecha);
        }

        this.agregarItemAListaDeSuscripcion(producto);
    }

    private void agregarItemAListaDeSuscripcion(ProductoSuscribible producto) {
        this.listadoDeSuscripciones.add(producto);
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

}
