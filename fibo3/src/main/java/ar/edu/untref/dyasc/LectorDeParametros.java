package ar.edu.untref.dyasc;

import java.util.Arrays;

import ar.edu.untref.dyasc.excepciones.OpcionesNoValidasException;

public class LectorDeParametros {

    private int iteraciones;
    private boolean debeIrAlDerecho = true;
    private boolean debeSerHorizontal = true;
    private boolean debeSerSumatoria = false;
    private boolean debeGuardarEnArchivo = false;
    private String nombreDeArchivo = "";

    public LectorDeParametros(String[] parametros) throws OpcionesNoValidasException {
        analizar(parametros);
    }

    private void analizar(String[] parametros) throws OpcionesNoValidasException {
        for (String parametro : parametros) {
            this.evaluarOpciones(parametro);
        }
    }

    private void evaluarOpciones(String opcion) throws OpcionesNoValidasException {

        if (opcion.startsWith("-o=")) {
            String[] opcionClaveValor = opcion.split("=");
            String valorDeOpcion = opcionClaveValor[1];

            this.evaluarOpcionDeImpresion(valorDeOpcion);
        } else if (opcion.startsWith("-f=")) {
            String[] opcionClaveValor = opcion.split("=");
            String valorDeOpcion = opcionClaveValor[1];

            this.evaluarSalidaEnArchivo(valorDeOpcion);
        } else if (opcion.startsWith("-m=")) {
            String[] opcionClaveValor = opcion.split("=");
            String valorDeOpcion = opcionClaveValor[1];

            this.evaluarSiEsSumatoria(valorDeOpcion);
        } else {
            this.setIteraciones(Integer.valueOf(opcion));
        }
    }

    private void evaluarSiEsSumatoria(String valorDeOpcion) {
        this.setDebeSerSumatoria(valorDeOpcion.equals("s"));
    }

    private void evaluarSalidaEnArchivo(String valorDeOpcion) {
        this.setDebeGuardarEnArchivo(true);
        this.setNombreDeArchivo(valorDeOpcion);
    }

    private void evaluarOpcionDeImpresion(String valorDeLaOpcion) throws OpcionesNoValidasException {
        String[] opcionesValidas = { "hd", "vd", "hi", "vi" };

        if (!Arrays.asList(opcionesValidas).contains(valorDeLaOpcion)) {
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

    public boolean debeGuardarEnArchivo() {
        return debeGuardarEnArchivo;
    }

    public void setDebeGuardarEnArchivo(boolean debeGuardarEnArchivo) {
        this.debeGuardarEnArchivo = debeGuardarEnArchivo;
    }

    public String getNombreDeArchivo() {
        return nombreDeArchivo;
    }

    public void setNombreDeArchivo(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    public boolean debeSerSumatoria() {
        return this.debeSerSumatoria;
    }

    public void setDebeSerSumatoria(boolean debeSerSumatoria) {
        this.debeSerSumatoria = debeSerSumatoria;
    }

}
