package sondaEspacial.unidades;

import sondaEspacial.sistemas.Sistema;

/**
 * @author Carlos Alejandro Hernández Mejía
 */
public abstract  class UnidadDeMedida {

    /**
     * Constructor por defecto.
     */
    public UnidadDeMedida() {
    }

    /**
     * Sistema al que pertenece la unidad.
     */
    private Sistema sistema;

    /**
     * Obtiene el sistema.
     * @return El sistema al que pertenece la unidad.
     */
    public Sistema getSistema() {
        return sistema;
    }

    /**
     * Modifica el sistema.
     * @param s Sistema al que pertenece la unidad.
     */
    protected void setSistema(Sistema s) {
        sistema = s;
    }

}