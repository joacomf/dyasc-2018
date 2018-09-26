package ar.edu.untref.dyasc.productos;

public class Producto {

    private double precioDeVenta = 0;

    public Producto(double precioDeVenta) {
        this.precioDeVenta  = precioDeVenta;
    }

    public double obtenerPrecio() {
        return this.precioDeVenta;
    }

}
