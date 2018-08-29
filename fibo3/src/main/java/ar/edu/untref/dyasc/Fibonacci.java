package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    List<Long> sucesion;
    private long sumatoria;
    private int dimension;

    public Fibonacci() {
        this.sucesion = new ArrayList<>();
    }

    public void generarSucesion(int n) {

        this.setSumatoria(0);
        this.setDimension(n);

        long anterior = 0;
        long actual = 1;
        long proximo;

        for (int k = 1; k <= n; ++k) {

            sucesion.add(anterior);
            this.setSumatoria(this.getSumatoria() + anterior);

            proximo = anterior + actual;
            anterior = actual;
            actual = proximo;
        }

    }

    public List<Long> getSucesion() {
        return sucesion;
    }

    public Long getSumatoria() {
        return this.sumatoria;
    }

    public void setSumatoria(long sumatoria) {
        this.sumatoria = sumatoria;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

}