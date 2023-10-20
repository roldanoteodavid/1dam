package org.example.common;

import org.example.domain.Alojamiento;

import java.util.Comparator;

public class ComparacionValoracionMedia implements Comparator<Alojamiento> {

    @Override
    public int compare(Alojamiento o1, Alojamiento o2) {
        int valo1 = 0;
        for (int i = 0; i < o1.getValoraciones().size(); i++) {
            valo1 = valo1 + o1.getValoraciones().get(i);
        }
        valo1 = valo1 / o1.getValoraciones().size();
        int valo2 = 0;
        for (int i = 0; i < o2.getValoraciones().size(); i++) {
            valo2 = valo2 + o2.getValoraciones().get(i);
        }
        valo2 = valo2 / o2.getValoraciones().size();
        int comparacion = 0;
        if (valo1 > valo2) {
            comparacion = 1;
        } else if (valo1 < valo2) {
            comparacion = -1;
        }
        return comparacion;
    }
}
