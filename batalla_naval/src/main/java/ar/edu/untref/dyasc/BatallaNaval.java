package ar.edu.untref.dyasc;

class BatallaNaval {

    private int barcos = 0;
    private int dimensionHorizontal;
    private int dimensionVertical;

    BatallaNaval(int dimensionHorizontal, int dimensionVertical) {
        this.dimensionHorizontal = dimensionHorizontal;
        this.dimensionVertical = dimensionVertical;
    }

    int barcosEnJuego() {
        return this.barcos;
    }

    void añadirBote(Bote bote, int x, int y) {
        this.barcos++;
        this.colocarBarcoEnTablero(bote, x, y);
    }

    void añadirCrucero(Crucero crucero, int x, int y) {
        this.barcos++;
        this.colocarBarcoEnTablero(crucero, x, y);
    }

    private void colocarBarcoEnTablero(Barco barco, int x, int y) {
        if (
                ((x > this.dimensionHorizontal) || (y > this.dimensionVertical)) ||
                (barco.estaHorizontal() && ((x + barco.obtenerDimension() - 1) > this.dimensionHorizontal)) ||
                (!barco.estaHorizontal() && ((y + barco.obtenerDimension() - 1) > this.dimensionVertical))
           )
        {
            throw new PosicionNoPermitidaException();
        }
    }
}
