package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

import ar.edu.untref.dyasc.interfaces.Fibonacci;

public class FibonacciSucesion implements Fibonacci {

    private List<Long> sucesion;
    private long sumatoria;
    private int N;

    FibonacciSucesion() {
        this.sucesion = new ArrayList<>();
    }

    public void generarSucesion(int n) {

        this.setSumatoria(0);
        this.setN(n);

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

    private void setSumatoria(long sumatoria) {
        this.sumatoria = sumatoria;
    }

    public int getN() {
        return N;
    }

    private void setN(int n) {
        this.N = n;
    }

}