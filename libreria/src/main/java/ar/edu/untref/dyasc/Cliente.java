package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.productos.Producto;
import ar.edu.untref.dyasc.productos.Suscripcion;

import java.time.LocalDate;
import java.util.*;

class Cliente {

    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fechaNacimiento;
    private String direccion;
    private Map<Integer, Map<Integer, List<Producto>>> mapaDeProductos;
    private Map<Integer, Map<Integer, List<Suscripcion>>> mapaDeSuscripciones;

    Cliente(String nombre, String apellido, Integer dni, String direccion, LocalDate fechaNacimiento) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setFechaNacimiento(fechaNacimiento);
        this.setDireccion(direccion);

        this.mapaDeProductos = new HashMap<>();
        this.mapaDeSuscripciones = new HashMap<>();
    }

    List<Producto> obtenerListadoDeProductosEnElMesYAñoDeLaFecha(int mes, int año) {

        List<Producto> listadoDeProductos = new ArrayList<>();

        Map<Integer, List<Producto>> mapaDeMeses = this.mapaDeProductos.get(año);

        if (mapaDeMeses != null) {
            listadoDeProductos = mapaDeMeses.getOrDefault(mes, new ArrayList<>());
        }

        return listadoDeProductos;
    }

    List<Suscripcion> obtenerListadoDeSuscripcionesEnElMesYAñoDeLaFecha(int mes, int año) {

        List<Suscripcion> listadoDeProductos = new ArrayList<>();

        Map<Integer, List<Suscripcion>> mapaDeMeses = this.mapaDeSuscripciones.get(año);

        if (mapaDeMeses != null) {
            listadoDeProductos = mapaDeMeses.getOrDefault(mes, new ArrayList<>());
        }

        return listadoDeProductos;
    }

    void comprarProducto(Producto producto, LocalDate fecha) {
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

    void comprarProducto(Suscripcion producto, LocalDate fecha) {
        Integer año = fecha.getYear();

        Map<Integer, List<Suscripcion>> listaDeMeses = this.mapaDeSuscripciones.get(año);

        if (listaDeMeses == null) {
            listaDeMeses = new HashMap<Integer, List<Suscripcion>>();
            mapaDeSuscripciones.put(año, listaDeMeses);
        }

        Integer mes = fecha.getMonthValue();
        List<Suscripcion> listadoDeProductos = listaDeMeses.computeIfAbsent(mes, listado -> new ArrayList<>());

        listadoDeProductos.add(producto);
    }

    Integer getDni() {
        return this.dni;
    }

    private void setDni(Integer dni) {
        this.dni = dni;
    }

    String obtenerNombre() {
        return this.nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    String obtenerApellido() {
        return this.apellido;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    LocalDate obtenerFechaNacimiento() {
        return this.fechaNacimiento;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    String obtenerDireccion() {
        return this.direccion;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
