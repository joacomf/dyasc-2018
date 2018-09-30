package ar.edu.untref.dyasc.impresion;

import java.io.*;

public class ImpresoraDeArchivo implements Imprimible {

    private String archivoDestino;

    ImpresoraDeArchivo(String archivo){
        this.archivoDestino = archivo;
    }

    public void imprimir(String texto) {
        File archivo = new File(this.archivoDestino);

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
