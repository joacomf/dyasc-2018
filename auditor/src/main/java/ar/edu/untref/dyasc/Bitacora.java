package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bitacora {

    public static void registrar(String mensaje) {
        LocalDateTime fechaDelInstante = LocalDateTime.now();
        DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaFormateada = fechaDelInstante.format(formateadorDeFecha);

        String textoARegistrar = fechaFormateada + " - " + mensaje;

        agregarLineaEnArchivoDeBitacora(textoARegistrar);
        System.out.println(textoARegistrar);
    }

    private static void agregarLineaEnArchivoDeBitacora(String textoAImprimir) {
        File archivo = new File("bitacora.txt");

        try {
            Writer escritor = new FileWriter(archivo, true);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.append(textoAImprimir);
            buffer.append("\n");
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
