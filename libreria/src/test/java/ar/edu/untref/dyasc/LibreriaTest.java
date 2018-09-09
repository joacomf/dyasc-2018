package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {

    @Test
    public void existeLibreria() {
        new Libreria();
    }

    @Test
    public void seVendeUnProductoLibroAlClienteDeNombrePepe() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("pepe", null, null, null);
        Producto libro = new Producto();

        boolean vendioLibroACliente = libreria.venderProducto(libro, cliente);

        Assert.assertTrue(vendioLibroACliente);

    }

}
