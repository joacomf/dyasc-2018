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

            if (lector.debeGuardarEnArchivo()) {
                AdministradorDeArchivos administrador = new AdministradorDeArchivos();
                administrador.guardar(impresora.imprimir(), lector.getNombreDeArchivo());
            }

            System.out.println(impresora.imprimir());

        } catch (OpcionesNoValidasException e) {
            System.out.println("Opciones no validas.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
