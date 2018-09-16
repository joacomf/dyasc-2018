package ar.edu.untref.dyasc;

public class ArticuloDeLibreria extends Producto {

    public ArticuloDeLibreria(double precioDeVenta) {
        super(precioDeVenta);
    }

    @Override
    public double obtenerPrecio() {
        return super.obtenerPrecio() * 1.21;
    }
}
