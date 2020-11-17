package sondaEspacial.unidades.internacional.masa;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.fundamentales.Masa;
import sondaEspacial.sistemas.internacional.Internacional;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Internacional que representa una Masa.
 * @author Carlos Alejandro Hernández Mejía
 */
public class Gramo extends Masa {

    /**
     * Factor de conversión de Gramos a Miligramos.
     */
    public static double F_CONV_A_MG = 1*10^-3;

    /**
     * Factor de conversión de gramos a kilogramos.
     */
    public static double F_CONV_A_KG = 1*10^3;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public Gramo(double cifra) {
        super(cifra, "g");
        setSistema(Internacional.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Convierte gramos en kilogramos.
     * @return Su equivalente en kilogramos.
     */
    public Kilogramo convertirAKg() {
        return new Kilogramo(getCifra() * Gramo.F_CONV_A_KG);
    }

    /**
     * Convierte gramos en miligramos.
     * @return Su equivalente en miligramos.
     */
    public Miligramo convertirAMg() {
        return new Miligramo(getCifra() * Gramo.F_CONV_A_MG);
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
            m = ((Kilogramo) m.convertirInglesAInter()).convertirAG();
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
            m = ((Kilogramo) m.convertirInglesAInter()).convertirAG();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Gramo;
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

    /**
     * @param o Objeto a comparar.
     * @return El resultado de la comparación.
     */
    @Override
    public int compareTo(Masa o) {
        if (!compararInstancia(o))
            o = ((Kilogramo) o.convertirInglesAInter()).convertirAG();
        return (int) (getCifra() - o.getCifra());
    }
}