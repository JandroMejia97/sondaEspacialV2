package sondaEspacial.unidades.internacional.longitud;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Longitud;
import sondaEspacial.sistemas.internacional.Internacional;
import sondaEspacial.unidades.ingles.longitud.Pie;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Internacional que representa una Longitud.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Metro extends Longitud {

    /**
     * Factor de conversión de metros a kilómetros.
     */
    public static double F_CONV_A_KM = 10^-3;

    /**
     * Factor de conversión de metros a centímetros.
     */
    public static double F_CONV_A_CM = 10^2;

    /**
     * Factor de conversión de metros a pies.
     */
    public static double F_CONV_A_FT = 3.28084;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public Metro(double cifra) {
        super(cifra, "m");
        setSistema(Internacional.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Convierte metros en kilómetros.
     * @return Su equivalente en Kilómetros.
     */
    public Kilometro convertirAKilometro() {
        return new Kilometro(getCifra() * Metro.F_CONV_A_KM);
    }

    /**
     * Convierte metros en centímetros.
     * @return Su equivalente en centímetros.
     */
    public Centimetro convertirACentimetro() {
        return new Centimetro(getCifra() * Metro.F_CONV_A_CM);
    }

    @Override
    public MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        /**
         * El método convertirInglesAInter() en unidades de longitud siempre hace
         * la conversión a metros, aunque la unidad que recibe el mensaje sea o no
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
         * El método convertirInglesAInter() en unidades de longitud siempre hace
         * la conversión a metros, aunque la unidad que recibe el mensaje sea o no
         * del mismo sistema.
         */
        if (!compararInstancia(m))
            m = m.convertirInglesAInter();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Metro;
    }

    /**
     * @return La unidad en Pies.
     */
    public MagnitudFisica convertirInterAIngles() {
        return new Pie(getCifra() * Metro.F_CONV_A_FT);
    }

    /**
     * @return La unidad de medida en metros.
     */
    public MagnitudFisica convertirInglesAInter() {
        return this;
    }

}