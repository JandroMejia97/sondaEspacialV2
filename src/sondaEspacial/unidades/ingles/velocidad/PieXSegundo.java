package sondaEspacial.unidades.ingles.velocidad;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.derivadas.Velocidad;
import sondaEspacial.sistemas.ingles.Ingles;
import sondaEspacial.unidades.ingles.longitud.Pie;
import sondaEspacial.unidades.internacional.velocidad.MetroXSegundo;
import sondaEspacial.unidades.tiempo.Segundo;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Inglés que representa la Velocidad.
 * @author Carlos Alejandro Hernández Mejía
 */
public class PieXSegundo extends Velocidad {

    /**
     * Factor de conversión de ft/s a m/s.
     */
    public static double F_CONV_A_MxS = 0.3048;

    /**
     * Pies.
     */
    private Pie pies;

    /**
     * Segundos.
     */
    private Segundo segundos;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public PieXSegundo(double cifra) {
        super(cifra, "ft/s");
        setSistema(Ingles.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Constructor con parámetros que realiza el calculo de la velocidad
     * en base a instancias de pies y segundos pasadas como parámetros.
     * @param pies Longitud en pies.
     * @param segundos Tiempo en segundos.
     */
    public PieXSegundo(Pie pies, Segundo segundos) {
        this(pies.getCifra() / segundos.getCifra());
        this.pies = pies;
        this.segundos = segundos;
    }

    /**
     * Constructor con parámetros que realiza el cálculo de la velocidad
     * en base a los valores de la longitud (en pies) y el tiempo (en segundos)
     * pasados como parámetros.
     * @param pies Longitud en pies.
     * @param segundos Tiempo en segundos.
     */
    public PieXSegundo(double pies, double segundos) {
        this(pies / segundos);
        this.pies = new Pie(pies);
        this.segundos = new Segundo(segundos, getSistema());
    }

    public Pie getPies() {
        return pies;
    }

    public void setPies(Pie pies) {
        this.pies = pies;
        this.setCifra(this.pies.getCifra() / this.segundos.getCifra());
    }

    public void setPies(double pies) {
        this.pies.setCifra(pies);
        this.setCifra(this.pies.getCifra() / this.segundos.getCifra());
    }

    public Segundo getSegundos() {
        return segundos;
    }

    public void setSegundos(Segundo segundos) {
        this.segundos = segundos;
        this.setCifra(this.pies.getCifra() / this.segundos.getCifra());
    }

    public void setSegundos(double segundos) {
        this.segundos.setCifra(segundos);
        this.setCifra(this.pies.getCifra() / this.segundos.getCifra());
    }

    @Override
    public MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        /**
         * El método convertirInterAIngles() en unidades de velocidad siempre hace
         * la conversión a ft/s, aunque la unidad que recibe el mensaje sea o no
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
         * El método convertirInterAIngles() en unidades de velocidad siempre hace
         * la conversión a ft/s, aunque la unidad que recibe el mensaje sea o no
         * del mismo sistema.
         */
        if (!compararInstancia(m))
            m = m.convertirInterAIngles();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof PieXSegundo;
    }

    /**
     * @return La unidad de medida en pie/s.
     */
    public MagnitudFisica convertirInterAIngles() {
        return this;
    }

    /**
     * @return La unidad de medida en m/s.
     */
    public MagnitudFisica convertirInglesAInter() {
        return new MetroXSegundo(getCifra() * PieXSegundo.F_CONV_A_MxS);
    }

}