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

    Resultado disparar(int x, int y) {

        Resultado resultado = null;
        Barco barco = this.tablero.obtener(x, y);

        if (barco != null){
            resultado = Resultado.TOCADO;
        }else{
            resultado = Resultado.AGUA;
        }

        return resultado;
    }
}
