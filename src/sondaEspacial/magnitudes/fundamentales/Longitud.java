package sondaEspacial.magnitudes.fundamentales;

import sondaEspacial.magnitudes.MagnitudFisica;

/**
 * Representa la longitud como magnitud física fundamental.
 * @author Carlos Alejandro Hernández Mejía
 */
public abstract class Longitud extends Fundamental {

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa la magnitud física.
     * @param abrev Abreviatura que acompaña la unidad de medida.
     */
    public Longitud(double cifra, String abrev) {
        super(cifra, abrev);
    }

    @Override
    public boolean magnitudCompatible(MagnitudFisica m) {
        return m instanceof Longitud;
    }
}