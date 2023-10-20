package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import config.Configuracion;
import domain.modelo.Animal;
import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Log4j2

public class Database {

    public List<Animal> loadAnimales() {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Animal>>() {}.getType();

        List<Animal> animals = null;
        try {
            animals = gson.fromJson(
                    new FileReader(new Configuracion().loadPathProperties()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return animals;
    }

    public boolean saveAnimales(List<Animal> animals) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fw = new FileWriter(new Configuracion().loadPathProperties())) {
            gson.toJson(animals, fw);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
}
