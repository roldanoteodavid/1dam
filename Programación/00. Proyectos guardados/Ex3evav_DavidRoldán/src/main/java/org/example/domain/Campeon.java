package org.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

@Data
public abstract class Campeon implements Serializable {
    protected int identificador;
    protected String nombre;
    protected double ataque;
    protected int skins;
    protected List<String> habilidades;
    protected int altura;

    public Campeon(int identificador, String nombre, double ataque, int skins, List<String> habilidades, int altura) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.ataque = ataque;
        this.skins = skins;
        this.habilidades = habilidades;
        this.altura = altura;
    }

    public abstract double ataqueReal();


    @Override
    public String toString() {
        return "Campeon{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", ataque=" + ataque +
                ", skins=" + skins +
                ", habilidades=" + habilidades +
                ", altura=" + altura;
    }


    public String toStringFichero() {
        return getClass().getSimpleName() +
                ";" + identificador +
                ";" + nombre +
                ";" + ataque +
                ";" + skins +
                ";" + altura;
    }

    public String toStringHabilidadesFichero(){
        StringBuilder habilidadesstr = new StringBuilder();
        habilidadesstr.append(habilidades.get(0));
        for (int i = 1; i < habilidades.size(); i++) {
            habilidadesstr.append("/"+habilidades.get(i));
        }
        return habilidadesstr.toString();
    }
}
