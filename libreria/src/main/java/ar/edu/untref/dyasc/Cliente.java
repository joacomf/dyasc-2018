package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.productos.Producto;
import ar.edu.untref.dyasc.productos.ProductoSuscribible;

import java.time.LocalDate;
import java.util.*;

public class Cliente {

    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fechaNacimiento;
    private String direccion;
    private Map<Integer, Map<Integer, List<Producto>>> mapaDeProductos;
    private Map<Integer, Map<Integer, List<ProductoSuscribible>>> mapaDeSuscripciones;

    public Cliente(String nombre, String apellido, Integer dni, String direccion, LocalDate fechaNacimiento) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setFechaNacimiento(fechaNacimiento);
        this.setDireccion(direccion);

        this.mapaDeProductos = new HashMap<>();
        this.mapaDeSuscripciones = new HashMap<>();
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

    public Map<Integer, List<ProductoSuscribible>> obtenerListadoCompletoDeSuscripcionesAdquiridas() {
        return new HashMap<Integer,  List<ProductoSuscribible>>();
    }

    public List<Producto> obtenerListadoDeProductosEnElMesYAñoDeLaFecha(int mes, int año) {

        List<Producto> listadoDeProductos = new ArrayList<>();

        Map<Integer, List<Producto>> mapaDeMeses = this.mapaDeProductos.get(año);

        if (mapaDeMeses != null) {
            listadoDeProductos = mapaDeMeses.getOrDefault(mes, new ArrayList<>());
        }

        return listadoDeProductos;
    }


    public List<ProductoSuscribible> obtenerListadoDeSuscripcionesEnElMesYAñoDeLaFecha(int mes, int año) {

        List<ProductoSuscribible> listadoDeProductos = new ArrayList<>();

        Map<Integer, List<ProductoSuscribible>> mapaDeMeses = this.mapaDeSuscripciones.get(año);

        if (mapaDeMeses != null) {
            listadoDeProductos = mapaDeMeses.getOrDefault(mes, new ArrayList<>());
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
        List<Producto> listadoDeProductos = listaDeMeses.computeIfAbsent(mes, listado -> new ArrayList<>());

        listadoDeProductos.add(producto);
    }

    public void comprarProducto(ProductoSuscribible producto, LocalDate fecha) {
        Integer año = fecha.getYear();

        Map<Integer, List<ProductoSuscribible>> listaDeMeses = this.mapaDeSuscripciones.get(año);

        if (listaDeMeses == null) {
            listaDeMeses = new HashMap<Integer, List<ProductoSuscribible>>();
            mapaDeSuscripciones.put(año, listaDeMeses);
        }

        Integer mes = fecha.getMonthValue();
        List<ProductoSuscribible> listadoDeProductos = listaDeMeses.computeIfAbsent(mes, listado -> new ArrayList<>());

        listadoDeProductos.add(producto);
    }

    private void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getDni() {
        return this.dni;
    }
}
