package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void tableroDe5por5PermiteColocarBoteEnPosicion1y1(){

        Bote bote = new Bote();
        Tablero tablero = new Tablero(5, 5);

        tablero.colocar(bote, 1, 1);

        Barco boteEnTablero = tablero.obtener(1, 1);

        Assert.assertEquals(bote, boteEnTablero);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void tableroDe5por5NoPermiteColocarBoteEnPosicion0y0(){

        Bote bote = new Bote();
        Tablero tablero = new Tablero(5, 5);

        tablero.colocar(bote, 0, 0);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void tableroDe5por5NoPermiteColocarBoteEnPosicionesNegativa(){

        Bote bote = new Bote();
        Tablero tablero = new Tablero(5, 5);

        tablero.colocar(bote, -1, -2);
    }

    @Test
    public void tableroDe5por5PermiteInsertarBoteEnPosicionVertical3yOtroBoteEnPosicionVertical4(){

        Barco bote1 = new Bote();
        Barco bote2 = new Bote();
        Tablero tablero = new Tablero(5, 5);

        tablero.colocar(bote1, 1, 1);
        tablero.colocar(bote2, 1, 2);

        Barco bote1EnTablero = tablero.obtener(1, 1);
        Barco bote2EnTablero = tablero.obtener(1, 2);

        Assert.assertEquals(bote1, bote1EnTablero);
        Assert.assertEquals(bote2, bote2EnTablero);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void intentaColocarDosBotesEnElMismoCasilleroYSeRecibeExcepcion(){

        Barco bote1 = new Bote();
        Barco bote2 = new Bote();
        Tablero tablero = new Tablero(5, 5);

        tablero.colocar(bote1, 1, 1);
        tablero.colocar(bote2, 1, 1);
    }
}