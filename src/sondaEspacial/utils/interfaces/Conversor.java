package sondaEspacial.utils.interfaces;

import sondaEspacial.magnitudes.MagnitudFisica;


public interface Conversor {
    /**
     * Realiza la conversión de una unidad de medida del Sistema Internacional
     * al Sistema Inglés.
     * @return Una magnitud física del Sistema Inglés.
     */
    public MagnitudFisica convertirInterAIngles();

    /**
     * Realiza la conversión de una unidad de medida del Sistema Inglés
     * al Sistema Internacional.
     * @return Una magnitud física del Sistema Internacional.
     */
    public MagnitudFisica convertirInglesAInter();
}
