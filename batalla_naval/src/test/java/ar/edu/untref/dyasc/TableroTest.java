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

}