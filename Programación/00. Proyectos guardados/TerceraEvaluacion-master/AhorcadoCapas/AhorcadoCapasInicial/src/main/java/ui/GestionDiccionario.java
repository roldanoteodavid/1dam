package ui;

import common.Constantes;

import java.util.Scanner;

/**
 * Clase con métodos de administración para consola
 */
public class GestionDiccionario {
    private static final String pass = "2223";
    public static int mostrarMenu(){
        Scanner lector = new Scanner(System.in);
        System.out.println(Constantes.MENU+"\n"+Constantes.OPCION1+"\n"+Constantes.OPCION2+"\n"+Constantes.OPCION3+"\n"+Constantes.OPCION4);
        int num = lector.nextInt(); //tratar la excepción para evitar que se pare el programa si no introduce un número
        return num;
    }
}
