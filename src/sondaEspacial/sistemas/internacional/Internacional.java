package sondaEspacial.sistemas.internacional;

import sondaEspacial.sistemas.Sistema;

/**
 * @author Carlos Alejandro Hernández Mejía
 */
public class Internacional extends Sistema {
    /**
     * Singleton
     */
    private static Internacional INSTANCE;

    /**
     * Default constructor
     */
    private Internacional() {
        super("Internacional");
    }

    /**
     * @return
     */
    public static Internacional getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Internacional();
        return INSTANCE;
    }

    /**
     * @param u 
     * @return
     */
    public boolean compararInstancia(Sistema u) {
        return u instanceof Internacional;
    }

}