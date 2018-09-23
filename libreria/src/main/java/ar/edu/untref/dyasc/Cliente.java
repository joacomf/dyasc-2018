package ar.edu.untref.dyasc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;

public class Cliente {

    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fechaNacimiento;
    private String direccion;
    private Map<Integer, Map<Integer, List<Producto>>> mapaDeProductos;
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
        Integer año = fecha.getYear();
        Integer mes = fecha.getMonthValue();

        List<Producto> listadoDeProductos = null;

        Map<Integer, List<Producto>> mapaDeMeses = this.mapaDeProductos.get(año);

        if (mapaDeMeses != null) {
            listadoDeProductos = mapaDeMeses.get(mes);
        }

        return listadoDeProductos;
    }

    public void comprarProducto(Producto producto, LocalDate fecha) {
        Integer año = fecha.getYear();

        Map<Integer, List<Producto>> listaDeMeses = this.mapaDeProductos.get(año);

        if (listaDeMeses == null) {
            listaDeMeses = new HashMap<Integer, List<Producto>>();
            mapaDeProductos.put(año, listaDeMeses);
        }

        Integer mes = fecha.getMonthValue();
        List<Producto> listadoDeProductos = listaDeMeses.get(mes);

        if (listadoDeProductos == null) {
            listadoDeProductos = new ArrayList<>();
            listaDeMeses.put(mes, listadoDeProductos);
        }

        listadoDeProductos.add(producto);
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public double obtenerResumenDeCuentaCorrienteDelAño(int año) {
        Map<Integer, List<Producto>> mapaDeMeses = this.mapaDeProductos.get(año);
        Set<Integer> listadoDeMeses = mapaDeMeses.keySet();

        double sumatoria = 0;

        for (int mes : listadoDeMeses) {
            sumatoria += mapaDeMeses.get(mes).stream().mapToDouble(producto -> producto.obtenerPrecio()).sum();
        }

        return sumatoria;
    }

}
