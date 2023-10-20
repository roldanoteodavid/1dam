package dao;

import domain.modelo.Animal;

import java.util.ArrayList;
import java.util.List;

public class DaoAnimales {

    private final Database db;

    public DaoAnimales() {
        this.db = new Database();
    }

    public boolean addAnimal(Animal p) {
        List<Animal> animals = db.loadAnimales();
        if (animals == null) {
            animals = new ArrayList<>();
        }
        animals.add(p);
        return db.saveAnimales(animals);
    }

    public List<Animal> getAnimales() {
        return db.loadAnimales();
    }

    public boolean eliminarAnimal(Animal p) {
        List<Animal> animals = db.loadAnimales();
        animals.remove(p);
        return db.saveAnimales(animals);
    }

    public boolean updateAnimal(Animal a1, Animal a2) {
        List<Animal> animals = db.loadAnimales();
        animals.remove(a2);
        animals.add(a1);
        return db.saveAnimales(animals);
    }

    public boolean getAnimal(Animal animal) {
        List<Animal> animals = db.loadAnimales();
        return animals.stream().anyMatch(a -> a.equals(animal));
    }
}