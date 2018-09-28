package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.interfaces.Fibonacci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ImpresoraDeFibonacci {

    private String separador = " ";
    private List<Long> listado;
    private String cabecera = "";
    private String caracterSecuencial = "";
    private int dimension;

    ImpresoraDeFibonacci(Fibonacci fibonacci) {
        inicializar(fibonacci);
    }

    ImpresoraDeFibonacci(Fibonacci fibonacci, boolean esHorizontal, boolean estaAlDerecho) {
        this(fibonacci);

        if (!esHorizontal) {
            this.separador = "\n";
        }

        if (!estaAlDerecho) {
            Collections.reverse(this.getListado());
        }
    }

    ImpresoraDeFibonacci(Fibonacci fibonacci, boolean esHorizontal, boolean estaAlDerecho, boolean esSumatoria) {
        this(fibonacci, esHorizontal, estaAlDerecho);

        if(esSumatoria) {
            List<Long> listadoDeSucesion = new ArrayList<>();
            listadoDeSucesion.add(fibonacci.getSumatoria());
            this.caracterSecuencial = "s";
            this.setListado(listadoDeSucesion);
        }
    }

    private void inicializar(Fibonacci fibonacci) {
        this.setListado(fibonacci.getSucesion());
        this.setDimension(fibonacci.getN());
    }

    private void generarCabecera() {
        this.cabecera = "fibo<".concat(String.valueOf(this.dimension)).concat(">");
        this.cabecera = this.cabecera.concat(this.caracterSecuencial );
        this.cabecera = this.cabecera.concat(":");
    }

    String imprimir() {
        this.generarCabecera();
        StringBuilder constructorDeString = new StringBuilder();
        constructorDeString.append(this.cabecera);

        for (Long numeroEnLaSucesion : listado) {
            constructorDeString.append(separador);
            constructorDeString.append(numeroEnLaSucesion);
        }

        return constructorDeString.toString();
    }

    private List<Long> getListado() {
        return listado;
    }

    private void setListado(List<Long> listado) {
        this.listado = listado;
    }

    private void setDimension(int dimension) {
        this.dimension = dimension;
    }

}
