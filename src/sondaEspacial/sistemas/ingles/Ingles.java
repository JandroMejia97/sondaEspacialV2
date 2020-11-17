package sondaEspacial.sistemas.ingles;

import sondaEspacial.sistemas.Sistema;

/**
 * @author Carlos Alejandro Hernández Mejía
 */
public class Ingles extends Sistema {

    /**
     * 
     */
    private static Ingles INSTANCE;

    /**
     * @return
     */
    private Ingles() {
        super("Ingles");
    }

    /**
     * @return
     */
    public static Ingles getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Ingles();
        return INSTANCE;
    }

    /**
     * @param u 
     * @return
     */
    public boolean compararInstancia(Sistema u) {
        return u instanceof Ingles;
    }

}