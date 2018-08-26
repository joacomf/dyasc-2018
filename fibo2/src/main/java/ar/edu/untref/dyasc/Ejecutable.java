package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.excepciones.OpcionesNoValidasException;

public class Ejecutable {

    public static void main(String[] args) {

        LectorDeParametros lector;
        try {
            lector = new LectorDeParametros(args);

            Fibonacci fibonacci = new Fibonacci();
            fibonacci.generarSucesion(lector.getIteraciones());

            ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(fibonacci, lector.debeSerHorizontal(),
                    lector.debeIrAlDerecho());

            System.out.println(impresora.imprimir());

        } catch (OpcionesNoValidasException e) {
            System.out.println("Opciones no validas.");
        }

    }

}
