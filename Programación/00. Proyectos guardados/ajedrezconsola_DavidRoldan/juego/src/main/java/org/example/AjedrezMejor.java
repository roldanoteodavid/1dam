package org.example;

import org.example.common.Constantes;

import java.util.Scanner;

public class AjedrezMejor {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tablero tablero = new Tablero();
        Juego miJuego = new Juego();
        boolean fin = false;
        do {
            tablero.pintarTablero();
            Posicion posorigen = null;
            Movimiento mov = null;
            if (miJuego.getTurno().equals("B")) {
                if (tablero.jaqueBlanco(miJuego)) {
                    System.out.println(Constantes.JAQUE_BLANCO);
                }
                System.out.println(Constantes.TURNO_DE_BLANCAS);
            } else {
                if (tablero.jaqueNegro(miJuego))
                    System.out.println(Constantes.JAQUE_NEGRO);
                System.out.println(Constantes.TURNO_DE_NEGRAS);
            }
            do {
                System.out.println(Constantes.INTRODUZCA_LA_PIEZA_QUE_DESEA_MOVER);
                String pieza = teclado.nextLine();
                posorigen = miJuego.movimientosValidos(tablero, pieza, miJuego);
            } while (posorigen == null);
            do {
                System.out.println(Constantes.INTRODUZCA_LA_POSICIÓN_A_LA_QUE_DESEA_MOVER);
                String posfinal = teclado.nextLine();
                mov = miJuego.validarPosFinal(tablero, posfinal, posorigen, miJuego);
            } while (mov == null);
            tablero.mover(mov, miJuego);
            if (tablero.jaqueBlanco(miJuego)) {
                if (tablero.jaqueMateBlanco(miJuego)) {
                    tablero.pintarTablero();
                    System.out.println(Constantes.JAQUE_MATE_BLANCO);
                    fin = true;
                }
            }
            if (tablero.jaqueNegro(miJuego)) {
                if (tablero.jaqueMateNegro(miJuego)) {
                    tablero.pintarTablero();
                    System.out.println(Constantes.JAQUE_MATE_NEGRO);
                    fin = true;
                }
            }
            if (tablero.finJuego(miJuego)) {
                fin = true;
            }
        } while (!fin);
        if (tablero.reyAhogadoBlanco(miJuego)||tablero.reyAhogadoNegro(miJuego)) {
            System.out.println(Constantes.REY_AHOGADO_TABLAS);
        }
    }
}
