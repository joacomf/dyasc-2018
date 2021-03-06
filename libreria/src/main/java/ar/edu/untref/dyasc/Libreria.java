package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.productos.Producto;
import ar.edu.untref.dyasc.productos.Suscripcion;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Libreria {

    private Map<Integer, Cliente> listadoDeClientes = new HashMap<>();

    void venderProducto(Producto producto, Cliente cliente) {
        cliente.comprarProducto(producto, LocalDate.now());
    }

    void venderProducto(Producto producto, int dni) throws ClienteNoRegistradoException {
        Cliente cliente = obtenerClientePorDNI(dni);

        cliente.comprarProducto(producto, LocalDate.now());
    }

    void venderProducto(Producto producto, Cliente cliente, LocalDate fecha) {
        cliente.comprarProducto(producto, fecha);
    }

    void venderProducto(Producto producto, int dni, LocalDate fecha) throws ClienteNoRegistradoException {
        Cliente cliente = obtenerClientePorDNI(dni);

        cliente.comprarProducto(producto, fecha);
    }

    void venderProducto(Suscripcion suscripcion, Cliente cliente) {
        cliente.comprarProducto(suscripcion, LocalDate.now());
    }

    void venderProducto(Suscripcion suscripcion, Cliente cliente, LocalDate fecha) {
        cliente.comprarProducto(suscripcion, fecha);
    }

    void venderProducto(Suscripcion suscripcion, int dni, LocalDate fecha) throws ClienteNoRegistradoException {
        Cliente cliente = obtenerClientePorDNI(dni);

        cliente.comprarProducto(suscripcion, fecha);
    }

    void venderProducto(Suscripcion suscripcion, int dni) throws ClienteNoRegistradoException {
        Cliente cliente = obtenerClientePorDNI(dni);

        cliente.comprarProducto(suscripcion, LocalDate.now());
    }

    double deudaDelClienteEsteMes(Cliente cliente) {
        LocalDate fechaActual = LocalDate.now();
        int mes = fechaActual.getMonthValue();
        int año = fechaActual.getYear();

        return this.deudaDelClienteEnElMesYAño(mes, año, cliente);
    }

    double deudaDelClienteEsteMes(int dni) throws ClienteNoRegistradoException {
        Cliente cliente = this.obtenerClientePorDNI(dni);

        return this.deudaDelClienteEsteMes(cliente);
    }

    double deudaDelClienteEnElAño(Cliente cliente, int año) {

        double deudaAnualAcumulada = 0;

        for (int mes = 1; mes <= 12; mes++) {
            deudaAnualAcumulada += this.deudaDelClienteEnElMesYAño(mes, año, cliente);
        }

        return deudaAnualAcumulada;
    }

    double deudaDelClienteEnElAño(int dni, int año) throws ClienteNoRegistradoException {
        Cliente cliente = this.obtenerClientePorDNI(dni);

        return this.deudaDelClienteEnElAño(cliente, año);
    }

    double deudaDelClienteEnElMesYAño(int mes, int año, int dni) throws ClienteNoRegistradoException {
        Cliente cliente = this.obtenerClientePorDNI(dni);

        return this.deudaDelClienteEnElMesYAño(mes, año, cliente);
    }

    double deudaDelClienteEnElMesYAño(int mes, int año, Cliente cliente) {
        List<Producto> listadoProductos = cliente.obtenerListadoDeProductosEnElMesYAñoDeLaFecha(mes, año);
        List<Suscripcion> listadoDeSuscripciones = cliente.obtenerListadoDeSuscripcionesEnElMesYAñoDeLaFecha(mes, año);

        double sumatoriaDeProductos = listadoProductos.stream().mapToDouble(Producto::obtenerPrecio).sum();
        double sumatoriaDeSuscripciones = listadoDeSuscripciones.stream().mapToDouble(Suscripcion::obtenerPrecioMensual).sum();

        double precioFinalDeProductos = sumatoriaDeProductos * 0.95;
        double precioFinalDeSuscripciones = sumatoriaDeSuscripciones * 0.80;

        return precioFinalDeProductos + precioFinalDeSuscripciones;
    }

    void agregarCliente(Cliente cliente) {

        listadoDeClientes.put(cliente.getDni(), cliente);
    }

    private Cliente obtenerClientePorDNI(int dniDelCliente) throws ClienteNoRegistradoException {
        Cliente cliente = listadoDeClientes.get(dniDelCliente);

        if (cliente == null) {
            throw new ClienteNoRegistradoException();
        }
        return cliente;
    }
}
