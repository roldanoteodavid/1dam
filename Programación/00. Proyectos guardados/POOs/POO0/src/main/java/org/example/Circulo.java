package org.example;

public class Circulo {
    private int radio;

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public double Perimetro() {
        double perimetro;
        perimetro = 2 * radio * Math.PI;
        return perimetro;
    }

    public double Area(){
        double area;
        area = Math.PI * Math.pow(radio,2);
        return area;
    }
}
