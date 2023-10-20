package org.example.domain;

import lombok.Data;
import org.example.common.Habilidades;

import java.io.Serializable;
import java.util.List;


public class Asesino extends Campeon implements Serializable {

    private double probabilidadBurst;

    public Asesino(int identificador, String nombre, double ataque, int skins, List<String> habilidades, int altura, double probabilidadBurst) {
        super(identificador, nombre, ataque, skins, habilidades, altura);
        this.probabilidadBurst = probabilidadBurst;
    }

    public double getProbabilidadBurst() {
        return probabilidadBurst;
    }

    public void setProbabilidadBurst(double probabilidadBurst) {
        this.probabilidadBurst = probabilidadBurst;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", probabilidadBurst=" + probabilidadBurst +
                '}';
    }

    public String toStringFichero() {
        return super.toStringFichero() +
                ";" + probabilidadBurst;
    }

    @Override
    public double ataqueReal() {
        return (ataque * 1.15);
    }


}
