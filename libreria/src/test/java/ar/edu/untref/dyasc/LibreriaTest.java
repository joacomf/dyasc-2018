package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibreriaTest {

    private static final LocalDate FECHA_NACIMIENTO_LUIZ_DIAZ = LocalDate.of(1978, 2, 2);
    private static final String APELLIDO_USUARIO_DIAZ = "Diaz";
    private static final String NOMBRE_USUARIO_LUIS = "Luis";
    private static final String DIRECCION_DE_LUIS_DIAZ = "Junin 320";
    private static final int DNI_LUIZ_DIAZ = 12304052;

    @Test
    public void existeLibreria() {
        new Libreria();
    }

    @Test
    public void laLibreriaTieneClienteAlCualSeVendeUnLibro() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("Pepe", "Diaz", 1230495, null, null);
        Producto libro = new Libro(120);

        libreria.agregarCliente(cliente);
        libreria.venderProducto(libro, cliente);

        double deudaDelCliente = libreria.cuantoDebeElClienteEsteMes(cliente);

        Assert.assertEquals(114.0, deudaDelCliente, 0.1);
    }

    @Test
    public void seVendeLibroYSeObtieneElSaldoDeFinDeMes() {
        Libreria libreria = new Libreria();

        double precioDeVenta = 50.2;

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Libro productoDePrueba = new Libro(precioDeVenta);

        LocalDate fechaDeCompra = LocalDate.of(2018, 6, 12);
        Integer mes = fechaDeCompra.getMonthValue();
        Integer año = fechaDeCompra.getYear();

        libreria.venderProducto(productoDePrueba, cliente, fechaDeCompra);
        double resumenDelMesDeJunio = libreria.deudaDelClienteEnElMesYAño(mes, año, cliente);

        Assert.assertEquals(47.69, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void seVendeLibroLibroYCuadernoYSeObtieneElSaldoAdeudadoDeFinDeMes() {
        Libreria libreria = new Libreria();

        double precioDeVentaLibro = 30.2;
        double precioDeVentaArticuloDeLibreria = 70.0;

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Libro libroDePrueba = new Libro(precioDeVentaLibro);
        ArticuloDeLibreria cuadernoDePrueba = new ArticuloDeLibreria(precioDeVentaArticuloDeLibreria);

        LocalDate fechaDeCompra = LocalDate.of(2018, 5, 12);
        Integer mes = fechaDeCompra.getMonthValue();
        Integer año = fechaDeCompra.getYear();

        cliente.comprarProducto(libroDePrueba, fechaDeCompra);
        cliente.comprarProducto(cuadernoDePrueba, fechaDeCompra);

        double resumenDelMesDeJunio = libreria.deudaDelClienteEnElMesYAño(mes, año, cliente);

        Assert.assertEquals(109.15, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void seVendeUnLibroYUnaRevistaAUnClienteYSeVerificaLaDeudaMensualDelLibroYLaRevistaConSuPeriodicidad() {
        Libreria libreria = new Libreria();

        double precioDeVentaLibro = 30.2;
        double precioDeRevista = 70.0;

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Producto libroDePrueba = new Libro(precioDeVentaLibro);
        ProductoSuscribible revistaDePrueba = new Revista(precioDeRevista, 3);

        LocalDate fechaDeCompra = LocalDate.of(2018, 5, 12);
        Integer mes = fechaDeCompra.getMonthValue();
        Integer año = fechaDeCompra.getYear();

        libreria.venderProducto(libroDePrueba, cliente, fechaDeCompra);
        libreria.venderProducto(revistaDePrueba, cliente, fechaDeCompra);

        double resumenDelMesDeJunio = libreria.deudaDelClienteEnElMesYAño(mes, año, cliente);

        Assert.assertEquals(196.69, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void laLibreriaTieneClienteAlCualSeVendeUnLibroYUnArticuloDeLibreria() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Producto libro = new Libro(120);
        ArticuloDeLibreria lapicero = new ArticuloDeLibreria(120);

        libreria.agregarCliente(cliente);
        libreria.venderProducto(libro, cliente);
        libreria.venderProducto(lapicero, cliente);

        double deudaDelCliente = libreria.cuantoDebeElClienteEsteMes(cliente);

        Assert.assertEquals(251.93, deudaDelCliente, 0.1);
    }

    @Test
    public void seVendeUnLibroDistintoDurante3MesesYUnaSubscripcionYSeVerificaLaDeudaAnualDelCliente() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        Producto dessignPatterns = new Libro(820);
        Producto domainDrivenDesign = new Libro(900);
        Producto growingObjectOrientedSoftware = new Libro(856);

        libreria.agregarCliente(cliente);
        libreria.venderProducto(dessignPatterns, cliente, LocalDate.of(2018, 1, 1));
        libreria.venderProducto(domainDrivenDesign, cliente, LocalDate.of(2018, 2, 1));
        libreria.venderProducto(growingObjectOrientedSoftware, cliente, LocalDate.of(2018, 3, 1));

        double deudaDelCliente = libreria.deudaDelClienteEnElAño(cliente, 2018);

        Assert.assertEquals(2447.2, deudaDelCliente, 0.1);
    }

    @Test
    public void seVendeUnVariosProductosAClientePorMontoDe500() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Producto libro = new Libro(200.0);
        Producto hojas = new ArticuloDeLibreria(200.0);
        Producto packDeLapices = new ArticuloDeLibreria(100.0);

        libreria.venderProducto(libro, cliente);
        libreria.venderProducto(hojas, cliente);
        libreria.venderProducto(packDeLapices, cliente);

        LocalDate fecha = LocalDate.now();
        int mes = fecha.getMonthValue();
        int año = fecha.getYear();

        double deudaDelCliente = libreria.deudaDelClienteEnElMesYAño(mes, año, cliente);

        Assert.assertEquals(534.85, deudaDelCliente, 0.1);
    }

    @Test
    public void seVendeSuscripcionARevistaPor8MesesYLibro() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Producto libro = new Libro(200.0);
        ProductoSuscribible revista = new Revista(100.0, 8);

        libreria.venderProducto(libro, cliente);
        libreria.venderProducto(revista, cliente);

        LocalDate fecha = LocalDate.now();
        int mes = fecha.getMonthValue();
        int año = fecha.getYear();

        double deudaDelCliente = libreria.deudaDelClienteEnElMesYAño(mes, año, cliente);

        Assert.assertEquals(830.0, deudaDelCliente, 0.1);
    }

    @Test
    public void seVendeArticuloDeLibreriaYSeVerificaQueSeCobreElIVA() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Producto papel = new ArticuloDeLibreria(100.0);

        libreria.venderProducto(papel, cliente);

        LocalDate fecha = LocalDate.now();
        int mes = fecha.getMonthValue();
        int año = fecha.getYear();

        Assert.assertEquals(114.95, libreria.deudaDelClienteEnElMesYAño(mes, año, cliente), 0.1);
    }

    @Test
    public void seVende5LibrosYDosRevistaEnEsteMesYSeVerificaSeDebeCobrarleConDescuentoDel5PorcientoDelCorrienteMes() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        Libro libroDePrueba_1 = new Libro(225);
        Libro libroDePrueba_2 = new Libro(325);
        Libro libroDePrueba_3 = new Libro(250);
        Libro libroDePrueba_4 = new Libro(150);

        ProductoSuscribible revistaDePrueba_1 = new Revista(100, 3);
        ProductoSuscribible revistaDePrueba_2 = new Revista(200, 3);

        LocalDate fechaDeCompra = LocalDate.of(2018, 6, 12);

        libreria.venderProducto(libroDePrueba_1, cliente, fechaDeCompra);
        libreria.venderProducto(libroDePrueba_2, cliente, fechaDeCompra);
        libreria.venderProducto(libroDePrueba_3, cliente, fechaDeCompra);
        libreria.venderProducto(libroDePrueba_4, cliente, fechaDeCompra);
        libreria.venderProducto(revistaDePrueba_1, cliente, fechaDeCompra);
        libreria.venderProducto(revistaDePrueba_2, cliente, fechaDeCompra);

        int mes = fechaDeCompra.getMonthValue();
        int año = fechaDeCompra.getYear();

        double resumenDelMesDeJunio = libreria.deudaDelClienteEnElMesYAño(mes, año, cliente);

        Assert.assertEquals(1622.5, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void seVende2LibrosYDosArticulosDeLibreriaEnEsteMesYSeVerificaElPendienteDelCorrienteMes() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        Libro libroDePrueba_1 = new Libro(225);
        Libro libroDePrueba_2 = new Libro(325);
        Producto articulo_1 = new ArticuloDeLibreria(100);
        Producto articulo_2 = new ArticuloDeLibreria(200);
        LocalDate fechaDeCompra = LocalDate.of(2018, 6, 1);

        libreria.venderProducto(libroDePrueba_1, cliente, fechaDeCompra);
        libreria.venderProducto(libroDePrueba_2, cliente, fechaDeCompra);
        libreria.venderProducto(articulo_1, cliente, fechaDeCompra);
        libreria.venderProducto(articulo_2, cliente, fechaDeCompra);

        int mes = fechaDeCompra.getMonthValue();
        int año = fechaDeCompra.getYear();

        double resumenDelMesDeJunio = libreria.deudaDelClienteEnElMesYAño(mes, año, cliente);

        Assert.assertEquals(867.34, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void seVendeUnProductoDistintoDurante5mesesYSeVerificaLaDeudaAnual() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        Libro libroDePrueba_1 = new Libro(225);
        Libro libroDePrueba_2 = new Libro(325);
        Producto articulo_1 = new ArticuloDeLibreria(100);
        Producto articulo_2 = new ArticuloDeLibreria(200);

        libreria.venderProducto(libroDePrueba_1, cliente, LocalDate.of(2018, 1, 1));
        libreria.venderProducto(libroDePrueba_2, cliente, LocalDate.of(2018, 2, 1));
        libreria.venderProducto(articulo_1, cliente, LocalDate.of(2018, 3, 1));
        libreria.venderProducto(articulo_2, cliente, LocalDate.of(2018, 4, 1));

        int año = 2018;

        double resumenDelMesDeJunio = libreria.deudaDelClienteEnElAño(cliente, año);

        Assert.assertEquals(867.34, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void seVendeUnSuscripcionYSeVerificaElDescuentoDel20Porciento() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        ProductoSuscribible articulo = new Revista(1000, 3);

        libreria.venderProducto(articulo, cliente, LocalDate.of(2018, 3, 1));

        int año = 2018;

        double resumenDelMesDeJunio = libreria.deudaDelClienteEnElAño(cliente, año);

        Assert.assertEquals(2400, resumenDelMesDeJunio, 0.01);
    }
}
