package sondaEspacial.sistemas;

import sondaEspacial.unidades.UnidadDeMedida;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Alejandro Hernández Mejía
 */
public abstract class Sistema {

    /**
     * Nombre del sistema.
     */
    private String nombre;

    /**
     * Unidades de medida que pertenecen al sistema.
     */
    private List<UnidadDeMedida> unidades;

    /**
     * Constructor.
     * @param nombre del sistema.
     */
    public Sistema(String nombre) {
        this.nombre = nombre;
        unidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<UnidadDeMedida> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadDeMedida> unidades) {
        this.unidades = unidades;
    }

    /**
     * Imprime las unidades de medida que pertenecen al sistema.
     */
    public void listarUnidades() {
        for (UnidadDeMedida u: unidades)
            System.out.println(u.toString());
    }

    /**
     * Verifica que la instancia pasada por parámetros sea del mismo tipo
     * que la instancia que recibe el mensaje.
     * @param s Sistema a comparar
     * @return true si son instancias de la misma clase, false en caso contrario.
     */
    public abstract boolean compararInstancia(Sistema s);

    /**
     * Agrega una unidad de medida al sistema.
     * @param u Unidad de medida a añadir.
     */
    public void agregarUnidad(UnidadDeMedida u) {
        if (compararInstancia(u.getSistema()))
            this.unidades.add(u);
    }

    /**
     * Remueve una unidad de medida del sistema.
     * @param u Unidad de medida a remover.
     */
    public void eliminarUnidad(UnidadDeMedida u) {
        if (compararInstancia(u.getSistema()))
            this.unidades.remove(u);
    }

    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Verifica si 2 sistemas son iguales, comparando el nombre del sistema.
     * @param obj Objeto a comparar.
     * @return true si los nombres son iguales, false en caso contrario.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Sistema)
            return nombre.equals(((Sistema) obj).getNombre());
        return false;
    }
}