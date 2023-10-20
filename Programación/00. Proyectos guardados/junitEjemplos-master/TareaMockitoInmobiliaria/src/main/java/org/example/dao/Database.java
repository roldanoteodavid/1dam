package org.example.dao;

import org.example.common.m2Exception;
import org.example.domain.Vivienda;

import java.util.ArrayList;
import java.util.List;

public class Database {


    private final ArrayList<Vivienda> viviendas;

    public Database() {
        this.viviendas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            try {
                viviendas.add(new Vivienda(i, "Calle" + (i%3), (int) (Math.random() * 100), "Provincia" + (i % 3), Math.random() * 300.000, Math.random() * 100+2));
            } catch (m2Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Database (ArrayList<Vivienda> viviendas){
        this.viviendas = viviendas;
    }

    public List<Vivienda> getListaViviendas() {
        return viviendas;
    }


    public void setListaViviendas(List<Vivienda> viviendas) {
        this.viviendas.clear();
        this.viviendas.addAll(viviendas);
    }
}
