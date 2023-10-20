package domain.modelo;

import lombok.Data;
import java.util.Objects;

@Data
public class Animal {
    private final String id;
    private final String nombre;
    private final int edad;
    private final String raza;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
