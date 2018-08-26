package ar.edu.untref.dyasc;

import java.util.Arrays;

import ar.edu.untref.dyasc.excepciones.OpcionesNoValidasException;

public class LectorDeParametros {

    private int iteraciones;
    private boolean debeIrAlDerecho = true;
    private boolean debeSerHorizontal = true;

    public LectorDeParametros(String[] parametros) throws OpcionesNoValidasException {
        for (int i = 0; i < parametros.length; i++) {
            this.evaluarOpciones(parametros[i]);
        }
    }

    private void evaluarOpciones(String opcion) throws OpcionesNoValidasException {

        if (opcion.startsWith("-o=")) {
            String[] opcionClaveValor = opcion.split("=");
            String valorDeOpcion = opcionClaveValor[1];
            
            this.evaluarOpcionDeImpresion(valorDeOpcion);
        } else {
            this.setIteraciones(Integer.valueOf(opcion));
        }
    }

    private void evaluarOpcionDeImpresion(String valorDeLaOpcion) throws OpcionesNoValidasException {
        String[] opcionesValidas = {"hd", "vd", "hi", "vi"};
        
        if(!Arrays.asList(opcionesValidas).contains(valorDeLaOpcion)) {
            throw new OpcionesNoValidasException();
        }

        this.debeIrAlDerecho = valorDeLaOpcion.contains("d");
        this.debeSerHorizontal = valorDeLaOpcion.contains("h");
    }

    public boolean debeIrAlDerecho() {
        return debeIrAlDerecho;
    }
    
    public boolean debeSerHorizontal() {
        return debeSerHorizontal;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public void setIteraciones(int iteraciones) {
        this.iteraciones = iteraciones;
    }

}
