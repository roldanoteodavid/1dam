package org.example;

public class Triangulo {
    private int lado1;
    private int lado2;
    private int lado3;

    public Triangulo() {
        lado1 = 3;
        lado2 = 4;
        lado3 = 5;
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public void setLado3(int lado3) {
        this.lado3 = lado3;
    }

    public int getLado() {
        return lado1;
    }

    public void setLado(int lado1) {
        this.lado1 = lado1;
    }

    public int Perimetro(){
        int perimetro;
        perimetro = lado1 + lado2 + lado3;
        return perimetro;
    }

    public double Area(){
        double area;
        int semi = (lado1 + lado2 + lado3)/2;
        area = Math.sqrt(semi*(semi-lado1)*(semi-lado2)*(semi-lado3));
        return area;
    }
}
