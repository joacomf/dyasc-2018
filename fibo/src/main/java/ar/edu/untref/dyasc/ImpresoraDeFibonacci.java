package ar.edu.untref.dyasc;

import java.util.Iterator;
import java.util.List;

public class ImpresoraDeFibonacci {

    private static final String SEPARADOR = " ";
    private List<Integer> listado;

    public ImpresoraDeFibonacci(List<Integer> listado) {
        this.setListado(listado);
    }

    public String imprimir() {
        StringBuilder constructorDeString = new StringBuilder();
        

        for (Iterator<Integer> iterator = listado.iterator(); iterator.hasNext();) {
            Integer numeroEnLaSucesion = (Integer) iterator.next();

            constructorDeString.append(SEPARADOR);
            constructorDeString.append(numeroEnLaSucesion);
        }
        
        return constructorDeString.toString();
    }

    public List<Integer> getListado() {
        return listado;
    }

    private void setListado(List<Integer> listado) {
        this.listado = listado;
    }

}
