package ar.edu.untref.dyasc;

class Bote implements Barco {
    @Override
    public int obtenerDimension() {
        return 0;
    }

    @Override
    public boolean estaHorizontal() {
        return true;
    }
}
