package com.example.domain;

import com.example.common.CategoriaException;
import com.example.common.Constantes;
import com.example.dao.DaoElementosFicheros;
import com.example.dao.Elementos;
import com.example.service.GestionElementos;

import java.io.Serializable;
import java.util.Arrays;

public class Juego implements Serializable{
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    private Elemento aAdivinar; //o el String directamente
    private Jugador jugador;
    private int fallos;
    private char[] adivinadas;

    public Juego(Elemento aAdivinar, Jugador jugador){
        this.aAdivinar = aAdivinar;
        this.jugador = jugador;
        this.fallos = 0;
        adivinadas = aAdivinar.getIncognita().toCharArray();
    }

    public Juego(Jugador jugador, int dificultad, String categoria) throws CatLevException, CategoriaException {
        categoriaLevOk(categoria, dificultad);
        GestionElementos gestionElementos = new GestionElementos(DaoElementosFicheros.cargarFichero());
        this.aAdivinar = gestionElementos.getElementoNivelCategoria(dificultad, categoria);
        this.jugador = jugador;
        this.fallos = 0;
        adivinadas = aAdivinar.getIncognita().toCharArray();
    }

    public Elemento getaAdivinar() {
        return aAdivinar;
    }

    public void setaAdivinar(Elemento aAdivinar) {
        this.aAdivinar = aAdivinar;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos() {
        this.fallos = fallos + 1;
    }

    public void masfallos() {
        this.fallos = fallos + 1;
    }

    public void pintarTablero() {
        if (fallos == 1) {
            System.out.println(Constantes.FALLO1);
        }else if (fallos == 2) {
            System.out.println(Constantes.FALLO2);
        }else if (fallos == 3) {
            System.out.println(Constantes.FALLO3);
        }else if (fallos == 4) {
            System.out.println(Constantes.FALLO4);
        }else if (fallos == 5) {
            System.out.println(Constantes.FALLO5);
        }else if (fallos == 6) {
            System.out.println(Constantes.FALLO6);
        }else if (fallos == 7) {
            System.out.println(Constantes.FALLO7);
        }
    }

    public String jugada(char letra) {
        String texto = null;
        if (jugador.anyadirletra(letra)) {
            if (!comprobar(letra)){
                texto = Constantes.INCORRECTA;
            }
            //pintarTablero();
            //pintarAdivinadas();
            //pintarIntentosFallidos();
        } else {
            texto = Constantes.LA_LETRA_YA_ESTÁ_DICHA;
        }
        return texto;
    }

    public boolean comprobar(char letra) {
        boolean fin = false;
        for (int i = 0; i < adivinadas.length; i++) {
            if (adivinadas[i] == letra || adivinadas[i] == (letra - 32) || adivinadas[i] == (letra + 32)) {
                fin = true;
                //System.out.println(Constantes.CORRECTA);
            }
        }
        if (!fin)
            setFallos();
        return fin;
    }

    public String pintarAdivinadas() {
        StringBuilder sb = new StringBuilder();
        char[] imprimir = new char[aAdivinar.getIncognita().length()];
        for (int i = 0; i < adivinadas.length; i++) {
            for (int j = 0; j < jugador.getIntentos().size(); j++) {
                if (adivinadas[i] == jugador.getIntentos().get(j) || adivinadas[i] == jugador.getIntentos().get(j) + 32 || adivinadas[i] == jugador.getIntentos().get(j) - 32) {
                    imprimir[i] = adivinadas[i];
                    sb.append(jugador.getIntentos().get(j)).append(" ");
                }
            }
            if (imprimir[i] == 0) {
                imprimir[i] = '_';
                sb.append(" _ ");
            }
        }
        //System.out.println(Constantes.PALABRA_A_ADIVINAR + Arrays.toString(imprimir));
        //return Arrays.toString(imprimir);
        return sb.toString();
    }

    public String pintarIntentosFallidos() {
        StringBuilder sb = new StringBuilder();
        if (getFallos() != 0) {
            for (int i = 0; i < jugador.getIntentos().size(); i++) {
                boolean esta = false;
                for (int j = 0; j < adivinadas.length; j++) {
                    if (jugador.getIntentos().get(i) == adivinadas[j] || jugador.getIntentos().get(i) == adivinadas[j] + 32 || jugador.getIntentos().get(i) == adivinadas[j] - 32) {
                        esta = true;
                    }
                }
                if (!esta) {
                    sb.append(jugador.getIntentos().get(i) + " ");
                }
            }
        }
        return sb.toString();
    }

    public int fin() {
        int fin = 0;
        if (fallos == 7) {
            fin = 1;
        } else {
            char[] comprobar = new char[aAdivinar.getIncognita().length()];
            for (int i = 0; i < adivinadas.length; i++) {
                for (int j = 0; j < jugador.getIntentos().size(); j++) {
                    if (adivinadas[i] == jugador.getIntentos().get(j) || adivinadas[i] == jugador.getIntentos().get(j) + 32 || adivinadas[i] == jugador.getIntentos().get(j) - 32) {
                        comprobar[i] = adivinadas[i];
                    }
                }
            }
            fin = 2;
            for (int i = 0; i < comprobar.length; i++) {
                if (comprobar[i] == 0) {
                    fin = 0;
                }
            }
        }
        return fin;
    }

    public static void categoriaLevOk(String categoria, int dificultad) throws CatLevException {
        boolean esta = false;
        Elementos elementos = new Elementos();
        if (elementos.getElementoDificultadCategoria(dificultad, categoria) != null) {
            esta = true;
        }
        if (!esta)
            throw new CatLevException(categoria, dificultad);

    }
}
