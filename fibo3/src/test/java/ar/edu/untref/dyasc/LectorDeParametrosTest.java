package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.excepciones.OpcionesNoValidasException;

public class LectorDeParametrosTest {

    @Test
    public void creaLectorDeParametros() throws OpcionesNoValidasException {
        String[] parametros = { "5" };
        new LectorDeParametros(parametros);
    }

    @Test
    public void creaLectorConOpcionVerticalYAlDerecho() throws OpcionesNoValidasException {
        String[] parametros = { "-o=vd", "5" };
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(true, debeIrAlDerecho);
        Assert.assertEquals(false, esHorizontal);
    }

    @Test
    public void creaLectorConOpcionHorizontalYAlDerecho() throws OpcionesNoValidasException {
        String[] parametros = { "-o=hd", "2" };
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(true, debeIrAlDerecho);
        Assert.assertEquals(true, esHorizontal);
    }

    @Test
    public void creaLectorConOpcionVerticalEInverso() throws OpcionesNoValidasException {
        String[] parametros = { "-o=vi", "5" };
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(false, debeIrAlDerecho);
        Assert.assertEquals(false, esHorizontal);
    }

    @Test
    public void creaLectorConOpcionHorizontalEInverso() throws OpcionesNoValidasException {
        String[] parametros = { "-o=hi", "5" };
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(false, debeIrAlDerecho);
        Assert.assertEquals(true, esHorizontal);
    }

    @Test
    public void creaLectorConOpcionHorizontalEInversoEnDistintoOrden() throws OpcionesNoValidasException {
        String[] parametros = { "8", "-o=hi" };
        LectorDeParametros lector = new LectorDeParametros(parametros);

        boolean debeIrAlDerecho = lector.debeIrAlDerecho();
        boolean esHorizontal = lector.debeSerHorizontal();

        Assert.assertEquals(false, debeIrAlDerecho);
        Assert.assertEquals(true, esHorizontal);
    }

    @Test(expected = OpcionesNoValidasException.class)
    public void creaLectorConOpcionInvalidaYArrojaExcepcion() throws OpcionesNoValidasException {
        String[] parametros = { "8", "-o=xy" };
        new LectorDeParametros(parametros);

    }
}
