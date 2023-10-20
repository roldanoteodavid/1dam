package org.example;

import java.util.Scanner;

public class OperacionesArray2Tester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca cuantos número quiere que tenga el array.");
        int tamanyo = teclado.nextInt();
        int [] numeros = new int[tamanyo];
        OperacionesArray2.cargar(numeros);
        System.out.println(OperacionesArray2.imprimir(numeros));
        System.out.println("La media es "+OperacionesArray2.media(numeros));
        System.out.println(OperacionesArray2.ordenar(numeros));
        System.out.println(OperacionesArray2.invertir(numeros));
    }
}
