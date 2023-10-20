package org.example.domain;

import org.example.common.Constantes;
import org.example.dao.Elementos;

import java.util.Arrays;

public class Juego {
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    private Elemento aAdivinar; //o el String directamente
    private Jugador jugador;
    private int fallos;
    private char[] adivinadas;

    public Juego(Elemento aAdivinar, Jugador jugador) {
        this.aAdivinar = aAdivinar;
        this.jugador = jugador;
        this.fallos = 0;
    }

    public Juego(Jugador jugador, int dificultad, String categoria) throws CatLevException {
        categoriaLevOk(categoria, dificultad);
        Elementos elementos = new Elementos();
        this.aAdivinar = elementos.getElementoDificultadCategoria(dificultad, categoria);
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
        }
        if (fallos == 2) {
            System.out.println(Constantes.FALLO2);
        }
        if (fallos == 3) {
            System.out.println(Constantes.FALLO3);
        }
        if (fallos == 4) {
            System.out.println(Constantes.FALLO4);
        }
        if (fallos == 5) {
            System.out.println(Constantes.FALLO5);
        }
        if (fallos == 6) {
            System.out.println(Constantes.FALLO6);
        }
        if (fallos == 7) {
            System.out.println(Constantes.FALLO7);
        }
    }

    public void jugada(char letra) {
        if (letra > 64 && letra < 123) {
            if (jugador.anyadirletra(letra)) {
                comprobar(letra);
                pintarTablero();
                pintarAdivinadas();
                pintarIntentosFallidos();
            } else {
                System.out.println(Constantes.LA_LETRA_YA_ESTÁ_DICHA);
            }
        } else {
            System.out.println(Constantes.INTRODUZCA_UN_CARACTER_VÁLIDO);
        }

    }

    public void comprobar(char letra) {
        boolean fin = false;
        for (int i = 0; i < adivinadas.length; i++) {
            if (adivinadas[i] == letra || adivinadas[i] == (letra - 32) || adivinadas[i] == (letra + 32)) {
                fin = true;
                System.out.println(Constantes.CORRECTA);
            }
        }
        if (!fin)
            setFallos();
    }

    public void pintarAdivinadas() {
        char[] imprimir = new char[aAdivinar.getIncognita().length()];
        for (int i = 0; i < adivinadas.length; i++) {
            for (int j = 0; j < jugador.getIntentos().size(); j++) {
                if (adivinadas[i] == jugador.getIntentos().get(j) || adivinadas[i] == jugador.getIntentos().get(j)+32 || adivinadas[i] == jugador.getIntentos().get(j)-32) {
                    imprimir[i] = adivinadas[i];
                }
            }
            if (imprimir[i] == 0) {
                imprimir[i] = '_';
            }
        }
        System.out.println(Constantes.PALABRA_A_ADIVINAR + Arrays.toString(imprimir));
    }

    public void pintarIntentosFallidos() {
        if (getFallos()!=0){
            System.out.println(Constantes.FALLOS);
            for (int i = 0; i < jugador.getIntentos().size(); i++) {
                boolean esta = false;
                for (int j = 0; j < adivinadas.length; j++) {
                    if (jugador.getIntentos().get(i) == adivinadas[j] || jugador.getIntentos().get(i) == adivinadas[j] + 32 || jugador.getIntentos().get(i) == adivinadas[j] - 32) {
                        esta = true;
                    }
                }
                if (!esta) {
                    System.out.print(jugador.getIntentos().get(i)+" ");
                }
            }
            System.out.println();
        }
    }

    public int fin() {
        int fin = 0;
        if (fallos == 7) {
            fin = 1;
        } else {
            char[] comprobar = new char[aAdivinar.getIncognita().length()];
            for (int i = 0; i < adivinadas.length; i++) {
                for (int j = 0; j < jugador.getIntentos().size(); j++) {
                    if (adivinadas[i] == jugador.getIntentos().get(j) || adivinadas[i] == jugador.getIntentos().get(j)+32 || adivinadas[i] == jugador.getIntentos().get(j)-32) {
                        comprobar[i] = adivinadas[i];
                    }
                }
            }
            fin = 2;
            for (int i = 0; i < comprobar.length; i++) {
                if (comprobar[i]==0){
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
