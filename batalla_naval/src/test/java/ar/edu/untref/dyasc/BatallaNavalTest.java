package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class BatallaNavalTest {

    @Test
    public void iniciaBatallaNavalConTableroVacio(){
        BatallaNaval batallaNaval = new BatallaNaval(1, 1);

        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(0, barcosEnJuego);
    }

    @Test
    public void iniciarJuegoCon2Botes(){
        BatallaNaval batallaNaval = new BatallaNaval(3, 3);
        Bote bote1 = new Bote();
        Bote bote2 = new Bote();

        batallaNaval.añadirBote(bote1, 2, 2);
        batallaNaval.añadirBote(bote2, 3, 3);

        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(2, barcosEnJuego);
    }

    @Test
    public void ubicarCruceroConDireccionHorizontal(){
        BatallaNaval batallaNaval = new BatallaNaval(3, 3);
        Crucero crucero = new Crucero(true);

        batallaNaval.añadirCrucero(crucero, 1, 3);
        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(1, barcosEnJuego);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void intentaUbicarCruceroEnPosicion5y5EnUnMapaDe3por3YRecibeExcepcion(){
        BatallaNaval batallaNaval = new BatallaNaval(3, 3);
        Crucero crucero = new Crucero(true);

        batallaNaval.añadirCrucero(crucero, 5, 5);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void intentaUbicarBoteEnPosicion3y3EnUnMapaDe2por3YRecibeExcepcion(){
        BatallaNaval batallaNaval = new BatallaNaval(2, 2);
        Bote bote = new Bote();

        batallaNaval.añadirBote(bote, 3, 3);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void intentaUbicarCruceroEnPosicion3y1EnUnMapaDe4por3EnPosicionHorizontalYRecibeExcepcion(){
        BatallaNaval batallaNaval = new BatallaNaval(4, 3);
        Crucero crucero = new Crucero(true);

        batallaNaval.añadirCrucero(crucero, 3, 1);
    }

    @Test
    public void ubicaCruceroEnPosicion3y1EnUnMapaDe4por3EnPosicionVertical(){
        BatallaNaval batallaNaval = new BatallaNaval(4, 3);
        Crucero crucero = new Crucero(false);

        batallaNaval.añadirCrucero(crucero, 3, 1);

        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(1, barcosEnJuego);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void intentaUbicarCruceroEnPosicion1y3EnUnMapaDe4por3EnPosicionVerticalYRecibeExcepcion(){
        BatallaNaval batallaNaval = new BatallaNaval(4, 3);
        Crucero crucero = new Crucero(false);

        batallaNaval.añadirCrucero(crucero, 1, 3);
    }

    @Test
    public void dispararAlTableroEnUnLugarSinBarco() {
        BatallaNaval batallaNaval = new BatallaNaval(4, 3);

        Resultado resultado = batallaNaval.disparar(1, 1);

        Assert.assertEquals(Resultado.AGUA, resultado);
    }
}
