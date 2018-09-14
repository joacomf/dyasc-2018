package ar.edu.untref.dyasc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bitacora {

    public static void registrar(String mensaje) {
        LocalDateTime fechaDelInstante = LocalDateTime.now();
        DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaFormateada = fechaDelInstante.format(formateadorDeFecha);

        String textoARegistrar = fechaFormateada + " - " + mensaje;

        System.out.println(textoARegistrar);
    }

}
