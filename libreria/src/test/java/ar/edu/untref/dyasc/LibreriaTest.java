package ar.edu.untref.dyasc;

import java.time.LocalDate;
import java.util.Arrays;

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

        Cliente cliente = new Cliente("Pepe", "Ruiz", "Azcuénaga 876", LocalDate.of(1988, 2, 11));
        Producto libro = new Producto(10.0);

        libreria.venderProducto(libro, cliente);

        Assert.assertEquals(Arrays.asList(libro), cliente.obtenerListadoDeProductosEnElMesYAñoDeLaFecha(LocalDate.now()));
    }

    @Test
    public void seVendeUnVariosProductosAClientePorMontoDe500() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("Pepe", "Ruiz", "Azcuénaga 876", LocalDate.of(1988, 2, 11));
        Producto libro = new Libro(200.0);
        Producto hojas = new ArticuloDeLibreria(200.0);
        Producto packDeLapices = new ArticuloDeLibreria(100.0);

        libreria.venderProducto(libro, cliente);
        libreria.venderProducto(hojas, cliente);
        libreria.venderProducto(packDeLapices, cliente);

        Assert.assertEquals(563.0, cliente.obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(LocalDate.now()), 0.1);
    }

    @Test
    public void seVendeSuscripcionARevistaPor8MesesYLibro() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("Pepe", "Ruiz", "Azcuénaga 876", LocalDate.of(1988, 2, 11));
        Producto libro = new Libro(200.0);
        ProductoSuscribible revista = new Revista(100.0, 8);

        libreria.venderProducto(libro, cliente);
        libreria.venderSuscripcionAProducto(revista, cliente);

        Assert.assertEquals(1000.0, cliente.obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(LocalDate.now()), 0.1);
    }

    @Test
    public void seVendeaArticuloDeLibreriaYSeVerificaQueSeCobreElIVA() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("Pepe", "Ruiz", "Azcuénaga 876", LocalDate.of(1988, 2, 11));
        Producto papel = new ArticuloDeLibreria(100.0);

        libreria.venderProducto(papel, cliente);

        Assert.assertEquals(121.0, cliente.obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(LocalDate.now()), 0.1);
    }
}
