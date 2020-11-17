package sondaEspacial.unidades.internacional.longitud;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Longitud;
import sondaEspacial.sistemas.internacional.Internacional;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Internacional que representa una Longitud.
 *
 * @author Carlos Alejandro Hernández Mejía
 */
public class Kilometro extends Longitud {

    /**
     * Factor de conversión de kilómetros a metros.
     */
    public static double F_CONV_A_M = 1000;

    /**
     * Factor de conversión de kilómetros a centímetros.
     */
    public static double F_CONV_A_CM = 100000;

    /**
     * Constructor con parámetros.
     *
     * @param cifra Cifra que representa esta unidad.
     */
    public Kilometro(double cifra) {
        super(cifra, "km");
        setSistema(Internacional.getInstance());
    }

    /**
     * Convierte kilómetros a metros.
     *
     * @return Su equivalente en metros.
     */
    public Metro convertirAMetro() {
        return new Metro(getCifra() * Kilometro.F_CONV_A_M);
    }

    /**
     * Convierte kilómetros a centímetros.
     *
     * @return Su equivalente en centímetros.
     */
    public Centimetro convertirACentimetro() {
        return new Centimetro(getCifra() * Kilometro.F_CONV_A_CM);
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
            m = ((Metro) m.convertirInglesAInter()).convertirAKilometro();
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
            m = ((Metro) m.convertirInglesAInter()).convertirAKilometro();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Kilometro;
    }

    /**
     * @return La unidad de medida en pies.
     */
    public MagnitudFisica convertirInterAIngles() {
        return convertirAMetro().convertirInterAIngles();
    }

    /**
     * @return La unidad de medida en metros.
     */
    public MagnitudFisica convertirInglesAInter() {
        return convertirAMetro();
    }

}