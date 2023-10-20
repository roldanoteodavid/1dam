/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.domain;

import org.example.common.Comprobacion;
import org.example.common.m2Exception;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author examen
 */
public class Vivienda implements Serializable, Comparable<Vivienda> {
    private int id;
    private String calle;
    private int numero;
    private String provincia;
    protected double precio;
    protected double m2;

    public Vivienda(int id, String calle, int numero, String provincia, double precio, double m2) throws m2Exception {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.provincia = provincia;
        this.precio = precio;
        Comprobacion.m2Ok(m2);
        this.m2 = m2;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) throws m2Exception {
        Comprobacion.m2Ok(m2);
        this.m2 = m2;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
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

    @Override
    public String toString() {
        return "Vivienda{" +
                "id='"+ id+'\''+
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                ", provincia='" + provincia + '\'' +
                ", precio=" + precio +
                ", m2=" + m2 +
                '}'+'\n';
    }


    @Override
    public int compareTo(Vivienda arg0) {
        return this.calle.compareTo(arg0.calle);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vivienda vivienda = (Vivienda) o;
        return id == vivienda.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, calle, numero, provincia, precio, m2);
    }
}
