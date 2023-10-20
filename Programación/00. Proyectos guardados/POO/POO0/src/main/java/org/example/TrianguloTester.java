package org.example;

import java.util.Scanner;

public class TrianguloTester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Triangulo tr = new Triangulo();
        System.out.println("Introduce el primer lado");
        int lado1 = teclado.nextInt();
        tr.setLado1(lado1);
        System.out.println("Introduce el segundo lado");
        int lado2 = teclado.nextInt();
        tr.setLado2(lado2);
        System.out.println("Introduce el tercer lado");
        int lado3 = teclado.nextInt();
        tr.setLado3(lado3);
        System.out.println("El perímetro del triángulo es "+tr.Perimetro());
        System.out.println("El área del area es "+tr.Area());
    }
}
