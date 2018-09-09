package ar.edu.untref.dyasc;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void seCreaClienteDeNombrePepe() {
        Cliente cliente = new Cliente("Pepe", "Campaner", null, null);

        Assert.assertEquals("Pepe", cliente.obtenerNombre());
        Assert.assertEquals("Campaner", cliente.obtenerApellido());
    }

    @Test
    public void seCreaClienteDeNombreLuisYApellidoDiaz() {
        Cliente cliente = new Cliente("Luis", "Diaz", null, null);

        Assert.assertEquals("Luis", cliente.obtenerNombre());
        Assert.assertEquals("Diaz", cliente.obtenerApellido());
    }

    @Test
    public void seCreaClienteDeNombreLuisYApellidoDiazConDireccionJunin320YFechaDeNacimientoEl3DeMarzoDe1978() {
        Cliente cliente = new Cliente("Luis", "Diaz", "Junin 320", LocalDate.of(1978, 2, 2));

        Assert.assertEquals(LocalDate.of(1978, 2, 2), cliente.obtenerFechaNacimiento());
        Assert.assertEquals("Junin 320", cliente.obtenerDireccion());
    }

}
