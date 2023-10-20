/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author examen
 */
public abstract class Alojamiento implements Serializable, Comparable<Alojamiento> {

    private String nombre;
    private String provincia;
    protected double precio;
    private List<Integer> valoraciones;


    public Alojamiento(String nombre, String provincia, double precio, List<Integer> valoraciones) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.precio = precio;
        this.valoraciones = valoraciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Integer> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Integer> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public abstract double precioReal(String fecha);

    @Override
    public String toString() {
        return getClass().getSimpleName() + " nombre=" + nombre + ", provincia=" + provincia + ", precio=" + precio + ", valoraciones=" + valoraciones;
    }

    public String toStringFichero() {
        return getClass().getSimpleName() + ";" + nombre + ";" + provincia + ";" + precio;
    }

    public String toStringValoraciones() {
        StringBuilder auxiliar = null;
        if (!valoraciones.isEmpty()) {
            auxiliar = new StringBuilder(valoraciones.get(0).toString());
            for (int i = 1; i < valoraciones.size(); i++) {
                auxiliar.append("/").append(valoraciones.get(i).toString());
            }
        }

        return auxiliar.toString();
    }

    @Override
    public int compareTo(Alojamiento arg0) {
        return this.nombre.compareTo(arg0.nombre);
    }

}
