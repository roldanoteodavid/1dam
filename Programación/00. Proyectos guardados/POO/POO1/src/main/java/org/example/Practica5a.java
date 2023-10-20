package org.example;

import java.util.Scanner;

public class Practica5a {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca las coordenadas del punto a");
        Punto a = new Punto(teclado.nextDouble(), teclado.nextDouble());
        System.out.println("Introduzca las coordenadas del punto b");
        Punto b = new Punto(teclado.nextDouble(), teclado.nextDouble());
        System.out.println("Introduzca la coordenada x del centro");
        double xc = teclado.nextDouble();
        System.out.println("Introduzca la coordenada y del centro");
        double yc = teclado.nextDouble();
        System.out.println("Introduzca el radio");
        double radio = teclado.nextDouble();
        Circulo cr = new Circulo(radio, xc, yc);
        System.out.println("La distancia del círculo al punto a es "+cr.calcularDistanciaDesde(a));
        System.out.println("El perímetro del círculo es "+cr.calcularPerimetro());
        System.out.println("El área del círculo es "+cr.calcularArea());
        System.out.println("Introduzca las coordenada x del vértice a");
        double ax = teclado.nextDouble();
        System.out.println("Introduzca las coordenada y del vértice a");
        double ay = teclado.nextDouble();
        System.out.println("Introduzca las coordenada x del vértice b");
        double bx = teclado.nextDouble();
        System.out.println("Introduzca las coordenada y del vértice b");
        double by = teclado.nextDouble();
        System.out.println("Introduzca las coordenada x del vértice c");
        double cx = teclado.nextDouble();
        System.out.println("Introduzca las coordenada y del vértice c");
        double cy = teclado.nextDouble();
        Triangulo tr = new Triangulo(ax, ay, bx, by, cx, cy);
        System.out.println("La distancia desde el punto b al triángulo es "+tr.calcularDistanciaDesde(b));
        System.out.println("El área del triángulo es "+tr.calcularArea());
        System.out.println("El perímetro del triángulo es "+tr.calcularPerimetro());
    }
}
