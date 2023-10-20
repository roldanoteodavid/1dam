/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.domain;


import java.util.ArrayList;
import java.util.List;

/**
 * @author examen
 */
public class Hotel extends Alojamiento {

    protected int categoria;

    public Hotel(){
        super("nombre","provincia",30,new ArrayList<>(List.of(3,4,5,4)));
    }
    public Hotel(String nombre, String provincia, double precio, List<Integer> valoraciones, int categoria) {
        super(nombre, provincia, precio, valoraciones);
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
        return super.toString() + ", categoria=" + categoria;
    }

    @Override
    public String toStringFichero() {
        return super.toStringFichero() + ";" + categoria;
    }

    @Override
    public double precioReal(String fecha) {
        double precioReal = precio;
        String[] trozosFecha = fecha.split("/");
        if (trozosFecha[1].equalsIgnoreCase("07")) {
            precioReal = precio * 1.2;
        } else if (trozosFecha[2].equalsIgnoreCase("08")) {
            precioReal = precio * 1.3;
        }
        return precioReal;
    }

}
