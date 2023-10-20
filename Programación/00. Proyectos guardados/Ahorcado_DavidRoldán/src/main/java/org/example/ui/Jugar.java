package org.example.ui;

import org.example.common.Constantes;
import org.example.domain.*;

import java.util.Scanner;

public class Jugar {

    public static void juego() {
        Scanner teclado = new Scanner(System.in);
        Juego juego = null;
        boolean valida = false;
        int version = 0;
        do {
            System.out.println(Constantes.INTRODUZCA_0_PARA_EMPEZAR_UNA_NUEVA_PARTIDA_O_1_PARA_RECUPERAR_LA_ANTERIOR);
            version = teclado.nextInt();
            teclado.nextLine();
            if (version == 1 || version == 0) {
                valida = true;
            }
        } while (!valida);
        boolean valido = false;
        do {
            if (version == 0) {
                try {
                    juego = constructorJuego();
                    valido = true;
                } catch (CatLevException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                //fichero binario comprobar y cargar
                version = 0;//borrar
            }
        } while (!valido);
        System.out.println(juego.getaAdivinar());
        juego.pintarTablero();
        juego.pintarAdivinadas();
        do {
            System.out.println(Constantes.INTRODUZCA_LETRA);
            juego.jugada(teclado.next().charAt(0));
        } while (juego.fin()==0);
        if (juego.fin()==1){
            System.out.println(Constantes.HAS_PERDIDO_HAS_GASTADO_TODOS_LOS_INTENTOS);
        } else if (juego.fin()==2) {
            System.out.println(Constantes.ENHORABUENA_HAS_GANADO);
        }
    }

    public static Juego constructorJuego() throws CatLevException {
        Scanner teclado = new Scanner(System.in);
        boolean valida = false;
        System.out.println(Constantes.INTRODUZCA_SU_NOMBRE);
        Jugador jugador = new Jugador(teclado.nextLine());
        int dificultad = 0;
        do {
            System.out.println(Constantes.INTRODUZCA_DIFICULTAD_0_O_1);
            dificultad = teclado.nextInt();
            teclado.nextLine();
            if (dificultad == 1 || dificultad == 0) {
                valida = true;
            }
        } while (!valida);
        System.out.println(Constantes.INTRODUZCA_CATEGORÍA);
        String categoria = teclado.nextLine();
        return new Juego(jugador, dificultad, categoria);
    }
}