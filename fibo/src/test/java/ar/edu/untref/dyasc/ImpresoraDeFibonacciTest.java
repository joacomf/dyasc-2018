package ar.edu.untref.dyasc;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ImpresoraDeFibonacciTest {

    @Test
    public void imprimirSucesionVacia() {

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(new LinkedList<Integer>());

        String resultado = impresora.imprimir();

        Assert.assertEquals("", resultado);
    }
    
    @Test
    public void imprimirSucesionDeDosPosiciones() {
        
        List<Integer> esperado = new LinkedList<>();
        esperado.add(0);
        esperado.add(1);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(esperado);

        String resultado = impresora.imprimir();

        Assert.assertEquals(" 0 1", resultado);
    }
}
