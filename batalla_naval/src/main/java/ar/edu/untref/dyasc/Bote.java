package ar.edu.untref.dyasc;

class Bote implements Barco {

    private int dimension = 0;
    private boolean estaHorizontal = true;

    @Override
    public int obtenerDimension() {
        return dimension;
    }

    @Override
    public boolean estaHorizontal() {
        return this.estaHorizontal;
    }

    @Override
    public Resultado restarVida() {
        return Resultado.HUNDIDO;
    }
}
