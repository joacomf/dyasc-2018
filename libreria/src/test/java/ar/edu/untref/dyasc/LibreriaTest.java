package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.productos.*;
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
    public void laLibreriaTieneClienteAlCualSeVendeUnLibroEnElDia() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("Pepe", "Diaz", 1230495, null, null);
        Producto libro = new Libro(120);

        libreria.agregarCliente(cliente);
        libreria.venderProducto(libro, cliente);

        double deudaDelCliente = libreria.deudaDelClienteEsteMes(cliente);

        Assert.assertEquals(114.0, deudaDelCliente, 0.1);
    }

    @Test
    public void seVendeLibroEnJunioDel2018YSeObtieneElSaldoDeFinDeMes() {
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
        Suscripcion revistaDePrueba = new Revista(precioDeRevista, 3);

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

        double deudaDelCliente = libreria.deudaDelClienteEsteMes(cliente);

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
        Suscripcion revista = new Revista(100.0, 8);

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

        Suscripcion revistaDePrueba_1 = new Revista(100, 3);
        Suscripcion revistaDePrueba_2 = new Revista(200, 3);

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

        Suscripcion articulo = new Revista(1000, 3);

        libreria.venderProducto(articulo, cliente, LocalDate.of(2018, 3, 1));

        int año = 2018;

        double resumenDelMesDeJunio = libreria.deudaDelClienteEnElAño(cliente, año);

        Assert.assertEquals(2400, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void seRegistraClienteYSeVendeUnLibroEnElMomentoUnicamenteConDatoDeDNI() throws ClienteNoRegistradoException {
        int dniDelCliente = 10235478;

        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, dniDelCliente, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        Producto libro = new Libro(200);

        libreria.agregarCliente(cliente);

        libreria.venderProducto(libro, dniDelCliente);

        double resumenDelMesDeJunio = libreria.deudaDelClienteEsteMes(cliente);

        Assert.assertEquals(190, resumenDelMesDeJunio, 0.01);
    }

    @Test(expected = ClienteNoRegistradoException.class)
    public void seVendePorDNIEnElMomentoUnLibroAUnClienteInexistenteEnElLaLibreria() throws ClienteNoRegistradoException {
        int dniDelCliente = 10235478;

        Libreria libreria = new Libreria();

        Producto libro = new ArticuloDeLibreria(100);

        libreria.venderProducto(libro, dniDelCliente);
    }

    @Test
    public void seVendeEnElMomentoSuscripcionAClientePorDNIRegistradoEnElListadoDeLaLibreria() throws ClienteNoRegistradoException {
        int dniDelCliente = 12548777;

        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, dniDelCliente, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        Suscripcion revista = new Revista(200, 2);

        libreria.agregarCliente(cliente);

        libreria.venderProducto(revista, dniDelCliente);

        double resumenDelMes = libreria.deudaDelClienteEsteMes(cliente);

        Assert.assertEquals(320, resumenDelMes, 0.01);
    }

    @Test
    public void seVendeSuscripcionAClientePorDNIRegistradoEnElListadoDeLaLibreria() throws ClienteNoRegistradoException {
        int dniDelCliente = 12548777;

        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, dniDelCliente, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        Suscripcion revista = new Periodico(200, 2);

        libreria.agregarCliente(cliente);

        libreria.venderProducto(revista, dniDelCliente);

        double resumenDelMes = libreria.deudaDelClienteEsteMes(cliente);

        Assert.assertEquals(320, resumenDelMes, 0.01);
    }

    @Test
    public void agregaTresClientesYVendeProductoASoloUno() throws ClienteNoRegistradoException {
        int dniDelClienteLuis = 12548777;

        Libreria libreria = new Libreria();

        Cliente cliente_luis = new Cliente("Luis", "Diaz", dniDelClienteLuis, "Calle Falsa 123", LocalDate.of(1995, 9, 15));
        Cliente cliente_carlos = new Cliente("Carlos", "Lopez", 15482222, "Calle Falsa 444", LocalDate.of(1955, 3, 15));
        Cliente cliente_gerardo = new Cliente("Gerardo", "Diaz", 12348569, "Calle Lopez 123", LocalDate.of(1983, 9, 15));

        Suscripcion revista = new Revista(200, 2);

        libreria.agregarCliente(cliente_luis);

        libreria.venderProducto(revista, dniDelClienteLuis);

        double resumenDelMesDeLuis = libreria.deudaDelClienteEsteMes(cliente_luis);
        double resumenDelMesDeCarlos = libreria.deudaDelClienteEsteMes(cliente_carlos);
        double resumenDelMesDeGerardo = libreria.deudaDelClienteEsteMes(cliente_gerardo);

        Assert.assertEquals(320, resumenDelMesDeLuis, 0.01);
        Assert.assertEquals(0, resumenDelMesDeCarlos, 0.01);
        Assert.assertEquals(0, resumenDelMesDeGerardo, 0.01);
    }

    @Test
    public void agregaTresClientesYVendeProductoASoloUnoYObtieneDeudaDelMesPorDNI() throws ClienteNoRegistradoException {
        int dniDelClienteLuis = 12548777;
        int dniDelClienteCarlos = 15482222;
        int dniDelClienteGerardo = 12348569;

        Libreria libreria = new Libreria();

        Cliente cliente_luis = new Cliente("Luis", "Diaz", dniDelClienteLuis, "Calle Falsa 123", LocalDate.of(1995, 9, 15));
        Cliente cliente_carlos = new Cliente("Carlos", "Lopez", dniDelClienteCarlos, "Calle Falsa 444", LocalDate.of(1955, 3, 15));
        Cliente cliente_gerardo = new Cliente("Gerardo", "Diaz", dniDelClienteGerardo, "Calle Lopez 123", LocalDate.of(1983, 9, 15));

        Suscripcion revista = new Periodico(200, 2);

        libreria.agregarCliente(cliente_luis);

        libreria.venderProducto(revista, dniDelClienteLuis);

        double resumenDelMesDeLuis = libreria.deudaDelClienteEsteMes(dniDelClienteLuis);
        double resumenDelMesDeCarlos = libreria.deudaDelClienteEsteMes(cliente_carlos);
        double resumenDelMesDeGerardo = libreria.deudaDelClienteEsteMes(cliente_gerardo);

        Assert.assertEquals(320, resumenDelMesDeLuis, 0.01);
        Assert.assertEquals(0, resumenDelMesDeCarlos, 0.01);
        Assert.assertEquals(0, resumenDelMesDeGerardo, 0.01);
    }

    @Test
    public void vendeSuscripcionAClienteElMesDeEneroYObtieneDeudaDelMesPorDNI() throws ClienteNoRegistradoException {
        int dniDelClienteLuis = 12548777;

        Libreria libreria = new Libreria();

        Cliente cliente_luis = new Cliente("Luis", "Diaz", dniDelClienteLuis, "Calle Falsa 123", LocalDate.of(1995, 9, 15));

        Suscripcion revista = new Revista(200, 2);

        libreria.agregarCliente(cliente_luis);

        libreria.venderProducto(revista, dniDelClienteLuis, LocalDate.of(2018, 1, 5));

        double resumenDelMesDeLuis = libreria.deudaDelClienteEnElMesYAño(1, 2018, dniDelClienteLuis);

        Assert.assertEquals(320, resumenDelMesDeLuis, 0.01);
    }

    @Test
    public void vendeSuscripcionAClienteElMesDeEneroYLibroEnMarzoYObtieneDeudaDelAñoPorDNI() throws ClienteNoRegistradoException {
        int dniDelClienteLuis = 12548777;

        Libreria libreria = new Libreria();

        Cliente cliente_luis = new Cliente("Luis", "Diaz", dniDelClienteLuis, "Calle Falsa 123", LocalDate.of(1995, 9, 15));

        Suscripcion revista = new Periodico(200, 2);
        Producto libro = new Libro(200);

        libreria.agregarCliente(cliente_luis);

        libreria.venderProducto(revista, dniDelClienteLuis, LocalDate.of(2018, 1, 5));
        libreria.venderProducto(libro, dniDelClienteLuis, LocalDate.of(2018, 3, 5));

        double resumenDelAñoDeLuis = libreria.deudaDelClienteEnElAño(dniDelClienteLuis, 2018);

        Assert.assertEquals(510, resumenDelAñoDeLuis, 0.01);
    }

    @Test
    public void vendeProductosEn4MesesDistintosEn2AñosDiferentesYObtieneLaDeudaDeUnAñoExcluyendoLosProductosDelOtroAño() throws ClienteNoRegistradoException {
        int dniDelClienteLuis = 12548777;

        Libreria libreria = new Libreria();

        Cliente cliente_luis = new Cliente("Luis", "Diaz", dniDelClienteLuis, "Calle Falsa 123", LocalDate.of(1995, 9, 15));

        Suscripcion revista = new Periodico(200, 2);
        Producto libro = new Libro(100);
        Producto lapices = new ArticuloDeLibreria(100);
        Producto manual = new Libro(535);

        libreria.agregarCliente(cliente_luis);

        libreria.venderProducto(revista, dniDelClienteLuis, LocalDate.of(2018, 1, 5));
        libreria.venderProducto(libro, dniDelClienteLuis, LocalDate.of(2018, 3, 15));
        libreria.venderProducto(lapices, dniDelClienteLuis, LocalDate.of(2017, 3, 22));
        libreria.venderProducto(manual, dniDelClienteLuis, LocalDate.of(2017, 11, 3));

        double resumenDelAño2018DeLuis = libreria.deudaDelClienteEnElAño(dniDelClienteLuis, 2018);

        Assert.assertEquals(415.0, resumenDelAño2018DeLuis, 0.01);
    }
}
