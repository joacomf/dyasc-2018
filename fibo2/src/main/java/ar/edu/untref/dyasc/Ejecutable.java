package ar.edu.untref.dyasc;

public class Ejecutable {

    public static void main(String[] args) {

        LectorDeParametros lector = new LectorDeParametros(args);

        Fibonacci fibonacci = new Fibonacci();
        fibonacci.generarSucesion(lector.getIteraciones());

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(fibonacci, lector.debeSerHorizontal(), lector.debeIrAlDerecho());

        System.out.println(impresora.imprimir());

    }

}
