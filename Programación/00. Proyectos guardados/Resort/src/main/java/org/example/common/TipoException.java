package org.example.common;

import java.util.Arrays;

public class TipoException extends Exception {
    public TipoException() {
        super("El tipo debe ser alguno de las siguientes"+ Arrays.toString(Tipo.values()));
    }

    public TipoException(String tipo) {
        super("El tipo "+ tipo+" no está permitido. Sólo son válidos:"+ Arrays.toString(Tipo.values()));
    }
}
