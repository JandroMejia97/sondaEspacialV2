package sondaEspacial.magnitudes.derivadas;

import sondaEspacial.magnitudes.MagnitudFisica;

/**
 * Representa la velocidad como magnitud física derivada.
 * @author Carlos Alejandro Hernández Mejía
 */
public abstract class Velocidad extends Derivada {

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa la magnitud física.
     * @param abrev Abreviatura que acompaña la unidad de medida.
     */
    public Velocidad(double cifra, String abrev) {
        super(cifra, abrev);
    }

    @Override
    public boolean magnitudCompatible(MagnitudFisica m) {
        return m instanceof Velocidad;
    }

}