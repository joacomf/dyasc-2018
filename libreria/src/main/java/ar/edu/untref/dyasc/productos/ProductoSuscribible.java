package ar.edu.untref.dyasc.productos;

public class ProductoSuscribible extends Producto{

    private int periodicidad = 0;

    public ProductoSuscribible(double precio) {
        this(precio, 1);
    }

    public ProductoSuscribible(double precio, int periodicidad) {
        super(precio);
        this.setPeriodicidad(periodicidad);
    }

    public int obtenerPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }
}
