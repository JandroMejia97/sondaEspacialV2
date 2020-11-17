package sondaEspacial.unidades.ingles.masa;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Masa;
import sondaEspacial.sistemas.ingles.Ingles;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Inglés que representa Masa.
 * @author Carlos Alejandro Hernández Mejía
 */
public class ToneladaCorta extends Masa {

    /**
     * Factor de conversión de toneladas a libras.
     */
    public static double F_CONV_A_LB = 2000;

    /**
     * Factor de conversión de toneladas a onzas.
     */
    public static double F_CONV_A_OZ = 32000;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public ToneladaCorta(double cifra) {
        super(cifra, "ton");
        setSistema(Ingles.getInstance());
    }

    /**
     * Convierte toneladas cortas en onzas.
     * @return Su equivalente en onzas.
     */
    public Onza convertirAOz() {
        return new Onza(getCifra() * ToneladaCorta.F_CONV_A_OZ);
    }

    /**
     * Convierte toneladas cortas en libras.
     * @return Su equivalente en libras.
     */
    public LibraMasa convertirALb() {
        return new LibraMasa(getCifra() * ToneladaCorta.F_CONV_A_LB);
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
        return m instanceof ToneladaCorta;
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