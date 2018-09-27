package ar.edu.untref.dyasc.productos;

import org.junit.Assert;
import org.junit.Test;

public class LibroTest {

    @Test
    public void creaLibroYCorroboraQueElPrecioNoSeHayaModificado(){

        double precio = 525;

        Libro designPatterns = new Libro(precio);

        Assert.assertEquals(precio, designPatterns.obtenerPrecio(), 0.1);
    }
}
