package org.example.domain;

import org.example.common.Categoria;

import java.util.Arrays;

public class CatLevException extends Exception {
    public CatLevException() {
        super("No existe ningún elemento con esa categoría y dificultad.");
    }

    public CatLevException(String categoria, int dificultad) {
        super("No existe ningún elemento con la categoría " + categoria + " y la dificultad " + dificultad);
    }
}
