package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    List<Long> sucesion;

    public Fibonacci() {
        this.sucesion = new ArrayList<>();
    }

    public void generarSucesion(int n) {

        long anterior = 0;
        long actual = 1;
        long proximo;

        for (int k = 1; k <= n; ++k){

            sucesion.add(anterior);

            proximo = anterior + actual;
            anterior = actual;
            actual = proximo;
        }

    }

    public List<Long> getSucesion() {
        return sucesion;
    }

}