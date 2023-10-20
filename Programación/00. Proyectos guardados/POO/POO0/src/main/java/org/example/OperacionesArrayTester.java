package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class OperacionesArrayTester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        OperacionesArray op = new OperacionesArray();
        System.out.println("Introduzca cuantos número quiere que tenga el array.");
        int tamanyo = teclado.nextInt();
        op.OperacionesArrays(tamanyo);
        op.cargar();
        System.out.println(op);
        System.out.println("La media es "+op.media());
        System.out.println(op.ordenar());
        System.out.println(op.invertir());
    }
}