package sondaEspacial.magnitudes.fundamentales;

import sondaEspacial.magnitudes.MagnitudFisica;

/**
 * @author Carlos Alejandro Hernández Mejía
 */
public abstract class Fundamental extends MagnitudFisica {

    /**
     * @param cifra 
     * @param abrev 
     * @return
     */
    public Fundamental(double cifra, String abrev) {
        super(cifra, abrev);
    }

}