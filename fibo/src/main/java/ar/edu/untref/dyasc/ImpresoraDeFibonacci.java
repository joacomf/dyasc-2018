package ar.edu.untref.dyasc;

import java.util.Iterator;
import java.util.List;

public class ImpresoraDeFibonacci {

    private static final String SEPARADOR = " ";
    private List<Long> listado;
    private String cabecera = "";

    public ImpresoraDeFibonacci(Fibonacci fibonacci) {
        this.setListado(fibonacci.getSucesion());
        this.generarCabecera();
    }

    private void generarCabecera() {
        this.cabecera = "fibo<".concat(String.valueOf(listado.size())).concat(">:");
    }

    public String imprimir() {
        StringBuilder constructorDeString = new StringBuilder();
        constructorDeString.append(this.cabecera);

        for (Iterator<Long> iterator = listado.iterator(); iterator.hasNext();) {
            Long numeroEnLaSucesion = iterator.next();

            constructorDeString.append(SEPARADOR);
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
