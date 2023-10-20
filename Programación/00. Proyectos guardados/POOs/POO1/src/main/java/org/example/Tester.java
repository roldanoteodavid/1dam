package org.example;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //PUNTO
        Punto a = new Punto();
        System.out.println("Introduzca la coordenada x del punto a");
        double x = teclado.nextDouble();
        a.setX(x);
        System.out.println("Introduzca la coordenada y del punto a");
        double y = teclado.nextDouble();
        a.setY(y);
        System.out.println("Introduzca las coordenadas del punto b");
        Punto b = new Punto(teclado.nextDouble(), teclado.nextDouble());
        System.out.println("La distancia entre los dos punto es "+a.calcularDistanciaDesde(b));
        //CÍRCULO
        System.out.println("Introduzca la coordenada x del centro");
        double xc = teclado.nextDouble();
        System.out.println("Introduzca la coordenada y del centro");
        double yc = teclado.nextDouble();
        System.out.println("Introduzca el radio");
        double radio = teclado.nextDouble();
        Circulo cr = new Circulo(radio, xc, yc);
        System.out.println("Introduzca las coordenadas de otro punto para calcular las distancias");
        Punto c = new Punto(teclado.nextDouble(), teclado.nextDouble());
        System.out.println("La distancia entre los dos punto es "+cr.calcularDistanciaDesde(c));
        System.out.println("El perímetro del círculo es "+cr.calcularPerimetro());
        System.out.println("El área del círculo es "+cr.calcularArea());
        //TRIÁNGULO
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
        System.out.println("Introduzca las coordenadas de otro punto para calcular las distancias");
        Punto v = new Punto(teclado.nextDouble(), teclado.nextDouble());
        System.out.println("La distancia desde el punto introducido al triángulo es "+tr.calcularDistanciaDesde(v));
        System.out.println("El área del triángulo es "+tr.calcularArea());
        System.out.println("El perímetro del triángulo es "+tr.calcularPerimetro());
    }
}
