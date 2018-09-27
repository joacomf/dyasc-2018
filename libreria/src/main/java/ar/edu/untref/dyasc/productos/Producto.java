package ar.edu.untref.dyasc.productos;

public class Producto {

    private double precioDeVenta;

    public Producto(double precioDeVenta) {
        this.precioDeVenta  = precioDeVenta;
    }

    public double obtenerPrecio() {
        return this.precioDeVenta;
    }

}
