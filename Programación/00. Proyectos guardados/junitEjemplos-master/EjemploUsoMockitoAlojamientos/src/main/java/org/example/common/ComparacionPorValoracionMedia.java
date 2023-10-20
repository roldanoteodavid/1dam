package org.example.common;



import org.example.domain.Alojamiento;

import java.util.Comparator;

public class ComparacionPorValoracionMedia implements Comparator<Alojamiento> {

    @Override
    public int compare(Alojamiento arg0, Alojamiento arg1) {

        return (int) (arg0.getValoraciones().stream().mapToInt(value -> value).average().orElse(0)
                - arg1.getValoraciones().stream().mapToInt(value -> value).average().orElse(0));
        //return Double.compare(arg0.getValoraciones().stream().mapToInt(value -> value).average().orElse(0),arg1.getValoraciones().stream().mapToInt(value -> value).average().orElse(0));
    }

}

