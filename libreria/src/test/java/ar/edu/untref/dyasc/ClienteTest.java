package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void seCreaClienteDeNombrePepe() {
        Cliente cliente = new Cliente("pepe");

        Assert.assertEquals("pepe", cliente.obtenerNombre());
    }

}
