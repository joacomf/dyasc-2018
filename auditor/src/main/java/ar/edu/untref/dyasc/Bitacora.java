package ar.edu.untref.dyasc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Bitacora {

    private static DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static String propiedadDeDestino = System.getProperty("bitacora.destino");
    private static Imprimible impresora = new AdministradorDeImpresoras(propiedadDeDestino);

    static void registrar(String mensaje) {
        LocalDateTime fechaDelInstante = LocalDateTime.now();
        String fechaFormateada = fechaDelInstante.format(formateadorDeFecha);

        String textoARegistrar = fechaFormateada + " - " + mensaje;

        impresora.imprimir(textoARegistrar);
    }
}
