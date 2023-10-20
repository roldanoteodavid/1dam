package org.example;

import java.util.Objects;

public class Nota {
    private String asignatura;
    private double valor;

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0 || valor > 10) throw new RuntimeException("valor de nota no valido");
        this.valor = valor;
    }

    public Nota(String asignatura, double valor) {
        super();
        this.setAsignatura(asignatura);
        this.setValor(valor);
    }

    public String getCalificacion() {
        String mensaje = new String();
        if (valor >= 0 && valor <= 3) {
            mensaje =  "MuyDeficiente";
        } else if (valor > 3 && valor < 5) {
            mensaje =  "Insuficiente";
        } else if (valor >= 5 && valor < 6) {
            mensaje =  "Suficiente";
        } else if (valor >= 6 && valor < 7) {
            mensaje =  "Bien";
        } else if (valor >= 7 && valor < 9) {
            mensaje =  "Notable";
        } else if (valor>=9 && valor< 10)
            mensaje =  "SobreSaliente";
        return mensaje;
    }

    @Override
    public int hashCode() {
        return Objects.hash(asignatura, valor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Nota other = (Nota) obj;
        return Objects.equals(asignatura, other.asignatura)
                && Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
    }
    //método para explicar parametrizados con csv
    public static int suma(int a, int b){
        return a+b;
    }

}

