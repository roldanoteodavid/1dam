package org.example;

public class Triangulo {
    private Punto a;
    private Punto b;
    private Punto c;

    public Triangulo(Punto a, Punto b, Punto c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public Triangulo(){
        a = new Punto();
        b = new Punto();
        c = new Punto();
    }

    public Triangulo(double ax, double ay, double bx, double by, double cx, double cy){
        a = new Punto(ax, ay);
        b = new Punto(bx, by);
        c = new Punto(cx, cy);
    }

    public Punto getA() {
        return a;
    }

    public Punto getB() {
        return b;
    }

    public Punto getC() {
        return c;
    }

    public double calcularDistanciaDesde(Punto v){
        return a.calcularDistanciaDesde(v);
    }

    public double calcularArea (){
        double area;
        double ladoab = a.calcularDistanciaDesde(b);
        double ladoac = a.calcularDistanciaDesde(c);
        double ladobc = b.calcularDistanciaDesde(c);
        double semi = (ladoab + ladoac + ladobc)/2;
        area = Math.sqrt(semi*(semi-ladoab)*(semi-ladoac)*(semi-ladobc));
        return area;
    }

    public double calcularPerimetro(){
        double perimetro;
        double ladoab = a.calcularDistanciaDesde(b);
        double ladoac = a.calcularDistanciaDesde(c);
        double ladobc = b.calcularDistanciaDesde(c);
        perimetro = (ladoab + ladoac + ladobc);
        return perimetro;
    }
}
