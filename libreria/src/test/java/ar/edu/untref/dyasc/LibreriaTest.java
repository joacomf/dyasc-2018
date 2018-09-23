package ar.edu.untref.dyasc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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

        Assert.assertEquals(120.0, deudaDelCliente, 0.1);
    }

    @Test
    public void clienteCompraLibroYSeObtieneElSaldoDeFinDeMes() {
        Libreria libreria = new Libreria();

        double precioDeVenta = 50.2;

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Libro productoDePrueba = new Libro(precioDeVenta);

        LocalDate fechaDeCompra = LocalDate.of(2018, 6, 12);
        Integer mes = fechaDeCompra.getMonthValue();
        Integer año = fechaDeCompra.getYear();

        libreria.venderProducto(productoDePrueba, cliente, fechaDeCompra);
        double resumenDelMesDeJunio = libreria.cuantoDebeElClienteEnElMesYAño(mes, año, cliente);

        Assert.assertEquals(47.69, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void clienteCompraLibroYCuadernoYSeObtieneElSaldoDeFinDeMes() {
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

        double resumenDelMesDeJunio = cliente.obtenerResumenDeCuentaCorrienteDelMesYAñoDeLaFecha(mes, año);

        Assert.assertEquals(100.2, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void clienteCompraLibroYUnaRevistaYSeVerificaQueTieneUnaSuscripcionEnEseMes() {
        Libreria libreria = new Libreria();

        double precioDeVentaLibro = 30.2;
        double precioDeRevista = 70.0;

        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Producto libroDePrueba = new Libro(precioDeVentaLibro);
        ProductoSuscribible revistaDePrueba = new Revista(precioDeRevista, 3);

        LocalDate fechaDeCompra = LocalDate.of(2018, 5, 12);
        Integer mes = fechaDeCompra.getMonthValue();
        Integer año = fechaDeCompra.getYear();

        //List<ProductoSuscribible> listadoSuscripcionesStub = new ArrayList<>();

        libreria.venderProducto(libroDePrueba, cliente, fechaDeCompra);
        libreria.venderProducto(revistaDePrueba, cliente, fechaDeCompra);

        double resumenDelMesDeJunio = libreria.cuantoDebeElClienteEnElMesYAño(mes, año, cliente);

        Assert.assertEquals(196.69, resumenDelMesDeJunio, 0.01);
    }

    @Test
    public void laLibreriaTieneClienteAlCualSeVendeUnLibroYUnArticuloDeLibreria() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("Pepe", "Diaz", 1230495, null, null);
        Producto libro = new Libro(120);
        ArticuloDeLibreria lapicero = new ArticuloDeLibreria(120);

        libreria.agregarCliente(cliente);
        libreria.venderProducto(libro, cliente);
        libreria.venderProducto(lapicero, cliente);

        double deudaDelCliente = libreria.cuantoDebeElClienteEsteMes(cliente);

        Assert.assertEquals(240.0, deudaDelCliente, 0.1);
    }

    @Test
    public void seVendeUnLibroDistintoDurante3MesesYUnaSubscripcionYSeVerificaLaDeudaAnualDelCliente() {
        Libreria libreria = new Libreria();

        Cliente cliente = new Cliente("Pepe", "Diaz", 1230495, null, null);

        Producto dessignPatterns = new Libro(820);
        Producto domainDrivenDesign = new Libro(900);
        Producto growingObjectOrientedSoftware = new Libro(856);

        libreria.agregarCliente(cliente);
        libreria.venderProducto(dessignPatterns, cliente, LocalDate.of(2018, 1, 1));
        libreria.venderProducto(domainDrivenDesign, cliente, LocalDate.of(2018, 2, 1));
        libreria.venderProducto(growingObjectOrientedSoftware, cliente, LocalDate.of(2018, 3, 1));

        double deudaDelCliente = libreria.cuantoDebeElClienteEnElAño(cliente, 2018);

        Assert.assertEquals(2576.0, deudaDelCliente, 0.1);
    }
}
