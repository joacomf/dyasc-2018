package ar.edu.untref.dyasc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AdministradorDeImpresoras implements Imprimible{

    private List<Imprimible> impresoras = new LinkedList<>();

    AdministradorDeImpresoras(String textoDeOpciones){
        String[] opciones = textoDeOpciones.split(",");

        Arrays.asList(opciones).forEach(this::crearPorTipo);
    }

    private void crearPorTipo(String opcion) {
        System.out.println(opcion);
        Imprimible impresora;

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
