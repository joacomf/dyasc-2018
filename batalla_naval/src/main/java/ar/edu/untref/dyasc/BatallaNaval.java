package ar.edu.untref.dyasc;

class BatallaNaval {

    private int barcos = 0;

    public BatallaNaval(int dimensionHorizontal, int dimensionVertical) {
    }

    int barcosEnJuego() {
        return this.barcos;
    }

    void añadirBote(Bote bote1, int x, int y) {
        this.barcos++;
    }

    void añadirCrucero(Crucero crucero, int x, int y) {
        this.barcos++;
    }
}
