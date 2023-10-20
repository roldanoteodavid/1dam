package org.example.common;

import java.util.List;

public class HabilidadException extends Exception {

    public HabilidadException() {
        super("La habilidad introducida no es correcta.");
        //System.out.println("La habilidad introducida no es correcta.");
    }
    public HabilidadException(List<String> habilidad) {
        super("Alguna de las siguientes habitidades:" + habilidad + " no es correcta, solo son válidas: inspiracion, valor, brujeria, precision y dominacion");
        //System.out.println("Alguna de las siguientes habitidades:" + habilidad + " no es correcta, solo son válidas: inspiracion, valor, brujeria, precision y dominacion");
    }
}
