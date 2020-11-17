package sondaEspacial.unidades.tiempo;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Tiempo;
import sondaEspacial.sistemas.Sistema;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida que representa el Tiempo.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Minuto extends Tiempo {

    /**
     * Factor de conversión de minutos a segundos.
     */
    public static double F_CONV_A_SEG = 60;

    /**
     * Factor de conversión de minutos a horas.
     */
    public static double F_CONV_A_HR = 0.0167;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     * @param sistema Sistema al que pertenece la unidad.
     */
    public Minuto(double cifra, Sistema sistema) {
        super(cifra, "h");
        setSistema(sistema);
    }

    /**
     * Convierte minutos a horas.
     * @return Su equivalente en horas.
     */
    public Hora convertirAHora() {
        return new Hora(getCifra() * Minuto.F_CONV_A_HR, getSistema());
    }

    /**
     * Convierte minutos a segundos.
     * @return Su equivalente en segundos.
     */
    public Segundo convertirASeg() {
        return new Segundo(getCifra() * Minuto.F_CONV_A_SEG, getSistema());
    }

    @Override
    public MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        if (!compararInstancia(m))
            m = ((Segundo) m.convertirInglesAInter()).convertirAMin();
        setCifra(getCifra() - m.getCifra());
        return this;
    }

    @Override
    public MagnitudFisica suma(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        if (!compararInstancia(m))
            m = ((Segundo) m.convertirInglesAInter()).convertirAMin();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Minuto;
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
