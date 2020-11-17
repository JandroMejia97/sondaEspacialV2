package sondaEspacial.unidades.internacional.masa;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Masa;
import sondaEspacial.sistemas.internacional.Internacional;
import sondaEspacial.unidades.ingles.masa.LibraMasa;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Internacional que representa una Masa.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Kilogramo extends Masa {

    /**
     * Factor de conversión de Kilogramos a Gramos.
     */
    public static double F_CONV_A_G = 1*10^3;

    /**
     * Factor de conversión de Kilogramos a Miligramos.
     */
    public static double F_CONV_A_MG = 1*10^6;

    /**
     * Factor de conversión de Kilogramos a Libras.
     */
    public static double F_CONV_A_LB = 2.20462;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public Kilogramo(double cifra) {
        super(cifra, "kg");
        setSistema(Internacional.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Convierte kilogramos en gramos.
     * @return Su equivalente en gramos.
     */
    public Gramo convertirAG() {
        return new Gramo(getCifra() * Kilogramo.F_CONV_A_G);
    }

    /**
     * Convierte kilogramos en miligramos.
     * @return Su equivalente en miligramos.
     */
    public Miligramo convertirAMg() {
        return new Miligramo(getCifra() * Kilogramo.F_CONV_A_MG);
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
            m = m.convertirInglesAInter();
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
            m = m.convertirInglesAInter();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Kilogramo;
    }

    /**
     * @return La unidad de medida en Libras.
     */
    public MagnitudFisica convertirInterAIngles() {
        return new LibraMasa(getCifra() * Kilogramo.F_CONV_A_LB);
    }

    /**
     * @return La unidad de medida en kilogramos.
     */
    public MagnitudFisica convertirInglesAInter() {
        return this;
    }

}