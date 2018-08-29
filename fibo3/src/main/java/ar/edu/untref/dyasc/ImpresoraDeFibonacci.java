package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ImpresoraDeFibonacci {

    private String separador = " ";
    private List<Long> listado;
    private String cabecera = "";
    private String caracterSecuencial = "";
    private int dimension;

    public ImpresoraDeFibonacci(Fibonacci fibonacci) {
        this.setListado(fibonacci.getSucesion());
        this.setDimension(fibonacci.getDimension());
        this.generarCabecera();
    }

    public ImpresoraDeFibonacci(Fibonacci fibonacci, boolean esHorizontal, boolean estaAlDerecho) {
        this.setListado(fibonacci.getSucesion());
        this.setDimension(fibonacci.getDimension());
        this.generarCabecera();

        if (!esHorizontal) {
            this.separador = "\n";
        }

        if (!estaAlDerecho) {
            Collections.reverse(this.getListado());
        }
    }

    public ImpresoraDeFibonacci(Fibonacci fibonacci, boolean esHorizontal, boolean estaAlDerecho, boolean esSumatoria) {
        this.caracterSecuencial = "s";
        List<Long> listado = new ArrayList<>();
        listado.add(fibonacci.getSumatoria());

        this.setListado(listado);
        this.setDimension(fibonacci.getDimension());
        this.generarCabecera();
    }

    private void generarCabecera() {
        this.cabecera = "fibo<".concat(String.valueOf(this.dimension)).concat(">");
        this.cabecera = this.cabecera.concat(this.caracterSecuencial );
        this.cabecera = this.cabecera.concat(":");
    }

    public String imprimir() {
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

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

}
