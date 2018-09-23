package ar.edu.untref.dyasc;

import java.time.LocalDate;
import java.util.List;

public class Libreria {

    public void venderProducto(Producto articulo, Cliente cliente) {
        cliente.comprarProducto(articulo, LocalDate.now());
    }

    public void agregarCliente(Cliente cliente) {
    }

    public void venderProducto(Producto producto, Cliente cliente, LocalDate fecha) {
        cliente.comprarProducto(producto, fecha);
    }

    public void venderProducto(ProductoSuscribible producto, Cliente cliente, LocalDate fecha) {
        cliente.comprarProducto(producto, fecha);
    }

    public double cuantoDebeElClienteEsteMes(Cliente cliente) {
        LocalDate fechaActual = LocalDate.now();
        int mes = fechaActual.getMonthValue();
        int año = fechaActual.getYear();

        return cliente.obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(mes, año);
    }

    public double cuantoDebeElClienteEnElAño(Cliente cliente, int año) {
        return cliente.obtenerResumenDeCuentaCorrienteDelAño(año);
    }

    public double cuantoDebeElClienteEnElMesYAño(int mes, int año, Cliente cliente) {
        List<Producto> listadoProductos = cliente.obtenerListadoDeProductosEnElMesYAñoDeLaFecha(mes, año);
        List<ProductoSuscribible> listadoDeSuscripciones = cliente.obtenerListadoDeSuscripcionesEnElMesYAñoDeLaFecha(mes, año);

        double sumatoriaDeProductos = listadoProductos.stream().mapToDouble(producto -> producto.obtenerPrecio()).sum();
        double sumatoriaDeSuscripciones = listadoDeSuscripciones.stream().mapToDouble(producto -> producto.obtenerPrecio() * producto.obtenerPeriodicidad()).sum();

        double precioFinalDeProductos = sumatoriaDeProductos * 0.95;
        double precioFinalDeSuscripciones = sumatoriaDeSuscripciones * 0.80;

        return precioFinalDeProductos + precioFinalDeSuscripciones;
    }
}
