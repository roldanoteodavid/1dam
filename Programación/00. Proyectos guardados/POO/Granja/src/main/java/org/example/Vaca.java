package Granja.src.main.java.org.example;

public class Vaca extends Animal{
    private int litrosLeche;

    public Vaca(String nombre, int edad, int id, int litrosLeche) {
        super(nombre, edad, id);
        this.litrosLeche = litrosLeche;
    }

    public int getLitrosLeche() {
        return litrosLeche;
    }

    public void setLitrosLeche(int litrosLeche) {
        this.litrosLeche = litrosLeche;
    }

    @Override
    public boolean rentable() {
        return litrosLeche > 5;
    }
    @Override
    public String toString() {
        return "Gallina{" +
                "id=" + getId() +
                ", nombre='" + getNombre() +
                ", edad=" + getEdad() +
                ", litros leche=" + litrosLeche +
                '}';
    }
}
