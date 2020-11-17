package sondaEspacial.magnitudes.derivadas;

import sondaEspacial.magnitudes.MagnitudFisica;


/**
 * @author Carlos Alejandro Hernández Mejía
 */
public abstract class Derivada extends MagnitudFisica {


    /**
     * @param cifra 
     * @param abrev 
     * @return
     */
    public Derivada(double cifra, String abrev) {
        super(cifra, abrev);
    }

}