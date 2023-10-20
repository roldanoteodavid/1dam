package org.example.ui;

import org.example.common.Constantes;

import java.util.Scanner;

public class GestorJuego {

    public static void iniciar() {
        Scanner teclado = new Scanner(System.in);
        boolean fin = false;
        do {
            System.out.println(Constantes.INTRODUZCA_1_SI_DESEA_ADMINISTRAR_2_PARA_JUGAR_O_3_PARA_SALIR);
            switch (teclado.nextInt()) {
                case 1 -> GestionDiccionario.gestion();
                case 2 -> Jugar.juego();
                case 3 -> fin = true;
                default -> System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
            }
        } while (!fin);
    }
}
