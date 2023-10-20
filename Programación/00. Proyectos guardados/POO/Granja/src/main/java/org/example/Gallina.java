package Granja.src.main.java.org.example;

public class Gallina extends Animal{

    private int huevosDia;

    public Gallina(String nombre, int edad, int id, int huevosDia) {
        super(nombre, edad, id);
        this.huevosDia = huevosDia;
    }

    public int getHuevosDia() {
        return huevosDia;
    }

    public void setHuevosDia(int huevosDia) {
        this.huevosDia = huevosDia;
    }

    @Override
    public boolean rentable() {
        return huevosDia > 5;
    }

    @Override
    public String toString() {
        return "Gallina{" +
                "id=" + getId() +
                ", nombre='" + getNombre() +
                ", edad=" + getEdad() +
                ", huevos dia=" + huevosDia +
                '}';
    }
}
