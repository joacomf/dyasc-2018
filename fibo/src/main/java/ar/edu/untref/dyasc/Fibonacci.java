package ar.edu.untref.dyasc;

import java.util.LinkedList;
import java.util.List;

public class Fibonacci {

    List<Integer> sucesion;

    public Fibonacci() {
        this.sucesion = new LinkedList<>();
    }

    public void generarSucesion(int n) {

        int anterior = 0, actual = 1, proximo;

        for (int k = 1; k <= n; ++k){

            sucesion.add(anterior);

            proximo = anterior + actual;
            anterior = actual;
            actual = proximo;
        }

    }

    public List<Integer> getSucesion() {
        return sucesion;
    }

}