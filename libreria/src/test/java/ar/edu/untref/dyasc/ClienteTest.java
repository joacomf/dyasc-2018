package ar.edu.untref.dyasc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    private static final String APELLIDO_USUARIO_DIAZ = "Diaz";
    private static final String NOMBRE_USUARIO_LUIS = "Luis";

    @Test
    public void seCreaClienteDeNombrePepe() {
        Cliente cliente = new Cliente("Pepe", "Campaner", null, null);

        Assert.assertEquals("Pepe", cliente.obtenerNombre());
        Assert.assertEquals("Campaner", cliente.obtenerApellido());
    }

    @Test
    public void seCreaClienteDeNombreLuisYApellidoDiazConDireccionDorrego418YFechaDeNacimientoEl1DeEneroDe1958() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Dorrego 418", LocalDate.of(1958, 1, 1));

        Assert.assertEquals(NOMBRE_USUARIO_LUIS, cliente.obtenerNombre());
        Assert.assertEquals(APELLIDO_USUARIO_DIAZ, cliente.obtenerApellido());
        Assert.assertEquals(LocalDate.of(1958, 1, 1), cliente.obtenerFechaNacimiento());
        Assert.assertEquals("Dorrego 418", cliente.obtenerDireccion());
    }

    @Test
    public void seCreaClienteDeNombreLuisYApellidoDiazConDireccionJunin320YFechaDeNacimientoEl3DeMarzoDe1978() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Junin 320", LocalDate.of(1978, 2, 2));

        Assert.assertEquals(NOMBRE_USUARIO_LUIS, cliente.obtenerNombre());
        Assert.assertEquals(APELLIDO_USUARIO_DIAZ, cliente.obtenerApellido());
        Assert.assertEquals(LocalDate.of(1978, 2, 2), cliente.obtenerFechaNacimiento());
        Assert.assertEquals("Junin 320", cliente.obtenerDireccion());
    }

    @Test
    public void seCreaClienteConMapaDeProductosVacio() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Junin 320", LocalDate.of(1978, 2, 2));

        Map<Integer, Producto> listaDeProductos = cliente.obtenerListadoCompletoDeProductosComprados();

        Assert.assertEquals(new HashMap<Integer, Producto>(), listaDeProductos);
    }

    @Test
    public void seCreaClienteConListaDeSuscripcionesVacia() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Junin 320", LocalDate.of(1978, 2, 2));

        List<Suscribible> listaDeSuscripciones = cliente.obtenerListaDeSuscripciones();

        Assert.assertEquals(new ArrayList<Suscribible>(), listaDeSuscripciones);
    }

    @Test
    public void seObtieneListadoDeProductosVacioDelClienteEnElMes1() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Junin 320", LocalDate.of(1978, 2, 2));

        List<Producto> listaDeProductos = cliente.obtenerListadoDeProductosEnElMesDelAño(1, 2018);

        Assert.assertEquals(new ArrayList<Producto>(), listaDeProductos);
    }
}
