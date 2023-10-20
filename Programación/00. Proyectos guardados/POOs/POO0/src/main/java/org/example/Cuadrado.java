package org.example;

public class Cuadrado {
    private int lado;

    public Cuadrado() {
        lado = 1;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
    public double Perimetro() {
        double perimetro;
        perimetro = lado * 4;
        return perimetro;
    }

    public double Area(){
        double area;
        area = Math.pow(lado,2);
        return area;
    }
}
