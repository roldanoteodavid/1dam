package org.example.common;

import org.example.domain.Hotel;

import java.util.Comparator;

public class ComparacionPorCategoriaNombre implements Comparator<Hotel> {

    @Override
    public int compare(Hotel arg0, Hotel arg1) {
        int aux=Integer.compare(arg0.getCategoria(),arg1.getCategoria());
        if(aux==0){
            aux=arg0.getNombre().compareTo(arg1.getNombre());
        }
        return aux;
    }
}

