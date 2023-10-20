package com.example.domain;

import com.example.common.CategoriaException;
import com.example.common.Comprobacion;
import com.example.dao.Elementos;
import com.example.dao.IdException;

import java.io.Serializable;

public class Elemento implements Comparable<Elemento>, Serializable {
    private int id;
    private int level;
    private String incognita;
    private String categoria;
    private static int autonumerico = 1;

    /**
     * @param id        identicador único de cada elemento, el String incognita puede tener espacios, mayúsculas, mínúsculas que no lo hagan único
     * @param level     indica la dificultad que le asignamos a la incognita a adivinar por el tamaño de caracteres por ejemplo
     * @param incognita palabra a adivinar
     * @param categoria String que debe se un elemento de Categoria, si no lo es se lanzará CategoriaEx y así no se creará el objeto
     * @throws CategoriaException
     */
    public Elemento(int id, int level, String incognita, String categoria) throws CategoriaException {
        //Elementos.idOk(id);
        this.id = id;
        this.level = level;
        this.incognita = incognita;
        Comprobacion.categoriaOk(categoria);
        this.categoria = categoria;
    }

    public Elemento(String incognita, String categoria) throws CategoriaException {
        this.id = autonumerico;
        autonumerico++;
        this.level = asignarNivel(incognita);
        this.incognita = incognita;
        Comprobacion.categoriaOk(categoria);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) throws CategoriaException {
        Comprobacion.categoriaOk(categoria);
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getIncognita() {
        return incognita;
    }

    public void setIncognita(String incognita) {
        this.incognita = incognita;
    }

    public static int asignarNivel(String incognita) {
        int nivel = 0;
        if (incognita.length() >= 7) {
            nivel = 1;
        }
        return nivel;
    }


    public String toStringFile() {
        return id + ";" + level +
                ";" + incognita +
                ";" + categoria;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "id=" + id +
                ", level=" + level +
                ", categoria=" + categoria +
                ", incognita='" + incognita + '\'' +
                '}';
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Elemento o) {
        return Integer.compare(id, o.id);
    }
}
