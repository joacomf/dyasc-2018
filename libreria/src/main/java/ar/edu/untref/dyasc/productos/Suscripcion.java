package ar.edu.untref.dyasc.productos;

public abstract class Suscripcion extends Producto{

    private int periodicidad = 0;

    Suscripcion(double precio, int periodicidad) {
        super(precio);
        this.setPeriodicidad(periodicidad);
    }

    public int obtenerPeriodicidad() {
        return periodicidad;
    }

    private void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }
}
