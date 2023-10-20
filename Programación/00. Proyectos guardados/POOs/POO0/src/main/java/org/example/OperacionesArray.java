package org.example;

import java.util.Arrays;

public class OperacionesArray {
    private int[] numeros;


    public OperacionesArray() {
        numeros = new int[3];
    }

    public void OperacionesArrays(int tamanyo) {
        numeros = new int[tamanyo];
    }

    @Override
    public String toString() {
        return "OperacionesArray{" +
                "numeros=" + Arrays.toString(numeros) +
                '}';
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void cargar() {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 9 + 1);
        }
    }

    public double media() {
        double media = 0;
        for (int i = 0; i < this.numeros.length; i++) {
            media = media + this.numeros[i];
        }
        media = media / this.numeros.length;
        return media;
    }

    public String ordenar() {
        int ordenado[] = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            ordenado[i] = numeros[i];
        }
        Arrays.sort(ordenado);
        return "ArrayOrdenado{" +
                "numeros=" + Arrays.toString(ordenado) +
                '}';
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public String invertir() {
        int invertido[] = new int[this.numeros.length];
        for (int i = 0; i < this.numeros.length; i++) {
            invertido[i] = this.numeros[this.numeros.length - 1 - i];
        }

        return "ArrayInvertido{" +
                "numeros=" + Arrays.toString(invertido) +
                '}';
    }
}
