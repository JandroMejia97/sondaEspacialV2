package sondaEspacial.unidades.internacional.velocidad;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.derivadas.Velocidad;
import sondaEspacial.sistemas.internacional.Internacional;
import sondaEspacial.unidades.ingles.longitud.Pie;
import sondaEspacial.unidades.ingles.velocidad.PieXSegundo;
import sondaEspacial.unidades.internacional.longitud.Metro;
import sondaEspacial.unidades.tiempo.Segundo;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Inglés que representa la Velocidad.
 * @author Carlos Alejandro Hernández Mejía
 */
public class MetroXSegundo extends Velocidad {

    /**
     * Factor de conversión de m/s a km/h.
     */
    public static double F_CONV_A_KmxH = 3.6;

    /**
     * Factor de conversión de m/s a ft/s.
     */
    public static double F_CONV_A_FtxS = 3.28084;

    /**
     * Metros.
     */
    private Metro metros;

    /**
     * Segundos.
     */
    private Segundo segundos;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public MetroXSegundo(double cifra) {
        super(cifra, "m/s");
        setSistema(Internacional.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Constructor con parámetros que realiza el calculo de la velocidad
     * en base a instancias de metros y segundos pasadas como parámetros.
     * @param metros Longitud en metros.
     * @param segundos Tiempo en segundos.
     */
    public MetroXSegundo(Metro metros, Segundo segundos) {
        this(metros.getCifra() / segundos.getCifra());
        this.metros = metros;
        this.segundos = segundos;
    }

    /**
     * Constructor con parámetros que realiza el cálculo de la velocidad
     * en base a los valores de la longitud (en metros) y el tiempo
     * (en segundos) pasados como parámetros.
     * @param metros Longitud en metros.
     * @param segundos Tiempo en segundos.
     */
    public MetroXSegundo(double metros, double segundos) {
        this(metros / segundos);
        this.metros = new Metro(metros);
        this.segundos = new Segundo(segundos, getSistema());
    }

    public Metro getMetros() {
        return metros;
    }

    public void setMetros(Metro metros) {
        this.metros = metros;
        this.setCifra(this.metros.getCifra() / this.segundos.getCifra());
    }

    public void setMetros(double metros) {
        this.metros.setCifra(metros);
        this.setCifra(metros / this.segundos.getCifra());
    }

    public Segundo getSegundos() {
        return segundos;
    }

    public void setSegundos(Segundo segundos) {
        this.segundos = segundos;
        this.setCifra(this.metros.getCifra() / this.segundos.getCifra());
    }

    public void setSegundos(double segundos) {
        this.segundos.setCifra(segundos);
        this.setCifra(this.metros.getCifra() / this.segundos.getCifra());
    }

    public KilometroXHora convertirAKmxH() {
        return new KilometroXHora(getCifra() * MetroXSegundo.F_CONV_A_KmxH);
    }

    @Override
    public MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException {
        if (!magnitudCompatible(m))
            throw new IncompatibleMagnitudeException("No se pueden realizar operaciones entre magnitudes físicas diferentes.");
        /**
         * El método convertirInglesAInter() en unidades de velocidad siempre hace
         * la conversión a m/s, aunque la unidad que recibe el mensaje sea o no
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
         * El método convertirInglesAInter() en unidades de velocidad siempre hace
         * la conversión a m/s, aunque la unidad que recibe el mensaje sea o no
         * del mismo sistema.
         */
        if (!compararInstancia(m))
            m = m.convertirInglesAInter();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof Pie;
    }

    /**
     * @return La unidad en ft/s.
     */
    public MagnitudFisica convertirInterAIngles() {
        return new PieXSegundo(getCifra() * MetroXSegundo.F_CONV_A_FtxS);
    }

    /**
     * @return La unidad de medida en m/s.
     */
    public MagnitudFisica convertirInglesAInter() {
        return this;
    }

}