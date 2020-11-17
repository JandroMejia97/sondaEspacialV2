package sondaEspacial.magnitudes.fundamentales;

import sondaEspacial.magnitudes.MagnitudFisica;

/**
 * Representa la masa como magnitud física fundamental.
 * @author Carlos Alejandro Hernández Mejía
 */
public abstract class Masa extends Fundamental implements Comparable<Masa> {

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa la magnitud física.
     * @param abrev Abreviatura que acompaña la unidad de medida.
     */
    public Masa(double cifra, String abrev) {
        super(cifra, abrev);
    }

    @Override
    public boolean magnitudCompatible(MagnitudFisica m) {
        return m instanceof Masa;
    }

}