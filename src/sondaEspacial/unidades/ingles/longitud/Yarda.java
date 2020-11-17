package sondaEspacial.unidades.ingles.longitud;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Longitud;
import sondaEspacial.sistemas.ingles.Ingles;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Inglés que representa una Longitud.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Yarda extends Longitud {

    /**
     * Factor de conversión de Yarda a Pulgada.
     */
    public static double F_CONV_A_IN = 36;

    /**
     * Factor de conversión de Yarda a Pie.
     */
    public static double F_CONV_A_FT = 3;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public Yarda(double cifra) {
        super(cifra, "yd");
        setSistema(Ingles.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Convierte yardas en pies.
     * @return Su equivalente en Pies.
     */
    public Pie convertirAPie() {
        return new Pie(getCifra() * Yarda.F_CONV_A_FT);
    }

    /**
     * Convierte yardas en pulgadas.
     * @return Su equivalente en Pulgadas.
     */
    public Pulgada convertirAPulg() {
        return new Pulgada(getCifra() * Yarda.F_CONV_A_IN);
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
            m = ((Pie) m.convertirInterAIngles()).convertirAYarda();
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
            m = ((Pie) m.convertirInterAIngles()).convertirAYarda();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Yarda;
    }

    /**
     * @return La unidad de medida en pies.
     */
    public MagnitudFisica convertirInterAIngles() {
        return convertirAPie();
    }

    /**
     * @return La unidad de medida en metros.
     */
    public MagnitudFisica convertirInglesAInter() {
        return convertirAPie().convertirInglesAInter();
    }

    /**
     * @param o Objeto a comparar.
     * @return El resultado de la comparación.
     */
    @Override
    public int compareTo(Longitud o) {
        if (!compararInstancia(o))
            o = ((Pie) o.convertirInterAIngles()).convertirAYarda();
        return (int) (getCifra() - o.getCifra());
    }
}