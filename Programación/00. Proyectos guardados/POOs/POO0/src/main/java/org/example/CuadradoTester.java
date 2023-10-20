package org.example;

import java.util.Scanner;

public class CuadradoTester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Cuadrado cd = new Cuadrado();
        System.out.println("Introduzca el lado del cuadrado");
        int lado = teclado.nextInt();
        cd.setLado(lado);
        System.out.println("El perímetro del cuadrado de lado "+lado+" es "+cd.Perimetro());
        System.out.println("El área del cuadrado de lado "+lado+" es "+cd.Area());
    }
}
