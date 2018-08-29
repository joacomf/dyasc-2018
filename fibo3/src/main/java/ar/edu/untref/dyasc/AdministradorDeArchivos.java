package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdministradorDeArchivos {

    public void guardar(String textoAGuardar, String ruta) throws IOException {
;
        File archivo = new File(ruta);
    
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));
        escritor.write(textoAGuardar);
        escritor.close();

    }

}
