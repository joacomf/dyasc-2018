package ar.edu.untref.dyasc;

class BatallaNaval {

    private Tablero tablero;
    private int barcos = 0;

    BatallaNaval(int dimensionHorizontal, int dimensionVertical) {
        this.tablero = new Tablero(dimensionHorizontal, dimensionVertical);
    }

    int barcosEnJuego() {
        return this.barcos;
    }

    void añadirBote(Bote bote, int x, int y) {
        this.barcos++;
        this.tablero.colocar(bote, x, y);
    }

    void añadirCrucero(Crucero crucero, int x, int y) {
        this.barcos++;
        this.tablero.colocar(crucero, x, y);
    }

    public Resultado disparar(int x, int y) {
        return Resultado.AGUA;
    }
}
