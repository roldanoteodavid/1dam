package org.example;

public class Asignatura {
    private int id;
    private double nota;

    public Asignatura(int id) {
        this.id = id;
        this.nota = 0;
    }

    public int getId() {
        return id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
