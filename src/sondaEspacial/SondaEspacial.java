package sondaEspacial;

import sondaEspacial.magnitudes.MagnitudFisica;

/**
 * @author Carlos Alejandro Hernández Mejía
 */
public class SondaEspacial<T extends MagnitudFisica> {

    /**
     * Default constructor
     */
    public SondaEspacial() {
    }

    /**
     * @param unidad 
     */
    public void imprimir(T unidad) {
        System.out.println("La sonda recibió: " + unidad.toString());
    }

}