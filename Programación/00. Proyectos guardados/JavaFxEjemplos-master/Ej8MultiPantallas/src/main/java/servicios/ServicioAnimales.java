package servicios;

import dao.DaoAnimales;
import domain.modelo.Animal;
import lombok.extern.log4j.Log4j2;

import java.util.List;
@Log4j2
public class ServicioAnimales {

    private final DaoAnimales daoAnimales;

    public ServicioAnimales(DaoAnimales daoAnimales) {
        this.daoAnimales = daoAnimales;
    }

    public boolean addAnimal(Animal a) {
        if (!getAnimal(a)) {
            return daoAnimales.addAnimal(a);
        } else {
            return false;
        }
    }

    public List<Animal> getAnimales() {
        return daoAnimales.getAnimales();
    }

    public boolean getAnimal(Animal a) {
        return daoAnimales.getAnimal(a);
    }

    public boolean updateAnimal(Animal a1, Animal a2) {
        if (daoAnimales.getAnimal(a2)) {
            return daoAnimales.updateAnimal(a1, a2);
        } else {
            return false;
        }
    }

    public boolean deleteAnimal(Animal a) {
        if (daoAnimales.getAnimal(a)) {
            return daoAnimales.eliminarAnimal(a);
        } else {
            return false;
        }
    }

}