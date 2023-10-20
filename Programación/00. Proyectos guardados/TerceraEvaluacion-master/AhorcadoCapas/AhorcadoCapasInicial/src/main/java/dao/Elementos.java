package dao;

import com.github.javafaker.Faker;
import common.CategoriaException;
import common.Categoria;
import domain.Elemento;

import java.util.ArrayList;
import java.util.List;

public class Elementos {
    private final ArrayList<Elemento> elementos;
    private static int autonumerico;
    public Elementos() {
        this.elementos = new ArrayList<>();
    try {
        elementos.add(new Elemento(autonumerico++, 1, "El mejor verano de mi vida", Categoria.comedia.name()));
        elementos.add(new Elemento(autonumerico++, 1, "Misión Imposible IV fallout", Categoria.accion.name()));
        //librería generadora de elementos mediante categoria maven
        Faker faker = new Faker();
        String nombre = faker.gameOfThrones().character();
        for (int i = 0; i < 10; i++) {
            elementos.add(new Elemento(autonumerico++, 2, faker.pokemon().name(), Categoria.pokemon.name()));
        }
    }catch(CategoriaException e){
        System.out.println(e.getMessage());
    }

    }

    public Elementos (ArrayList<Elemento> elementos){
        this.elementos = elementos;
    }

    public static void setAutonumerico(int i) {
        autonumerico=i;
    }

    public List<Elemento> getListaelementos() {
        return elementos;
    }

    public static int getAutonumerico() {
        return autonumerico;
    }

    public void setListaelementos(List<Elemento> elementos) {
        this.elementos.clear();
        this.elementos.addAll(elementos);
    }
}

