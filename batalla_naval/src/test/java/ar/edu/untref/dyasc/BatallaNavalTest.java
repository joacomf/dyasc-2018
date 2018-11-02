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

        batallaNaval.agregarBote(bote1, 2, 2);
        batallaNaval.agregarBote(bote2, 3, 3);

        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(2, barcosEnJuego);
    }

    @Test
    public void ubicarCruceroConDireccionHorizontal(){
        BatallaNaval batallaNaval = new BatallaNaval(3, 3);
        Crucero crucero = new Crucero(true);

        batallaNaval.agregarCrucero(crucero, 1, 3);
        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(1, barcosEnJuego);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void intentaUbicarCruceroEnPosicion5y5EnUnMapaDe3por3YRecibeExcepcion(){
        BatallaNaval batallaNaval = new BatallaNaval(3, 3);
        Crucero crucero = new Crucero(true);

        batallaNaval.agregarCrucero(crucero, 5, 5);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void intentaUbicarBoteEnPosicion3y3EnUnMapaDe2por3YRecibeExcepcion(){
        BatallaNaval batallaNaval = new BatallaNaval(2, 2);
        Bote bote = new Bote();

        batallaNaval.agregarBote(bote, 3, 3);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void intentaUbicarCruceroEnPosicion3y1EnUnMapaDe4por3EnPosicionHorizontalYRecibeExcepcion(){
        BatallaNaval batallaNaval = new BatallaNaval(4, 3);
        Crucero crucero = new Crucero(true);

        batallaNaval.agregarCrucero(crucero, 3, 1);
    }

    @Test
    public void ubicaCruceroEnPosicion3y1EnUnMapaDe4por3EnPosicionVertical(){
        BatallaNaval batallaNaval = new BatallaNaval(4, 3);
        Crucero crucero = new Crucero(false);

        batallaNaval.agregarCrucero(crucero, 3, 1);

        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(1, barcosEnJuego);
    }

    @Test(expected = PosicionNoPermitidaException.class)
    public void intentaUbicarCruceroEnPosicion1y3EnUnMapaDe4por3EnPosicionVerticalYRecibeExcepcion(){
        BatallaNaval batallaNaval = new BatallaNaval(4, 3);
        Crucero crucero = new Crucero(false);

        batallaNaval.agregarCrucero(crucero, 1, 3);
    }

    @Test
    public void dispararAlTableroEnUnLugarSinBarco() {
        BatallaNaval batallaNaval = new BatallaNaval(4, 3);

        Resultado resultado = batallaNaval.disparar(1, 1);

        Assert.assertEquals(Resultado.AGUA, resultado);
    }

    @Test
    public void disparaAlTableroYTocaUnBarco(){
        BatallaNaval batallaNaval = new BatallaNaval(4, 4);

        batallaNaval.agregarCrucero(new Crucero(true), 2, 2);

        Resultado resultado = batallaNaval.disparar(2, 2);

        Assert.assertEquals(Resultado.TOCADO, resultado);
    }
}
