package ar.edu.untref.dyasc.productos;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloDeLibreriaTest {

    @Test
    public void creaArticuloDeLibreriaYObtienePrecioConIVAde21Porciento(){
        double precio = 100;
        double precioConIva = precio * 1.21;

        ArticuloDeLibreria lapices = new ArticuloDeLibreria(precio);

        Assert.assertEquals(precioConIva, lapices.obtenerPrecio(), 0.1);
    }
}
