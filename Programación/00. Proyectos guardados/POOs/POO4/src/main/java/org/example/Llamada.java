package org.example;

public abstract class Llamada {
    private int norigen;
    private int ndestino;
    private int duracion;

    public Llamada(int norigen, int ndestino, int duracion) {
        this.norigen = norigen;
        this.ndestino = ndestino;
        this.duracion = duracion;
    }

    public int getNorigen() {
        return norigen;
    }

    public int getNdestino() {
        return ndestino;
    }

    public int getDuracion() {
        return duracion;
    }

    public abstract int coste();

    @Override
    public String toString() {
        return "Llamada{" +
                "norigen=" + norigen +
                ", ndestino=" + ndestino +
                ", duracion=" + duracion +
                '}';
    }
}
