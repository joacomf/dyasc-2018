package ar.edu.untref.dyasc;

import java.time.LocalDate;

public class Libreria {

    public void venderProducto(Producto articulo, Cliente cliente) {
        cliente.comprarProducto(articulo, LocalDate.now());
    }

    public void agregarCliente(Cliente cliente) {
    }

    public void venderProducto(Producto producto, Cliente cliente, LocalDate fecha) {
        cliente.comprarProducto(producto, fecha);
    }

    public double cuantoDebeElClienteEsteMes(Cliente cliente) {
        return cliente.obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(LocalDate.now());
    }

    public double cuantoDebeElClienteEnElAño(Cliente cliente, int año) {
        return cliente.obtenerResumenDeCuentaCorrienteDelAño(año);
    }

}
