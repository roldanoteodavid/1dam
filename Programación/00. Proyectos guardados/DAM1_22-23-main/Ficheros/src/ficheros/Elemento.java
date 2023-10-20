/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.Serializable;

/**
 *
 * @author gema
 */
public class Elemento implements Comparable<Elemento>,Serializable{
    private int id;
    private int nivel;
    private String categoriaString;
    private String adivinarString;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCategoriaString() {
        return categoriaString;
    }

    public void setCategoriaString(String categoriaString) {
        this.categoriaString = categoriaString;
    }

    public String getAdivinarString() {
        return adivinarString;
    }

    public void setAdivinarString(String adivinarString) {
        this.adivinarString = adivinarString;
    }

    public Elemento(int id, int nivel, String categoriaString, String adivinarString) {
        this.id = id;
        this.nivel = nivel;
        this.categoriaString = categoriaString;
        this.adivinarString = adivinarString;
    }

    @Override
    public String toString() {
        return "Elemento{" + "id=" + id + ", nivel=" + nivel + ", categoriaString=" + categoriaString + ", adivinarString=" + adivinarString + '}';
    }
    public String toStringFichero() {
        return id+";"+ nivel+";"+categoriaString+";"+adivinarString;
    }

    
    @Override
    public int compareTo(Elemento o) {
        //return this.adivinarString.compareTo(o.adivinarString);
        return Integer.compare(id, o.id);
    }
    
}
