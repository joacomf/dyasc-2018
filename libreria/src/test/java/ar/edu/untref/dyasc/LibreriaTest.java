package ar.edu.untref.dyasc;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {

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
