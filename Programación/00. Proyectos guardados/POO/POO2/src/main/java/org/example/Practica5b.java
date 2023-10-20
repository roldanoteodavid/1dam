package org.example;

public class Practica5b {
    public static void main(String[] args) {
        Asignatura programacion = new Asignatura(1);
        Asignatura entornos = new Asignatura(2);
        Asignatura marcas = new Asignatura(3);
        Alumno alumno = new Alumno(programacion, entornos, marcas);
        Profesor profesor = new Profesor();
        profesor.ponerNotas(alumno);
        System.out.println("La nota de programación es "+ programacion.getNota()+", la nota de entornos es "+entornos.getNota()+" y la nota de lenguaje de marcas es "+marcas.getNota());
        System.out.println("La media del alumno es "+profesor.calcularMedia(alumno));
    }
}
