package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import ar.edu.untref.dyasc.interfaces.Fibonacci;

public class ImpresoraDeFibonacci {

    private String separador = " ";
    private List<Long> listado;
    private String cabecera = "";
    private String caracterSecuencial = "";
    private int dimension;

    public ImpresoraDeFibonacci(Fibonacci fibonacci) {
        inicializar(fibonacci);
    }

    public ImpresoraDeFibonacci(Fibonacci fibonacci, boolean esHorizontal, boolean estaAlDerecho) {
        this(fibonacci);

        if (!esHorizontal) {
            this.separador = "\n";
        }

        if (!estaAlDerecho) {
            Collections.reverse(this.getListado());
        }
    }

    public ImpresoraDeFibonacci(Fibonacci fibonacci, boolean esHorizontal, boolean estaAlDerecho, boolean esSumatoria) {
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

    public String imprimir() {
        this.generarCabecera();
        StringBuilder constructorDeString = new StringBuilder();
        constructorDeString.append(this.cabecera);

        for (Iterator<Long> iterator = listado.iterator(); iterator.hasNext();) {
            Long numeroEnLaSucesion = iterator.next();

            constructorDeString.append(separador);
            constructorDeString.append(numeroEnLaSucesion);
        }

        return constructorDeString.toString();
    }

    public List<Long> getListado() {
        return listado;
    }

    private void setListado(List<Long> listado) {
        this.listado = listado;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

}
