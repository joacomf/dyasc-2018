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
        if (estaFuera(x, y) || sobrepasaLimiteHorizontal(barco, x) || sobrePasaLimiteVertical(barco, y)) {
            throw new PosicionNoPermitidaException();
        }
    }

    private boolean sobrePasaLimiteVertical(Barco barco, int y) {
        return !barco.estaHorizontal() && ((y + barco.obtenerDimension() - 1) > this.dimensionVertical);
    }

    private boolean sobrepasaLimiteHorizontal(Barco barco, int x) {
        return barco.estaHorizontal() && ((x + barco.obtenerDimension() - 1) > this.dimensionHorizontal);
    }

    private boolean estaFuera(int x, int y) {
        return (x > this.dimensionHorizontal) || (y > this.dimensionVertical);
    }

    Barco obtener(int x, int y) {
        return this.casillas[x - 1][y - 1];
    }
}
