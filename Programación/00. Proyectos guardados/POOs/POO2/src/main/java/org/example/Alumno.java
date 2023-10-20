package org.example;

public class Alumno {
    private Asignatura a;
    private Asignatura b;
    private Asignatura c;

    public Alumno(Asignatura a, Asignatura b, Asignatura c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Alumno(int x, int y, int z){
        Asignatura a = new Asignatura(x);
        Asignatura b = new Asignatura(y);
        Asignatura c = new Asignatura(z);
    }

    public Asignatura getA() {
        return a;
    }

    public Asignatura getB() {
        return b;
    }

    public Asignatura getC() {
        return c;
    }
}
