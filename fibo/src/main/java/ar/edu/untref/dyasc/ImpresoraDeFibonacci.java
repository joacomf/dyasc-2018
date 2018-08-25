package ar.edu.untref.dyasc;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ImpresoraDeFibonacci {

    private String separador = " ";
    private List<Long> listado;
    private String cabecera = "";

    public ImpresoraDeFibonacci(Fibonacci fibonacci) {
        this.setListado(fibonacci.getSucesion());
        this.generarCabecera();
    }

    public ImpresoraDeFibonacci(Fibonacci fibonacci, boolean esHorizontal, boolean estaAlDerecho) {
        this.setListado(fibonacci.getSucesion());
        this.generarCabecera();

        if (!esHorizontal) {
            this.separador = "\n";
        }

        if (!estaAlDerecho) {
            Collections.reverse(this.getListado());
        }
    }

    private void generarCabecera() {
        this.cabecera = "fibo<".concat(String.valueOf(listado.size())).concat(">:");
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

}
