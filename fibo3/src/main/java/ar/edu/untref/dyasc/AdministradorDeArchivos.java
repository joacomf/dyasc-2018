package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class AdministradorDeArchivos {

    void guardar(String textoAGuardar, String ruta, int grado) throws IOException {

        File archivo = new File(ruta);
    
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));
        escritor.write(textoAGuardar);
        escritor.close();

        System.out.println("fibo<"+ String.valueOf(grado) +"> guardado en " + ruta);
    }

}
