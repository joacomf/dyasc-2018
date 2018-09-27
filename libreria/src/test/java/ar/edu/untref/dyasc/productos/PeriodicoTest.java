package ar.edu.untref.dyasc.productos;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicoTest {

    @Test
    public void creaPeriodicoConPeriodicidad4VecesPorMesYCorroboraQueSuPrecioMensualSeaElCuadruple(){

        double precio = 150;
        int periodicidad = 4;
        double precioConPeriodicidad = precio * periodicidad;

        Periodico laNacion = new Periodico(precio, periodicidad);

        Assert.assertEquals(precio, laNacion.obtenerPrecio(), 0.1);
        Assert.assertEquals(precioConPeriodicidad, laNacion.obtenerPrecioMensual(), 0.1);
    }

    @Test
    public void creaPeriodicoConPeriodicidadSinEspecificarPeriodicidadYEsperaQueSea1(){

        double precio = 243;

        Revista laVoz = new Revista(precio);

        Assert.assertEquals(precio, laVoz.obtenerPrecio(), 0.1);
        Assert.assertEquals(1, laVoz.obtenerPeriodicidad());
    }
}
