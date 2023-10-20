package org.example;

public class Vaca extends Animal{
    private int litrosLeche;
    public Vaca() {
        super();
        litrosLeche = (int) (Math.random() * 8);
    }

    public Vaca(String nombre, int edad, int id, int litrosLeche) {
        super(id, nombre, edad);
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
        boolean renta = false;
        if (litrosLeche>=50)
            renta =true;
        return renta;
    }
    @Override
    public String toString() {
        return "Vaca{" +
                "id=" + getId() +
                ", nombre='" + getNombre() +
                ", edad=" + getEdad() +
                ", litros leche=" + litrosLeche +
                '}';
    }
}
