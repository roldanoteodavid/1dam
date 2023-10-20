package org.example.domain;

import org.example.common.CategoriaException;
import org.example.common.Comprobacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hotel extends Alojamiento implements Serializable {
    private int categoria;

    public Hotel(String nombre, String provincia, double precio, List<Integer> valoraciones, int categoria) {
        super(nombre, provincia, precio, valoraciones);
        this.categoria = categoria;
    }

    public Hotel(String nombre, String provincia, double precio, int categoria) {
        super(nombre, provincia, precio);
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", categoria=" + categoria;
    }

    @Override
    public String toStringFichero() {
        return super.toStringFichero() +
                ";" + categoria;
    }

    @Override
    public double precioReal(String fecha) {
        double precioreal = 0;
        String trozosFecha[] = fecha.split("/");
        if (trozosFecha[1].equalsIgnoreCase("07")) {
            precioreal = precio * 1.2;
        } else if (trozosFecha[1].equalsIgnoreCase("08")) {
            precioreal = precio * 1.3;
        }
        return precioreal;
    }
}
