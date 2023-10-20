package org.example;

public class Medico {
    private String nombre;
    private int edad;
    private char sexo;
    private int horas;
    private double SalarioHora;

    public Medico(String nombre, int edad, char sexo, int horas, double salarioHora) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.horas = horas;
        SalarioHora = salarioHora;
    }

    public String mostrarDatos() {
        return "Medico: " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                ", horas=" + horas +
                ", SalarioHora=" + SalarioHora;
    }

    public double calcularSalario(){
        return SalarioHora*horas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }

    public int getHoras() {
        return horas;
    }

    public double getSalarioHora() {
        return SalarioHora;
    }
}
