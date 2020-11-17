package sondaEspacial.unidades.internacional.masa;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Masa;
import sondaEspacial.sistemas.internacional.Internacional;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Internacional que representa una Masa
 * @author Carlos Alejandro Hernández Mejía
 */
public class Miligramo extends Masa {

    /**
     * Factor de conversión de miligramos a gramos.
     */
    public static double F_CONV_A_G = 1*10^-3;

    /**
     * Factor de conversión de miligramos a kilogramos.
     */
    public static double F_CONV_A_KG = 1*10^-6;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public Miligramo(double cifra) {
        super(cifra, "mg");
        setSistema(Internacional.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Convierte miligramos a gramos.
     * @return Su equivalente en gramos.
     */
    public Gramo convertirAG() {
        return new Gramo(getCifra() * Miligramo.F_CONV_A_G);
    }

    /**
     * Convierte miligramos a kilogramos.
     * @return Su equivalente en kilogramos.
     */
    public Kilogramo convertirAKg() {
        return new Kilogramo(getCifra() * Miligramo.F_CONV_A_KG);
    }

    @Override
    public MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        /**
         * El método convertirInglesAInter() en unidades de masa siempre hace
         * la conversión a kilogramos, aunque la unidad que recibe el mensaje sea o no
         * del mismo sistema.
         */
        if (!compararInstancia(m))
            m = ((Kilogramo) m.convertirInglesAInter()).convertirAMg();
        setCifra(getCifra() - m.getCifra());
        return this;
    }

    @Override
    public MagnitudFisica suma(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        /**
         * El método convertirInglesAInter() en unidades de masa siempre hace
         * la conversión a kilogramos, aunque la unidad que recibe el mensaje sea o no
         * del mismo sistema.
         */
        if (!compararInstancia(m))
            m = ((Kilogramo) m.convertirInglesAInter()).convertirAMg();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Miligramo;
    }

    /**
     * @return La unidad de medida en libras.
     */
    public MagnitudFisica convertirInterAIngles() {
        return convertirAKg().convertirInterAIngles();
    }

    /**
     * @return La unidad de medida en kilogramos.
     */
    public MagnitudFisica convertirInglesAInter() {
        return convertirAKg();
    }

}