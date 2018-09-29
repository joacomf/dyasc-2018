package ar.edu.untref.dyasc;

import java.io.*;

public class ImpresoraDeArchivo extends Impresora{

    private static Impresora instanciaDeImpresora = new ImpresoraDeArchivo();
    private static String archivoDestino;

    private ImpresoraDeArchivo(){}

    static Impresora getInstance(String destino) {
        ImpresoraDeArchivo.archivoDestino = destino;
        return instanciaDeImpresora;
    }

    public void imprimir(String texto) {
        File archivo = new File(archivoDestino);

        try {
            Writer escritor = new FileWriter(archivo, true);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.append(texto);
            buffer.append("\n");
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
