package ar.edu.untref.dyasc;

class BatallaNaval {

    private int barcos = 0;

    int barcosEnJuego() {
        return this.barcos;
    }

    public void añadirBote(Bote bote1, int x, int y) {
        this.barcos++;
    }
}
