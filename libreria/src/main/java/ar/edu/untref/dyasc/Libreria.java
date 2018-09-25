package ar.edu.untref.dyasc;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libreria {

    private Map<Integer, Cliente> listadoDeClientes = new HashMap<>();

    public void venderProducto(Producto articulo, Cliente cliente) {
        cliente.comprarProducto(articulo, LocalDate.now());
    }

    public void venderProducto(Producto producto, Cliente cliente, LocalDate fecha) {
        cliente.comprarProducto(producto, fecha);
    }

    public void venderProducto(ProductoSuscribible articulo, Cliente cliente) {
        cliente.comprarProducto(articulo, LocalDate.now());
    }

    public void venderProducto(ProductoSuscribible producto, Cliente cliente, LocalDate fecha) {
        cliente.comprarProducto(producto, fecha);
    }

    public void venderProducto(Producto libro, int dniDelCliente) throws ClienteNoRegistradoException {
        Cliente cliente = obtenerClientePorDNI(dniDelCliente);

        cliente.comprarProducto(libro, LocalDate.now());
    }

    public void venderProducto(ProductoSuscribible libro, int dniDelCliente) throws ClienteNoRegistradoException {
        Cliente cliente = obtenerClientePorDNI(dniDelCliente);

        cliente.comprarProducto(libro, LocalDate.now());
    }

    private Cliente obtenerClientePorDNI(int dniDelCliente) throws ClienteNoRegistradoException {
        Cliente cliente = listadoDeClientes.get(dniDelCliente);

        if (cliente == null) {
            throw new ClienteNoRegistradoException();
        }
        return cliente;
    }

    public double deudaDelClienteEsteMes(Cliente cliente) {
        LocalDate fechaActual = LocalDate.now();
        int mes = fechaActual.getMonthValue();
        int año = fechaActual.getYear();

        return this.deudaDelClienteEnElMesYAño(mes, año, cliente);
    }

    public double deudaDelClienteEnElAño(Cliente cliente, int año) {

        double deudaAnualAcumulada = 0;

        for (int mes = 1; mes <= 12; mes++) {
            deudaAnualAcumulada += this.deudaDelClienteEnElMesYAño(mes, año, cliente);
        }

        return deudaAnualAcumulada;
    }

    public double deudaDelClienteEnElMesYAño(int mes, int año, Cliente cliente) {
        List<Producto> listadoProductos = cliente.obtenerListadoDeProductosEnElMesYAñoDeLaFecha(mes, año);
        List<ProductoSuscribible> listadoDeSuscripciones = cliente.obtenerListadoDeSuscripcionesEnElMesYAñoDeLaFecha(mes, año);

        double sumatoriaDeProductos = listadoProductos.stream().mapToDouble(Producto::obtenerPrecio).sum();
        double sumatoriaDeSuscripciones = listadoDeSuscripciones.stream().mapToDouble(producto -> producto.obtenerPrecio() * producto.obtenerPeriodicidad()).sum();

        double precioFinalDeProductos = sumatoriaDeProductos * 0.95;
        double precioFinalDeSuscripciones = sumatoriaDeSuscripciones * 0.80;

        return precioFinalDeProductos + precioFinalDeSuscripciones;
    }

    public void agregarCliente(Cliente cliente) {

        listadoDeClientes.put(cliente.getDni(), cliente);
    }

    public double deudaDelClienteEsteMes(int dni) throws ClienteNoRegistradoException {
        Cliente cliente = this.obtenerClientePorDNI(dni);

        return this.deudaDelClienteEsteMes(cliente);
    }
}
