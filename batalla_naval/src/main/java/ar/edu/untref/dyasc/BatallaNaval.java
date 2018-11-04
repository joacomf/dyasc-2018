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

    void agregarBote(Bote bote, int x, int y) {
        this.barcos++;
        this.tablero.colocar(bote, x, y);
    }

    void agregarCrucero(Crucero crucero, int x, int y) {
        this.barcos++;

        if (crucero.estaHorizontal()){
            for (int i = x; i < crucero.obtenerDimension() + x; i++) {
                this.tablero.colocar(crucero, i, y);
            }
        }else{
            for (int i = y; i < crucero.obtenerDimension() + y; i++) {
                this.tablero.colocar(crucero, x, i);
            }
        }
    }

    Resultado disparar(int x, int y) {

        Resultado resultado = Resultado.AGUA;
        Barco barco = this.tablero.obtener(x, y);

        if (barco != null){
            resultado = barco.restarVida();
        }

        return resultado;
    }
}
