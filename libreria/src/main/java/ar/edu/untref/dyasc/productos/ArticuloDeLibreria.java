package ar.edu.untref.dyasc.productos;

public class ArticuloDeLibreria extends Producto {

    private double iva = 1.21;

    public ArticuloDeLibreria(double precioDeVenta) {
        super(precioDeVenta);
    }

    @Override
    public double obtenerPrecio() {
        return super.obtenerPrecio() * iva;
    }
}
