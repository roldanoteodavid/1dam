package org.example.common;

import org.example.domain.Campeon;

import java.util.Comparator;

public class ComparacionNombre implements Comparator<Campeon> {
    @Override
    public int compare(Campeon o1, Campeon o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
