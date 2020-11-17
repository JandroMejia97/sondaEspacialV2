package sondaEspacial.unidades.tiempo;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Tiempo;
import sondaEspacial.sistemas.Sistema;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida que representa el Tiempo.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Hora extends Tiempo {

    /**
     * Factor de conversión de horas a minutos.
     */
    public static double F_CONV_A_MIN = 60;

    /**
     * Factor de conversión de horas a segundos.
     */
    public static double F_CONV_A_SEG = 3600;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     * @param sistema Sistema al que pertenece la unidad.
     */
    public Hora(double cifra, Sistema sistema) {
        super(cifra, "h");
        setSistema(sistema);
    }

    /**
     * Convierte horas en minutos.
     * @return Su equivalente en minutos.
     */
    public Minuto convertirAMin() {
        return new Minuto(getCifra() * Hora.F_CONV_A_MIN, getSistema());
    }

    /**
     * Convierte horas en segundos.
     * @return Su equivalente en segundos.
     */
    public Segundo convertirASeg() {
        return new Segundo(getCifra() * Hora.F_CONV_A_SEG, getSistema());
    }

    @Override
    public MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        if (!compararInstancia(m))
            m = ((Segundo) m.convertirInglesAInter()).convertirAHora();
        setCifra(getCifra() - m.getCifra());
        return this;
    }

    @Override
    public MagnitudFisica suma(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        if (!compararInstancia(m))
            m = ((Segundo) m.convertirInglesAInter()).convertirAHora();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Hora;
    }

    @Override
    public MagnitudFisica convertirInterAIngles() {
        return convertirASeg();
    }

    @Override
    public MagnitudFisica convertirInglesAInter() {
        return convertirASeg();
    }
}