package org.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CasaRural extends Alojamiento implements Serializable {
    private boolean piscina;

    public CasaRural(String nombre, String provincia, double precio, List<Integer> valoraciones, boolean piscina) {
        super(nombre, provincia, precio, valoraciones);
        this.piscina = piscina;
    }

    public CasaRural(String nombre, String provincia, double precio, boolean piscina) {
        super(nombre, provincia, precio);
        this.piscina = piscina;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", piscina=" + piscina;
    }

    @Override
    public String toStringFichero() {
        return super.toStringFichero() +
                ";" + piscina;
    }

    public double precioReal(String fecha) {
        double precioreal = 0;
        String trozosFecha[] = fecha.split("/");
        if (trozosFecha[1].equalsIgnoreCase("07")) {
            if (piscina) {
                precioreal = precio * 1.5;
            } else {
                precioreal = precio * 1.2;
            }
        } else if (trozosFecha[1].equalsIgnoreCase("08")) {
            if (piscina) {
                precioreal = precio * 1.6;
            } else {
                precioreal = precio * 1.3;
            }
        }
        return precioreal;
    }
}
