package org.example;

import java.util.Scanner;

public class CirculoTester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Circulo cr = new Circulo();
        System.out.println("Introduzca el radio del círculo.");
        int radio = teclado.nextInt();
        cr.setRadio(radio);
        System.out.println("El perímetro del círculo de radio "+radio+" es "+cr.Perimetro());
        System.out.println("El área del círculo de radio "+radio+" es "+cr.Area());
    }
}
