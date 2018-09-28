package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

import ar.edu.untref.dyasc.interfaces.FibonacciInterface;

public class Fibonacci implements FibonacciInterface{

    List<Long> sucesion;
    private long sumatoria;
    private int N;

    public Fibonacci() {
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

    public void setSumatoria(long sumatoria) {
        this.sumatoria = sumatoria;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        this.N = n;
    }

}