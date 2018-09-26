package ar.edu.untref.dyasc.productos;

public class Suscripcion extends Producto{

    private int periodicidad = 0;

    public Suscripcion(double precio, int periodicidad) {
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
