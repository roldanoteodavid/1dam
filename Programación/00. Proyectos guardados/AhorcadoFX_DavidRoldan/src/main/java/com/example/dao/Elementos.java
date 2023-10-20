package com.example.dao;

import com.github.javafaker.Faker;
import com.example.common.CategoriaException;
import com.example.common.Categoria;
import com.example.domain.Elemento;

import java.util.ArrayList;
import java.util.List;

public class Elementos extends ArrayList<Elemento> {
    private final ArrayList<Elemento> elementos;

    public Elementos() {
        this.elementos = new ArrayList<>();
        try {
            elementos.add(new Elemento("El mejor verano de mi vida", Categoria.comedia.name()));
            elementos.add(new Elemento("Misión Imposible IV fallout", Categoria.accion.name()));
            //librería generadora de elementos mediante categoria maven
            Faker faker = new Faker();
            //String nombre = faker.gameOfThrones().character();
            for (int i = 0; i < 10; i++) {
                elementos.add(new Elemento(faker.pokemon().name(), Categoria.pokemon.name()));
            }
        } catch (CategoriaException e) {
            System.out.println(e.getMessage());
        }

    }

    public Elementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public List<Elemento> getListaelementos() {
        return elementos;
    }

    public void setListaelementos(List<Elemento> elementos) {
        this.elementos.clear();
        this.elementos.addAll(elementos);
    }

    public Elemento getElementoDificultadCategoria(int dificultad, String categoria) {
        Elemento elemento = null;
        ArrayList<Elemento> elementosCatLev = new ArrayList<>();
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getCategoria().equalsIgnoreCase(categoria) && elementos.get(i).getLevel() == dificultad) {
                elementosCatLev.add(elementos.get(i));
            }
        }
        if (elementosCatLev.size() > 0) {
            elemento = elementosCatLev.get((int) (Math.random() * elementosCatLev.size()));
        }
        return elemento;
    }

    public void idOk(int id) throws IdException {
        boolean esta = false;
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getId() == id) {
                esta = true;
                i = elementos.size();
            }
        }
        if (!esta)
            throw new IdException(id);

    }
}

