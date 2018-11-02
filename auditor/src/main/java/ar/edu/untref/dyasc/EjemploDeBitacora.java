package ar.edu.untref.dyasc;

class EjemploDeBitacora {

    void registroMensajeDeError() {
        Bitacora.registrar("Ha ocurrido un error al intentar ejecutar este metodo");
    }

    void registroConMensajeVacio() {
        Bitacora.registrar("");
    }

    void registroDentroDeUnaIteracion() {
        for (int i = 0; i < 3; i++) {
            Bitacora.registrar("Mensaje de información en iteración " + i);
        }
    }
}
