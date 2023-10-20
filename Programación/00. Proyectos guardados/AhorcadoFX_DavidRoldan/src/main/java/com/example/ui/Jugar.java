package com.example.ui;

import com.example.common.CategoriaException;
import com.example.common.Constantes;
import com.example.dao.DaoElementosFicheros;
import com.example.domain.*;
import com.example.service.GestionElementos;

import java.util.Scanner;

public class Jugar {

    public static Juego juego() {
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
                } catch (CatLevException | CategoriaException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                juego = DaoElementosFicheros.cargarFicheroBinario();
                if (juego==null){
                    System.out.println("No se puede recuperar ninguna partida anterior");
                    version = 0;
                }else {
                    valido = true;
                }
            }
        } while (!valido);
        //System.out.println(juego.getaAdivinar());
        return juego;
    }

    public static Juego constructorJuego() throws CatLevException, CategoriaException {
        Scanner teclado = new Scanner(System.in);
        GestionElementos gestionElementos = new GestionElementos(DaoElementosFicheros.cargarFichero());
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
        return new Juego(gestionElementos.getElementoNivelCategoria(dificultad,categoria), jugador);
    }
}