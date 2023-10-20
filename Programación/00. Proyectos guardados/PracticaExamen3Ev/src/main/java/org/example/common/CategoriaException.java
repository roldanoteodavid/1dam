package org.example.common;

public class CategoriaException extends Exception{
    public CategoriaException(int categoria) {
        super("La categoria "+ categoria+" no está permitida. Sólo son válidos: 1, 2, 3, 4, 5");
    }
    public CategoriaException() {
        super("La categoria debe estar entre 1 y 5");
    }
}
