package sondaEspacial.unidades.internacional.velocidad;

import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.magnitudes.derivadas.Velocidad;
import sondaEspacial.sistemas.internacional.Internacional;
import sondaEspacial.unidades.internacional.longitud.Kilometro;
import sondaEspacial.unidades.tiempo.Hora;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Unidad de medida del Sistema Inglés que representa la Velocidad.
 * @author Carlos Alejandro Hernández Mejía
 */
public class KilometroXHora extends Velocidad {

    /**
     * Factor de conversión de km/h a m/s.
     */
    public static double F_CONV_A_MxS = 0.277778;

    /**
     * Kilómetros.
     */
    private Kilometro kilometros;

    /**
     * Horas.
     */
    private Hora horas;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa esta unidad.
     */
    public KilometroXHora(double cifra) {
        super(cifra, "km/h");
        setSistema(Internacional.getInstance());
        getSistema().agregarUnidad(this);
    }

    /**
     * Constructor con parámetros que realiza el calculo de la velocidad
     * en base a instancias de kilómetros y horas pasadas como parámetros.
     * @param kilometros Longitud en kilómetros.
     * @param horas Tiempo en horas.
     */
    public KilometroXHora(Kilometro kilometros, Hora horas) {
        this(kilometros.getCifra() / horas.getCifra());
        this.kilometros = kilometros;
        this.horas = horas;
    }

    /**
     * Constructor con parámetros que realiza el cálculo de la velocidad
     * en base a los valores de la longitud (en kilómetros) y el tiempo
     * (en horas) pasados como parámetros.
     * @param kilometros Longitud en kilómetros.
     * @param horas Tiempo en horas.
     */
    public KilometroXHora(double kilometros, double horas) {
        this(kilometros / horas);
        this.kilometros = new Kilometro(kilometros);
        this.horas = new Hora(horas, getSistema());
    }

    public Kilometro getKilometros() {
        return kilometros;
    }

    public void setKilometros(Kilometro kilometros) {
        this.kilometros = kilometros;
        this.setCifra(this.kilometros.getCifra() / this.horas.getCifra());
    }

    public void setKilometros(double kilometros) {
        this.kilometros.setCifra(kilometros);
        this.setCifra(kilometros / this.horas.getCifra());
    }

    public Hora getHoras() {
        return horas;
    }

    public void setHoras(Hora horas) {
        this.horas = horas;
        this.setCifra(this.kilometros.getCifra() / this.horas.getCifra());
    }

    public void setHoras(double horas) {
        this.horas.setCifra(horas);
        this.setCifra(this.kilometros.getCifra() / this.horas.getCifra());
    }

    /**
     * Convierte km/h a m/s.
     * @return Su equivalente en m/s.
     */
    public MetroXSegundo convertirAMxSeg() {
        return new MetroXSegundo(getCifra() * KilometroXHora.F_CONV_A_MxS);
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
            m = ((MetroXSegundo) m.convertirInglesAInter()).convertirAKmxH();
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
            m = ((MetroXSegundo) m.convertirInglesAInter()).convertirAKmxH();
        setCifra(getCifra() + m.getCifra());
        return this;
    }

    @Override
    public boolean compararInstancia(MagnitudFisica m) {
        return m instanceof KilometroXHora;
    }

    /**
     * @return La unidad de medida en ft/s.
     */
    public MagnitudFisica convertirInterAIngles() {
        return convertirAMxSeg().convertirInterAIngles();
    }

    /**
     * @return La unidad de medida en m/s.
     */
    public MagnitudFisica convertirInglesAInter() {
        return convertirAMxSeg();
    }

}