package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mocks.FibonacciMock;

public class ImpresoraDeFibonacciTest {

    private FibonacciMock fibonacci;
    private List<Long> listado;

    @Before
    public void prepararFibonacci() {
        this.fibonacci = new FibonacciMock();
        this.listado = new ArrayList<>();
    }

    @After
    public void limpiarListado() {
        this.listado.clear();
    }

    @Test
    public void imprimirSucesionVacia() {

        fibonacci.setSucesion(listado);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<0>:", resultado);
    }

    @Test
    public void imprimirSucesionConUnValor() {

        listado.add(0L);
        fibonacci.setSucesion(listado);
        fibonacci.generarSucesion(1);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<1>: 0", resultado);
    }

    @Test
    public void imprimirSucesionDe2Posiciones() {

        listado.add(0L);
        listado.add(1L);
        fibonacci.setSucesion(listado);
        fibonacci.generarSucesion(2);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<2>: 0 1", resultado);
    }

    @Test
    public void imprimirSucesionDe5Posiciones() {

        listado.add(0L);
        listado.add(1L);
        listado.add(1L);
        listado.add(2L);
        listado.add(3L);
        fibonacci.setSucesion(listado);
        fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>: 0 1 1 2 3", resultado);
    }

    @Test
    public void imprimirSucesionDe5PosicionesVertical() {

        listado.add(0L);
        listado.add(1L);
        listado.add(1L);
        listado.add(2L);
        listado.add(3L);
        fibonacci.setSucesion(listado);
        fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci, false, true);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>:\n0\n1\n1\n2\n3", resultado);
    }

    @Test
    public void imprimirSucesionDe5PosicionesVerticalYAlReves() {

        listado.add(0L);
        listado.add(1L);
        listado.add(1L);
        listado.add(2L);
        listado.add(3L);
        fibonacci.setSucesion(listado);
        fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci, false, false);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>:\n3\n2\n1\n1\n0", resultado);
    }

    @Test
    public void imprimirSucesionDe5PosicionesHorizontalYAlReves() {

        listado.add(0L);
        listado.add(1L);
        listado.add(1L);
        listado.add(2L);
        listado.add(3L);
        fibonacci.setSucesion(listado);
        fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci, true, false);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>: 3 2 1 1 0", resultado);
    }

    @Test
    public void imprimirSucesionDe5PosicionesHorizontalYAlRevesYConSumatoria() {

        fibonacci.setSucesion(listado);
        fibonacci.setSumatoria(7);
        fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci, true, false, true);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>s: 7", resultado);
    }

}
