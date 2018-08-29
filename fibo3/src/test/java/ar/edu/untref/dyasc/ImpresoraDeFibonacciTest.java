package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImpresoraDeFibonacciTest {

    private Fibonacci fibonacci;

    @Before
    public void prepararFibonacci() {
        this.fibonacci = new Fibonacci();
    }

    @Test
    public void imprimirSucesionVacia() {

        fibonacci.generarSucesion(0);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<0>:", resultado);
    }

    @Test
    public void imprimirSucesionConUnValor() {

        fibonacci.generarSucesion(1);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<1>: 0", resultado);
    }

    @Test
    public void imprimirSucesionDe2Posiciones() {

        this.fibonacci.generarSucesion(2);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<2>: 0 1", resultado);
    }

    @Test
    public void imprimirSucesionDe5Posiciones() {

        this.fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>: 0 1 1 2 3", resultado);
    }

    @Test
    public void imprimirSucesionDe5PosicionesVertical() {

        this.fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci, false, true);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>:\n0\n1\n1\n2\n3", resultado);
    }

    @Test
    public void imprimirSucesionDe5PosicionesVerticalYAlReves() {

        this.fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci, false, false);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>:\n3\n2\n1\n1\n0", resultado);
    }

    @Test
    public void imprimirSucesionDe5PosicionesHorizontalYAlReves() {

        this.fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci, true, false);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>: 3 2 1 1 0", resultado);
    }

    @Test
    public void imprimirSucesionDe5PosicionesHorizontalYAlRevesYConSumatoria() {

        this.fibonacci.generarSucesion(5);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(this.fibonacci, true, false, true);

        String resultado = impresora.imprimir();

        Assert.assertEquals("fibo<5>s: 7", resultado);
    }}
