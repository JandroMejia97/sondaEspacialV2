package sondaEspacial.unidades.ingles.longitud;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Longitud;
import sondaEspacial.sistemas.ingles.Ingles;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Inglés que representa una Longitud.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Pulgada extends Longitud {

    /**
     * Factor de conversión de Pulgada a Yarda.
     */
    public static double F_CONV_A_YD = 0.0278;

    /**
     * Factor de conversión de Pulgada a Pie.
     */
    public static double F_CONV_A_FT = 0.0833;


    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public Pulgada(double cifra) {
        super(cifra, "in");
        setSistema(Ingles.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Convierte pulgadas en pies.
     * @return Su equivalente en Pies.
     */
    public Pie convertirAPie() {
        return new Pie(getCifra() * Pulgada.F_CONV_A_FT);
    }

    /**
     * Convierte pulgadas en Yardas.
     * @return Su equivalente en Yardas.
     */
    public Yarda convertirAYarda() {
        return new Yarda(getCifra() * Pulgada.F_CONV_A_YD);
    }

    @Override
    public MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        /**
         * El método convertirInterAIngles() en unidades de longitud siempre hace
         * la conversión a pies, aunque la unidad que recibe el mensaje sea o no
         * del mismo sistema.
         */
        if (!compararInstancia(m))
            m = ((Pie) m.convertirInterAIngles()).convertirAPulg();
        setCifra(getCifra() - m.getCifra());
        return this;
    }

    @Override
    public MagnitudFisica suma(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        /**
         * El método convertirInterAIngles() en unidades de longitud siempre hace
         * la conversión a pies, aunque la unidad que recibe el mensaje sea o no
         * del mismo sistema.
         */
        if (!compararInstancia(m))
            m = ((Pie) m.convertirInterAIngles()).convertirAPulg();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Pulgada;
    }

    /**
     * @return La unidad de medida en pies.
     */
    public MagnitudFisica convertirInterAIngles() {
        return convertirAPie();
    }

    /**
     * @return La unidad de medida en metros.
     */
    public MagnitudFisica convertirInglesAInter() {
        return convertirAPie().convertirInglesAInter();
    }

}