package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Bitacora {

    private static DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static String propiedadDeDestino = System.getProperty("DestinoBitacora");

    static void registrar(String mensaje) {
        LocalDateTime fechaDelInstante = LocalDateTime.now();
        String fechaFormateada = fechaDelInstante.format(formateadorDeFecha);

        String textoARegistrar = fechaFormateada + " - " + mensaje;

        if (propiedadDeDestino != null) {
            agregarLineaEnArchivoDeBitacora(textoARegistrar);
        } else {
            System.out.println(textoARegistrar);
        }
    }

    private static void agregarLineaEnArchivoDeBitacora(String textoAImprimir) {
        File archivo = new File(propiedadDeDestino);

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
