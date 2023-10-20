package org.example.common;

public class HabilidadRepetidaException extends Exception{
    public HabilidadRepetidaException() {
        super("Alguna de las habilidades que ha introducido esta repetida.");
        //System.out.println("Alguna de las habilidades que ha introducido esta repetida.");
    }
}
