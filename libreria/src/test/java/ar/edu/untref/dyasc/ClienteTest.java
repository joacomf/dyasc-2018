package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void seCreaClienteDeNombrePepe() {
        Cliente cliente = new Cliente("Pepe", "Campaner");

        Assert.assertEquals("Pepe", cliente.obtenerNombre());
        Assert.assertEquals("Campaner", cliente.obtenerApellido());
    }

    @Test
    public void seCreaClienteDeNombreLuisYApellidoDiaz() {
        Cliente cliente = new Cliente("Luis", "Diaz");

        Assert.assertEquals("Luis", cliente.obtenerNombre());
        Assert.assertEquals("Diaz", cliente.obtenerApellido());
    }

}
