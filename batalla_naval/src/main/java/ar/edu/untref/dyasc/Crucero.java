package ar.edu.untref.dyasc;

class Crucero implements Barco {

    private boolean estaHorizontal;
    private int dimension = 3;
    private int vidasRestantes = 2;

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

    @Override
    public Resultado restarVida() {
        boolean seHundio = this.vidasRestantes-- == 0;

        Resultado resultado = Resultado.TOCADO;
        if (seHundio){
            resultado = Resultado.HUNDIDO;
        }

        return resultado;
    }
}
