package org.example;

public class Gallina extends Animal {

    private int huevosDia;

    public Gallina() {
        super();
        huevosDia = (int) (Math.random() * 8);
    }

    public Gallina(int huevos) {
        super();
        this.huevosDia = huevos;
    }

    public Gallina(String nombre, int edad, int id, int huevosDia) {
        super(id, nombre, edad);
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
        boolean renta = false;
        if (huevosDia>=5)
            renta =true;
        return renta;
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
