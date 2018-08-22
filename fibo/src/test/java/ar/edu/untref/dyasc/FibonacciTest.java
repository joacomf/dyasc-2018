package ar.edu.untref.dyasc;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void creaSucesionDeFibonacciCon2Iteraciones() {
        
        Integer[] sucesionEsperada = {0, 1};
        List<Integer> listaEsperada = Arrays.asList(sucesionEsperada);
        
        Fibonacci fibonacci = new Fibonacci();
        
        fibonacci.generarSucesion(2);
        
        Assert.assertEquals(listaEsperada, fibonacci.getSucesion());
    }
    
    @Test
    public void creaSucesionDeFibonacciCon5Iteraciones() {
        
        Integer[] sucesionEsperada = {0, 1, 1, 2, 3};
        List<Integer> listaEsperada = Arrays.asList(sucesionEsperada);
        
        Fibonacci fibonacci = new Fibonacci();
        
        fibonacci.generarSucesion(5);
        
        Assert.assertEquals(listaEsperada, fibonacci.getSucesion());
    }
}
