package ar.edu.untref.dyasc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Bitacora {

    private static DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static String propiedadDeDestino = System.getProperty("bitacora.destino");

    static void registrar(String mensaje) {
        LocalDateTime fechaDelInstante = LocalDateTime.now();
        String fechaFormateada = fechaDelInstante.format(formateadorDeFecha);

        String textoARegistrar = fechaFormateada + " - " + mensaje;

        Impresora impresora;

        if (!propiedadDeDestino.equals("CONSOLA")) {
            impresora = ImpresoraDeArchivo.getInstance(propiedadDeDestino);
        } else {
            impresora = ImpresoraDeConsola.getInstance();
        }

        impresora.imprimir(textoARegistrar);
    }
}
