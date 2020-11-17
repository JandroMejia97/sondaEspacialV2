package sondaEspacial.unidades.ingles.longitud;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Longitud;
import sondaEspacial.sistemas.ingles.Ingles;
import sondaEspacial.unidades.internacional.longitud.Metro;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Inglés que representa una Longitud.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Pie extends Longitud {

    /**
     * Factor de conversión de Pie a Yarda.
     */
    public static double F_CONV_A_YD = 1 / 3;

    /**
     * Factor de conversión de Pie a Pulgadas.
     */
    public static double F_CONV_A_IN = 12;

    /**
     * Factor de conversión de Pie a Metro.
     */
    public static double F_CONV_A_METRO = 0.3048;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public Pie(double cifra) {
        super(cifra, "ft");
        setSistema(Ingles.getInstance());
    }

    /**
     * Convierte pies en yardas.
     * @return Su equivalente en yardas.
     */
    public Yarda convertirAYarda() {
        return new Yarda(getCifra() * Pie.F_CONV_A_YD);
    }

    /**
     * Convierte pies en pulgadas.
     * @return Su equivalente en Pulgadas.
     */
    public Pulgada convertirAPulg() {
        return new Pulgada(getCifra() * Pie.F_CONV_A_IN);
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
            m = m.convertirInterAIngles();
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
            m = m.convertirInterAIngles();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Pie;
    }

    /**
     * @return La unidad de medida en pies.
     */
    public MagnitudFisica convertirInterAIngles() {
        return this;
    }

    /**
     * @return La unidad de medida en metros.
     */
    public MagnitudFisica convertirInglesAInter() {
        return new Metro(getCifra() * Pie.F_CONV_A_METRO);
    }

}