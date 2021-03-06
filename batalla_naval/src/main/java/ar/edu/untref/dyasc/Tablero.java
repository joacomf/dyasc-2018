package ar.edu.untref.dyasc;

class Tablero {

    private final int dimensionHorizontal;
    private final int dimensionVertical;
    private Barco[][] casillas;

    Tablero(int dimensionHorizontal, int dimensionVertical) {
        this.dimensionHorizontal = dimensionHorizontal;
        this.dimensionVertical = dimensionVertical;

        casillas = new Barco[dimensionHorizontal][dimensionVertical];
    }

    void colocar(Barco barco, int x, int y) {
        verificarPosicionCorrecta(barco, x, y);

        this.casillas[x - 1][y - 1] = barco;
    }

    private void verificarPosicionCorrecta(Barco barco, int x, int y) {
        if (estaFuera(x, y) || estaOcupado(x, y)) {
            throw new PosicionNoPermitidaException();
        }
    }

    private boolean estaOcupado(int x, int y) {
        return this.obtener(x, y) != null;
    }

    private boolean estaFuera(int x, int y) {
        return (x <= 0) || (y <= 0) || (x > this.dimensionHorizontal) || (y > this.dimensionVertical);
    }

    Barco obtener(int x, int y) {
        return this.casillas[x - 1][y - 1];
    }

    void quitar(int x, int y) {
        this.casillas[x - 1][y - 1] = null;
    }
}
