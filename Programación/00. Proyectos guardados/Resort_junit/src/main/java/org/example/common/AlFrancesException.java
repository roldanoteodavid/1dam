package org.example.common;

import java.util.Arrays;

public class AlFrancesException extends Exception {
    private static final String[] mensajes = {
            "Puto gabacho la torre Eiffel son las sobras de Barcelona",
            "A comer baguettes",
            "A conquistar tu país."
    };

    public AlFrancesException() {
        super(mensajes[(int) (Math.random() * mensajes.length)]);
    }
}
