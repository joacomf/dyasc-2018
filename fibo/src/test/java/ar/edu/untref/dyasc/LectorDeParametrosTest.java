package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class LectorDeParametrosTest {

    @Test
    public void creaLectorDeParametros() {
        String[] parametros = {"5"};
        new LectorDeParametros(parametros);
    }
    
    @Test
    public void creaLectorConOpcionVerticalYAlDerecho() {
        String[] parametros = {"-o=vd", "5"};
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(true, debeIrAlDerecho);
        Assert.assertEquals(false, esHorizontal);
    }

    @Test
    public void creaLectorConOpcionHorizontalYAlDerecho() {
        String[] parametros = {"-o=hd", "2"};
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(true, debeIrAlDerecho);
        Assert.assertEquals(true, esHorizontal);
    }

    @Test
    public void creaLectorConOpcionVerticalEInverso() {
        String[] parametros = {"-o=vi", "5"};
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(false, debeIrAlDerecho);
        Assert.assertEquals(false, esHorizontal);
    }

    @Test
    public void creaLectorConOpcionHorizontalEInverso() {
        String[] parametros = {"-o=hi", "5"};
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(false, debeIrAlDerecho);
        Assert.assertEquals(true, esHorizontal);
    }

    @Test
    public void creaLectorConOpcionHorizontalEInversoEnDistintoOrden() {
        String[] parametros = {"8", "-o=hi"};
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(false, debeIrAlDerecho);
        Assert.assertEquals(true, esHorizontal);
    }
}
