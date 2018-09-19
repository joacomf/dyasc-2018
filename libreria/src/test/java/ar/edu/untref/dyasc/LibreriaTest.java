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
    
    @Test
    public void clienteCompra5LibrosYDosRevistaEnEsteMesYSeVerificaSeDebeCobrarle1850DelCorrienteMes() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("Pepe", "Ruiz", "Azcuénaga 876", LocalDate.of(1988, 2, 11));

        Libro libroDePrueba_1 = new Libro(225);
        Libro libroDePrueba_2 = new Libro(325);
        Libro libroDePrueba_3 = new Libro(250);
        Libro libroDePrueba_4 = new Libro(150);
        ProductoSuscribible revistaDePrueba_1 = new Revista(100, 3);
        ProductoSuscribible revistaDePrueba_2 = new Revista(200, 3);
        LocalDate fechaDeCompra = LocalDate.of(2018, 6, 12);

        cliente.comprarProducto(libroDePrueba_1, fechaDeCompra);
        cliente.comprarProducto(libroDePrueba_2, fechaDeCompra);
        cliente.comprarProducto(libroDePrueba_3, fechaDeCompra);
        cliente.comprarProducto(libroDePrueba_4, fechaDeCompra);
        cliente.comprarProducto(revistaDePrueba_1, fechaDeCompra);
        cliente.comprarProducto(revistaDePrueba_2, fechaDeCompra);

        double resumenDelMesDeJunio = libreria.deudaDelClienteAlMesYAñoDeLaFecha(fechaDeCompra);

        Assert.assertEquals(1850, resumenDelMesDeJunio, 0.01);
    }

    public void clienteCompra2LibrosYDosArticulosDeLibreriaEnEsteMesYSeVerificaElPendienteDelCorrienteMes() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("Pepe", "Ruiz", "Azcuénaga 876", LocalDate.of(1988, 2, 11));

        Libro libroDePrueba_1 = new Libro(225);
        Libro libroDePrueba_2 = new Libro(325);
        Producto articulo_1 = new ArticuloDeLibreria(100);
        Producto articulo_2 = new ArticuloDeLibreria(200);
        LocalDate fechaDeCompra = LocalDate.of(2018, 6, 1);

        cliente.comprarProducto(libroDePrueba_1, fechaDeCompra);
        cliente.comprarProducto(libroDePrueba_2, fechaDeCompra);
        cliente.comprarProducto(articulo_1, fechaDeCompra);
        cliente.comprarProducto(articulo_2, fechaDeCompra);

        double resumenDelMesDeJunio = libreria.deudaDelClienteAlMesYAñoDeLaFecha(fechaDeCompra);

        Assert.assertEquals(913, resumenDelMesDeJunio, 0.01);
    }
}
