package ar.edu.untref.dyasc;

import java.util.Arrays;

import ar.edu.untref.dyasc.excepciones.OpcionesNoValidasException;

class LectorDeParametros {

    private int iteraciones;
    private boolean debeIrAlDerecho = true;
    private boolean debeSerHorizontal = true;
    private boolean debeSerSumatoria = false;
    private boolean debeGuardarEnArchivo = false;
    private String nombreDeArchivo = "";

    LectorDeParametros(String[] parametros) throws OpcionesNoValidasException {
        analizar(parametros);
    }

    private void analizar(String[] parametros) throws OpcionesNoValidasException {
        for (String parametro : parametros) {
            this.evaluarOpciones(parametro);
        }
    }

    private void evaluarOpciones(String opcion) throws OpcionesNoValidasException {

        if (opcion.startsWith("-") && opcion.contains("=")) {

            String valorDeOpcion = opcion.split("=")[1];
            char charOpcion = opcion.charAt(1);

            if ( charOpcion == 'o') {
                this.evaluarOpcionDeImpresion(valorDeOpcion);
            } else if (charOpcion == 'f') {
                this.evaluarSalidaEnArchivo(valorDeOpcion);
            } else if (charOpcion == 'm') {
                this.evaluarSiEsSumatoria(valorDeOpcion);
            }
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

    boolean debeIrAlDerecho() {
        return debeIrAlDerecho;
    }

    boolean debeSerHorizontal() {
        return debeSerHorizontal;
    }

    int getIteraciones() {
        return iteraciones;
    }

    private void setIteraciones(int iteraciones) {
        this.iteraciones = iteraciones;
    }

    boolean debeGuardarEnArchivo() {
        return debeGuardarEnArchivo;
    }

    private void setDebeGuardarEnArchivo(boolean debeGuardarEnArchivo) {
        this.debeGuardarEnArchivo = debeGuardarEnArchivo;
    }

    String getNombreDeArchivo() {
        return nombreDeArchivo;
    }

    private void setNombreDeArchivo(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    boolean debeSerSumatoria() {
        return this.debeSerSumatoria;
    }

    private void setDebeSerSumatoria(boolean debeSerSumatoria) {
        this.debeSerSumatoria = debeSerSumatoria;
    }

}
