package org.example.common;

import org.example.domain.Vivienda;

import java.util.Comparator;

public class ComparacionPorCalleMetros implements Comparator<Vivienda> {

    @Override
    public int compare(Vivienda arg0, Vivienda arg1) {
        int aux=arg0.getCalle().compareTo(arg1.getCalle());
        if(aux==0){
            aux=Double.compare(arg0.getM2(),arg1.getM2());
        }
        return aux;
    }
}

