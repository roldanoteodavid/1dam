package org.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Alojamiento implements Serializable {
    protected String nombre;
    protected String provincia;
    protected double precio;
    protected List<Integer> valoraciones;

    public Alojamiento(String nombre, String provincia, double precio, List<Integer> valoraciones) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.precio = precio;
        this.valoraciones = valoraciones;
    }

    public Alojamiento(String nombre, String provincia, double precio) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.precio = precio;
        this.valoraciones = new ArrayList<>();
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
        return getClass().getSimpleName() +
                "nombre='" + nombre + '\'' +
                ", provincia='" + provincia + '\'' +
                ", precio=" + precio +
                ", valoraciones=" + valoraciones;
    }

    public String toStringFichero() {
        return getClass().getSimpleName() + ";" + nombre + ";" + provincia + ";" + precio;
    }

    public String toStringValoraciones() {
        StringBuilder aux = null;
        if (!valoraciones.isEmpty()) {
            aux = new StringBuilder(valoraciones.get(0).toString());
            for (int i = 1; i < valoraciones.size(); i++) {
                aux.append("/").append(valoraciones.get(i).toString());
            }
        }
        return aux.toString();
    }
}
