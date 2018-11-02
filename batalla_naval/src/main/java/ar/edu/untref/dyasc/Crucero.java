package ar.edu.untref.dyasc;

class Crucero implements Barco {

    private boolean estaHorizontal;
    private int dimension = 3;

    Crucero(boolean estaEnDireccionHorizontal) {
        this.estaHorizontal = estaEnDireccionHorizontal;
    }

    @Override
    public int obtenerDimension() {
        return this.dimension;
    }

    @Override
    public boolean estaHorizontal() {
        return this.estaHorizontal;
    }
}
