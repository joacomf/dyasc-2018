package ar.edu.untref.dyasc;

public class Ejecutable {

    public static void main(String[] args) {

        int cantidadDeIteraciones = Integer.valueOf(args[0]);

        Fibonacci fibonacci = new Fibonacci();
        fibonacci.generarSucesion(cantidadDeIteraciones);

        ImpresoraDeFibonacci impresora = new ImpresoraDeFibonacci(fibonacci);

        System.out.println(impresora.imprimir());

    }

}
