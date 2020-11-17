package sondaEspacial.unidades.ingles.masa;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Masa;
import sondaEspacial.sistemas.ingles.Ingles;
import sondaEspacial.unidades.internacional.masa.Kilogramo;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Inglés que representa Masa.
 * @author Carlos Alejandro Hernández Mejía
 */
public class LibraMasa extends Masa {

    /**
     * Factor de conversion de Libra Masa a Onzas.
     */
    public static double F_CONV_A_OZ = 16;

    /**
     * Factor de conversión de Libra Masa a Tonelada corta.
     */
    public static double F_CONV_A_TC = 0.0005;

    /**
     * Factor de conversión de Libra Masa a Kilogramos.
     */
    public static double F_CONV_A_KG = 0.45359;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public LibraMasa(double cifra) {
        super(cifra, "lbm");
        setSistema(Ingles.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Convierte libras en onzas.
     * @return Su equivalente en onzas.
     */
    public Onza convertirAOz() {
        return new Onza(getCifra() * LibraMasa.F_CONV_A_OZ);
    }

    /**
     * Convierte libras a toneladas cortas.
     * @return Su equivalente en toneladas cortas.
     */
    public ToneladaCorta convertirATC() {
        return new ToneladaCorta(getCifra() * LibraMasa.F_CONV_A_TC);
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
            m = m.convertirInterAIngles();
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
            m = m.convertirInterAIngles();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof LibraMasa;
    }

    /**
     * @return La unidad de medida en libras.
     */
    public MagnitudFisica convertirInterAIngles() {
        return this;
    }

    /**
     * @return La unidad de medida en Kilogramos.
     */
    public MagnitudFisica convertirInglesAInter() {
        return new Kilogramo(getCifra() * LibraMasa.F_CONV_A_KG);
    }

}