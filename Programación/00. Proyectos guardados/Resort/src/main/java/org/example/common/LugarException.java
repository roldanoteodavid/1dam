package org.example.common;

import java.util.Arrays;

public class LugarException extends Exception{
    public LugarException() {
        super("El lugar debe ser alguno de las siguientes"+ Arrays.toString(Lugar.values()));
    }

    public LugarException(String lugar) {
        super("El lugar "+ lugar+" no está permitido. Sólo son válidos:"+ Arrays.toString(Lugar.values()));
    }
}
