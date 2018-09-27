package ar.edu.untref.dyasc.productos;

public class ArticuloDeLibreria extends Producto {

    public ArticuloDeLibreria(double precioDeVenta) {
        super(precioDeVenta);
    }

    @Override
    public double obtenerPrecio() {
        double iva = 1.21;
        return super.obtenerPrecio() * iva;
    }
}
