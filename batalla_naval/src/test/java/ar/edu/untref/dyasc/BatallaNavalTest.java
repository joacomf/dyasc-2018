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

        batallaNaval.añadirCrucero(crucero, 3, 3);
        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(1, barcosEnJuego);
    }

    @Test
    public void intentaUbicarCruceroEnUnMapaDe2por2(){
        BatallaNaval batallaNaval = new BatallaNaval(2, 2);
        Crucero crucero = new Crucero(true);

        batallaNaval.añadirCrucero(crucero, 3, 3);
        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(1, barcosEnJuego);
    }
}
