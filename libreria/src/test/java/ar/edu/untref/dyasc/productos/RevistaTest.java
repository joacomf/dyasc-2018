package ar.edu.untref.dyasc.productos;

import org.junit.Assert;
import org.junit.Test;

public class RevistaTest {

    @Test
    public void creaRevistaConPeriodicidad3VecesPorMesYCorroboraQueSuPrecioMensualSeaElTriplique(){

        double precio = 147;
        int periodicidad = 3;
        double precioConPeriodicidad = precio * periodicidad;

        Revista laNacion = new Revista(precio, periodicidad);

        Assert.assertEquals(precio, laNacion.obtenerPrecio(), 0.1);
        Assert.assertEquals(precioConPeriodicidad, laNacion.obtenerPrecioMensual(), 0.1);
    }

    @Test
    public void creaRevistaConPeriodicidadSinEspecificarPeriodicidadYEsperaQueSea1(){

        double precio = 243;

        Revista viva = new Revista(precio);

        Assert.assertEquals(precio, viva.obtenerPrecio(), 0.1);
        Assert.assertEquals(1, viva.obtenerPeriodicidad());
    }
}
