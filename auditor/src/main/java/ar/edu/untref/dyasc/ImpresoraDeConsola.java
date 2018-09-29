package ar.edu.untref.dyasc;

public class ImpresoraDeConsola extends Impresora{

    private static Impresora instanciaDeImpresora = new ImpresoraDeConsola();

    private ImpresoraDeConsola(){}

    static Impresora getInstance() {
        return instanciaDeImpresora;
    }

    public void imprimir(String textoDeImpresion) {
        System.out.println(textoDeImpresion);
    }

}
