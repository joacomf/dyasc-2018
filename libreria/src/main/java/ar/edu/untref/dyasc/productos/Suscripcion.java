package ar.edu.untref.dyasc.productos;

public abstract class Suscripcion extends Producto{

    private int periodicidad = 0;

    Suscripcion(double precio, int periodicidad) {
        super(precio);
        this.setPeriodicidad(periodicidad);
    }

    Suscripcion(double precio) {
        this(precio, 1);
    }

    public int obtenerPeriodicidad() {
        return periodicidad;
    }

    public double obtenerPrecioMensual() {
        return this.obtenerPrecio() * this.obtenerPeriodicidad();
    }

    private void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }
}
