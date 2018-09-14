package ar.edu.untref.dyasc;

public class EjemploDeBitacora {

    public void registroMensajeDeError() {
        Bitacora.registrar("Ha ocurrido un error al intentar ejecutar este metodo");
    }

    public void registroConMensajeVacio() {
        Bitacora.registrar("");
    }

    public void registroDentroDeUnaIteracion() {
        for (int i = 0; i < 3; i++) {
            Bitacora.registrar("Mensaje de información en iteración " + i);
        }
    }
}
