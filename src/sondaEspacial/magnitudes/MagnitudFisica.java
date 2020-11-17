package sondaEspacial.magnitudes;

import sondaEspacial.unidades.UnidadDeMedida;
import sondaEspacial.utils.interfaces.Conversor;
import sondaEspacial.utils.exceptions.IncompatibleMagnitudeException;

/**
 * Representa una generalización de una unidad de medida.
 * @author Carlos Alejandro Hernández Mejía
 */
public abstract class MagnitudFisica extends UnidadDeMedida implements Conversor, Comparable<MagnitudFisica> {

    /**
     * Cifra que representa la magnitud física.
     */
    private double cifra;

    /**
     * Abreviatura que acompaña la unidad de medida.
     */
    private String abreviatura;

    /**
     * Constructor con parámetros.
     * @param cifra Cifra que representa la magnitud física.
     * @param abrev Abreviatura que acompaña la unidad de medida.
     */
    public MagnitudFisica(double cifra, String abrev) {
        this.cifra = cifra;
        this.abreviatura = abrev;
        getSistema().agregarUnidad(this);
    }

    public double getCifra() {
        return cifra;
    }

    public void setCifra(double cifra) {
        this.cifra = cifra;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * @param obj Objeto a comparar.
     * @return El resultado de la comparación.
     */
    public int compareTo(MagnitudFisica obj) {
        return (int) (getCifra() - obj.getCifra());
    }

    /**
     * Realiza la resta entre la magnitud pasada como parámetros y
     * la magnitud que recibe el mensaje.
     * @param m Magnitud a restar.
     * @return El resultado de la operación.
     * @throws IncompatibleMagnitudeException Se lanza esta excepción cuando se intenta
     * realizar operaciones con magnitudes físicas diferentes.
     */
    public abstract MagnitudFisica resta(MagnitudFisica m) throws IncompatibleMagnitudeException;

    /**
     * Realiza la suma entre la magnitud pasada como parámetros y
     * la magnitud que recibe el mensaje.
     * @param m Magnitud a sumar.
     * @return El resultado de la operación.
     * @throws IncompatibleMagnitudeException Se lanza esta excepción cuando se intenta
     * realizar operaciones con magnitudes físicas diferentes.
     */
    public abstract MagnitudFisica suma(MagnitudFisica m) throws IncompatibleMagnitudeException;

    /**
     * Verifica que 2 magnitudes sean instancias de la misma clase.
     * @param m Magnitud a comparar.
     * @return El resultado de la comparación.
     */
    public abstract boolean compararInstancia(MagnitudFisica m);

    /**
     * Verifica que 2 magnitudes representen la misma magnitud física.
     * @param m Magnitud a comparar.
     * @return true si las unidades representan la misma magnitud, false
     * en caso contrario.
     */
    public abstract boolean magnitudCompatible(MagnitudFisica m);

    @Override
    public String toString() {
        return String.format("%.4f", cifra) + " " + abreviatura;
    }
}