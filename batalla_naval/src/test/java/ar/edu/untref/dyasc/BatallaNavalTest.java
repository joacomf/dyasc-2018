package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class BatallaNavalTest {

    @Test
    public void iniciaBatallaNavalConTableroVacio(){
        BatallaNaval batallaNaval = new BatallaNaval();

        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(0, barcosEnJuego);
    }

    @Test
    public void iniciarJuegoCon2Botes(){
        BatallaNaval batallaNaval = new BatallaNaval();
        Bote bote1 = new Bote();
        Bote bote2 = new Bote();

        batallaNaval.añadirBote(bote1, 2, 2);
        batallaNaval.añadirBote(bote2, 3, 3);

        int barcosEnJuego = batallaNaval.barcosEnJuego();

        Assert.assertEquals(2, barcosEnJuego);
    }
}
