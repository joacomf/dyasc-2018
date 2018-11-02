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
    }

    void añadirCrucero(Crucero crucero, int x, int y) {
        this.barcos++;

        this.colocarBarcoEnMapa(x, y);
    }

    private void colocarBarcoEnMapa(int x, int y) {
        if (x > this.dimensionHorizontal || y > this.dimensionVertical){
            throw new PosicionNoPermitidaException();
        }
    }
}
