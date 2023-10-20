/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.domain;



import java.util.List;

/**
 *
 * @author examen
 */
public class CasaRural extends Alojamiento {

    private boolean piscina;



    public CasaRural(String nombre, String provincia, double precio, List<Integer> valoraciones, boolean piscina) {
        super(nombre, provincia, precio, valoraciones);
        this.piscina = piscina;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    @Override
    public String toString() {
        return super.toString() + ", piscina=" + piscina;
    }

    @Override
    public String toStringFichero() {
        return super.toStringFichero() + ";" + piscina;
    }

    @Override
    public double precioReal(String fecha) {
        double precioReal = precio;
        String[] trozosFecha = fecha.split("/");
        if (trozosFecha[1].equalsIgnoreCase("07")) {
            if (piscina) {
                precioReal = precio * 1.5;
            } else {
                precioReal = precio * 1.2;
            }
        } else if (trozosFecha[2].equalsIgnoreCase("08")) {
            if (piscina) {
                precioReal = precio * 1.6;
            } else {
                precioReal = precio * 1.3;
            }
        } else if (piscina) {
            precioReal = precio * 1.3;
        }
        return precioReal;
    }

}
