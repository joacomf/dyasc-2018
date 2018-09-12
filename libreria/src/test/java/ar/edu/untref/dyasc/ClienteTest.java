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

        Map<Integer, List<Producto>> listaDeProductos = cliente.obtenerListadoCompletoDeProductosComprados();

        Assert.assertEquals(new HashMap<Integer, List<Producto>>(), listaDeProductos);
    }

    @Test
    public void seCreaClienteConListaDeSuscripcionesVacia() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Junin 320", LocalDate.of(1978, 2, 2));

        List<Suscribible> listaDeSuscripciones = cliente.obtenerListaDeSuscripciones();

        Assert.assertEquals(new ArrayList<Suscribible>(), listaDeSuscripciones);
    }

    @Test
    public void seObtieneListadoDeProductosVacioDelClienteEnElMes1YAño2018() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Junin 320", LocalDate.of(1978, 2, 2));

        LocalDate fecha = LocalDate.of(2018, 1, 1);
        List<Producto> listaDeProductos = cliente.obtenerListadoDeProductosEnElMesYAñoDeLaFecha(fecha);

        Assert.assertEquals(null, listaDeProductos);
    }

    @Test
    public void seObtieneListadoDeProductosDelClienteEnElMes5YAño2018() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Junin 320", LocalDate.of(1978, 2, 2));
        Producto productoDePrueba = new Producto(0);
        LocalDate fechaDeCompra = LocalDate.of(2018, 5, 12);
        ArrayList<Producto> listaStub = new ArrayList<Producto>();
        listaStub.add(productoDePrueba);

        cliente.comprarProducto(productoDePrueba, fechaDeCompra);
        List<Producto> listaDeProductos = cliente.obtenerListadoDeProductosEnElMesYAñoDeLaFecha(fechaDeCompra);

        Assert.assertEquals(listaStub, listaDeProductos);
    }

    @Test
    public void clienteCompraLibroYSeObtieneElSaldoDeFinDeMes() {
        double precioDeVenta = 50.2;

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Junin 320", LocalDate.of(1978, 2, 2));
        Libro productoDePrueba = new Libro(precioDeVenta);
        ArrayList<Producto> listaStub = new ArrayList<Producto>();
        LocalDate fechaDeCompra = LocalDate.of(2018, 5, 12);

        listaStub.add(productoDePrueba);

        cliente.comprarProducto(productoDePrueba, fechaDeCompra);
        double resumenDelMesDeJunio = cliente.obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(fechaDeCompra);

        Assert.assertEquals(precioDeVenta, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void clienteCompraLibroYCuadernoYSeObtieneElSaldoDeFinDeMes() {
        double precioDeVentaLibro = 30.2;
        double precioDeVentaArticuloDeLibreria = 70.0;

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, "Junin 320", LocalDate.of(1978, 2, 2));
        Libro libroDePrueba = new Libro(precioDeVentaLibro);
        ArticuloDeLibreria cuadernoDePrueba = new ArticuloDeLibreria(precioDeVentaArticuloDeLibreria);
        ArrayList<Producto> listaStub = new ArrayList<Producto>();
        LocalDate fechaDeCompra = LocalDate.of(2018, 5, 12);

        listaStub.add(libroDePrueba);
        listaStub.add(cuadernoDePrueba);

        cliente.comprarProducto(libroDePrueba, fechaDeCompra);
        cliente.comprarProducto(cuadernoDePrueba, fechaDeCompra);

        double resumenDelMesDeJunio = cliente.obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(fechaDeCompra);

        Assert.assertEquals(100.2, resumenDelMesDeJunio, 0.01);
    }
}
