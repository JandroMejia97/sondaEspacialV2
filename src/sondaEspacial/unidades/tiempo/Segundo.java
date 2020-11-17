package sondaEspacial.unidades.tiempo;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Tiempo;
import sondaEspacial.sistemas.Sistema;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida que representa el Tiempo.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Segundo extends Tiempo {

    /**
     * Factor de conversión de segundos a minutos.
     */
    public static double F_CONV_A_MIN = 0.0167;

    /**
     * Factor de conversión de segundos a horas.
     */
    public static double F_CONV_A_HR = 2.78*(10^-4);

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     * @param sistema Sistema al que pertenece la unidad.
     */
    public Segundo(double cifra, Sistema sistema) {
        super(cifra, "h");
        setSistema(sistema);
    }

    /**
     * Convierte segundos en horas.
     * @return Su equivalente en horas.
     */
    public Hora convertirAHora() {
        return new Hora(getCifra() * Segundo.F_CONV_A_HR, getSistema());
    }

    /**
     * Convierte segundos en minutos.
     * @return Su equivalente en minutos.
     */
    public Minuto convertirAMin() {
        return new Minuto(getCifra() * Segundo.F_CONV_A_MIN, getSistema());
    }

    @Override
    public MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        if (!compararInstancia(m))
            m = m.convertirInglesAInter();
        setCifra(getCifra() - m.getCifra());
        return this;
    }

    @Override
    public MagnitudFisica suma(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        if (!compararInstancia(m))
            m = m.convertirInglesAInter();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Segundo;
    }

    @Override
    public MagnitudFisica convertirInterAIngles() {
        return this;
    }

    @Override
    public MagnitudFisica convertirInglesAInter() {
        return this;
    }

    /**
     * @param o Objeto a comparar.
     * @return El resultado de la comparación.
     */
    @Override
    public int compareTo(Tiempo o) {
        if (!compararInstancia(o))
            o = (Segundo) o.convertirInglesAInter();
        return (int) (getCifra() - o.getCifra());
    }
}