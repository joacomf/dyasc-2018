package ar.edu.untref.dyasc.impresion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AdministradorDeImpresoras implements Imprimible{

    private List<Imprimible> impresoras = new LinkedList<>();

    public AdministradorDeImpresoras(String textoDeOpciones){
        if (textoDeOpciones == null) throw new OpcionInvalidaException("No se definió la variable bitacora.destino");

        String[] opciones = textoDeOpciones.split(",");

        if (opciones.length == 0) throw new OpcionInvalidaException("No hay opciones disponibles para generar el Log");

        Arrays.asList(opciones).forEach(this::crearPorTipo);
    }

    private void crearPorTipo(String opcion) {
        Imprimible impresora;

        if (opcion.equals("")) throw new OpcionInvalidaException("Hay una opción vacía");

        if (!opcion.equals("CONSOLA")) {
            impresora = new ImpresoraDeArchivo(opcion);
        } else {
            impresora = new ImpresoraDeConsola();
        }

        this.impresoras.add(impresora);
    }

    @Override
    public void imprimir(String texto) {
        impresoras.forEach(impresora -> impresora.imprimir(texto));
    }
}
