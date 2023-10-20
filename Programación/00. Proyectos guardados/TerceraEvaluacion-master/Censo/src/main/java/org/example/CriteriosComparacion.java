package org.example;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Comparator;

/**
 *
 * @author GEMA
 */
public class CriteriosComparacion {

}

class porEdad implements Comparator<Individuo>{

    @Override
    public int compare(Individuo t, Individuo t1) {
       return Integer.compare(t.edad,t1.edad);
    }

}

class porPoblacion implements Comparator<Individuo>{

    @Override
    public int compare(Individuo t, Individuo t1)    {
        return t.poblacion.compareTo(t1.poblacion);
    }
    


}

