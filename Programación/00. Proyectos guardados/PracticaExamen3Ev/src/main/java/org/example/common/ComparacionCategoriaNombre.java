package org.example.common;

import org.example.domain.Hotel;

import java.util.Comparator;

public class ComparacionCategoriaNombre implements Comparator<Hotel> {
    @Override
    public int compare(Hotel o1, Hotel o2) {
        int aux = Integer.compare(o1.getCategoria(),o2.getCategoria());
        if (aux == 0){
            aux = o1.getNombre().compareTo(o2.getNombre());
        }
        return aux;
    }
}
