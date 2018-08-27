package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void creaSucesionDeFibonacciVacia() {
        Fibonacci fibonacci = new Fibonacci();

        List<Long> conjuntoVacio = new ArrayList<>();

        Assert.assertEquals(conjuntoVacio, fibonacci.getSucesion());
    }

    @Test
    public void creaSucesionDeFibonacciCon2Iteraciones() {

        Long[] sucesionEsperada = { 0L, 1L };
        List<Long> listaEsperada = Arrays.asList(sucesionEsperada);

        Fibonacci fibonacci = new Fibonacci();

        fibonacci.generarSucesion(2);

        Assert.assertEquals(listaEsperada, fibonacci.getSucesion());
    }

    @Test
    public void creaSucesionDeFibonacciCon5Iteraciones() {

        Long[] sucesionEsperada = { 0L, 1L, 1L, 2L, 3L };
        List<Long> listaEsperada = Arrays.asList(sucesionEsperada);

        Fibonacci fibonacci = new Fibonacci();

        fibonacci.generarSucesion(5);

        Assert.assertEquals(listaEsperada, fibonacci.getSucesion());
    }

    @Test
    public void creaSucesionDeFibonacciConSumatoria() {

        Long[] sucesionEsperada = { 0L, 1L, 1L, 2L, 3L };
        Long sumatoriaEsperada = 7L;

        List<Long> listaEsperada = Arrays.asList(sucesionEsperada);

        Fibonacci fibonacci = new Fibonacci();

        fibonacci.generarSucesion(5);

        Assert.assertEquals(listaEsperada, fibonacci.getSucesion());
        Assert.assertEquals(sumatoriaEsperada, fibonacci.getSumatoria());
    }
}
