package ar.edu.untref.dyasc;

import java.time.LocalDate;

public class Libreria {

    public void venderProducto(Producto articulo, Cliente cliente) {
        cliente.comprarProducto(articulo, LocalDate.now());
    }

    public void agregarCliente(Cliente cliente) {
    }

    public double cuantoDebeElClienteEsteMes(Cliente cliente) {
        return cliente.obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(LocalDate.now());
    }

}
