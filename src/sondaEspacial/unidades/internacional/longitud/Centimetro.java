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
public class Centimetro extends Longitud {

    /**
     * Factor de conversión de Centímetros a Metros.
     */
    public static double F_CONV_A_M = 0.01;

    /**
     * Factor de conversión de Centímetros a Kilómetros.
     */
    public static double F_CONV_A_KM = 0.00001;

    /**
     * Constructor con parámetros.
     *
     * @param cifra Cifra que representa esta unidad.
     */
    public Centimetro(double cifra) {
        super(cifra, "cm");
        setSistema(Internacional.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Convierte centímetros en metros.
     *
     * @return Su equivalente en metros.
     */
    public Metro convertirAMetro() {
        return new Metro(getCifra() * Centimetro.F_CONV_A_M);
    }

    /**
     * Convierte centímetros a kilómetros.
     *
     * @return Su equivalente en kilómetros.
     */
    public Kilometro convertirAKilometro() {
        return new Kilometro(getCifra() * Centimetro.F_CONV_A_KM);
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
            m = ((Metro) m.convertirInglesAInter()).convertirACentimetro();
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
            m = ((Metro) m.convertirInglesAInter()).convertirACentimetro();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Centimetro;
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