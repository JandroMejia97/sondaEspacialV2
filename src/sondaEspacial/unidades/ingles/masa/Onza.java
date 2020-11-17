package sondaEspacial.unidades.ingles.masa;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Masa;
import sondaEspacial.sistemas.ingles.Ingles;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Inglés que representa Masa.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Onza extends Masa {

    /**
     * Factor de conversión de onzas a libras.
     */
    public static double F_CONV_A_LB = 0.0625;

    /**
     * Factor de conversión de onzas a toneladas cortas.
     */
    public static double F_CONV_A_TC = 3.125*(10^-5);

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public Onza(double cifra) {
        super(cifra, "oz");
        setSistema(Ingles.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Convierte onzas a libras.
     * @return Su equivalente en libras.
     */
    public LibraMasa convertirALb() {
        return new LibraMasa(getCifra() * Onza.F_CONV_A_LB);
    }

    /**
     * Convierte onzas a toneladas cortas.
     * @return Su equivalente en toneladas cortas.
     */
    public ToneladaCorta convertirATC() {
        return new ToneladaCorta(getCifra() * Onza.F_CONV_A_TC);
    }

    @Override
    public MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        /**
         * El método convertirInterAIngles() en unidades de masa siempre hace
         * la conversión a libras, aunque la unidad que recibe el mensaje sea o no
         * del mismo sistema.
         */
        if (!compararInstancia(m))
            m = ((LibraMasa) m.convertirInterAIngles()).convertirAOz();
        setCifra(getCifra() - m.getCifra());
        return this;
    }

    @Override
    public MagnitudFisica suma(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        /**
         * El método convertirInterAIngles() en unidades de masa siempre hace
         * la conversión a libras, aunque la unidad que recibe el mensaje sea o no
         * del mismo sistema.
         */
        if (!compararInstancia(m))
            m = ((LibraMasa) m.convertirInterAIngles()).convertirAOz();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Onza;
    }

    /**
     * @return La unidad de medida en libras.
     */
    public MagnitudFisica convertirInterAIngles() {
        return convertirALb();
    }

    /**
     * @return La unidad de medida en kilogramos.
     */
    public MagnitudFisica convertirInglesAInter() {
        return convertirALb().convertirInglesAInter();
    }

}