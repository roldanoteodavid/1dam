package org.example.domain;

import lombok.Data;
import org.example.common.Habilidades;

import java.io.Serializable;
import java.util.List;

public class Mago extends Campeon implements Serializable {

    private boolean stunt;


    public Mago(int identificador, String nombre, double ataque, int skins, List<String> habilidades, int altura, boolean stunt) {
        super(identificador, nombre, ataque, skins, habilidades, altura);
        this.stunt = stunt;
    }

    public boolean getStunt() {
        return stunt;
    }

    public void setStunt(boolean stunt) {
        this.stunt = stunt;
    }

    @Override
    public double ataqueReal() {
        return (ataque * 1.05);
    }

    public String toStringFichero() {
        return super.toStringFichero() +
                ";" + stunt;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", stunt=" + stunt +
                '}';
    }
}
