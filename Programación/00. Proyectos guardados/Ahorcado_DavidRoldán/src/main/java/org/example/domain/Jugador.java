package org.example.domain;

import java.util.ArrayList;

public class Jugador {
    //opcional nombre,
    private String nombre;
    private ArrayList<Character> intentos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.intentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Character> getIntentos() {
        return intentos;
    }

    public void setIntentos(ArrayList<Character> intentos) {
        this.intentos = intentos;
    }

    public boolean anyadirletra(char letra) {
        boolean dicha = false;
        boolean anyadida = false;
        for (int i = 0; i < intentos.size(); i++) {
            if (intentos.get(i)==letra){
                dicha = true;
            }
        }
        if (!dicha){
            intentos.add(letra);
            anyadida = true;
        }
        return anyadida;
    }

}
