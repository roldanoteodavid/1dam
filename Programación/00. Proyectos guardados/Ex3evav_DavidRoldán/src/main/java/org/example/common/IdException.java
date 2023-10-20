package org.example.common;

public class IdException extends Exception{
    public IdException() {
        super("El id introducido está repetido.");
    }
}
