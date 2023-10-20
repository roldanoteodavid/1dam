package org.example.common;

public class Comprobacion {
    public static void categoriaOk(int categoria) throws CategoriaException {
        if (categoria < 1 || categoria > 5) {
            throw new CategoriaException(categoria);
        }
    }
}
