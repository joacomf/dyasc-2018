package ar.edu.untref.dyasc;

import java.io.IOException;

import ar.edu.untref.dyasc.excepciones.OpcionesNoValidasException;

public class Ejecutable {

    public static void main(String[] args) {

        LectorDeParametros lector;

        try {
            lector = new LectorDeParametros(args);

            Fibonacci fibonacci = new Fibonacci();
            fibonacci.generarSucesion(lector.getIteraciones());

            ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(fibonacci, lector.debeSerHorizontal(),
                    lector.debeIrAlDerecho(), lector.debeSerSumatoria());
            String textoDeLaImpresion = impresora.imprimir();

            if (lector.debeGuardarEnArchivo()) {
                AdministradorDeArchivos administrador = new AdministradorDeArchivos();
                administrador.guardar(textoDeLaImpresion, lector.getNombreDeArchivo(), fibonacci.getDimension() );
            }

            System.out.println(textoDeLaImpresion);

        } catch (OpcionesNoValidasException e) {
            System.out.println("Opciones no validas.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
