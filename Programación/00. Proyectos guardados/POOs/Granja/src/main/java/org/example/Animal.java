package org.example;

public abstract class Animal {
    protected String nombre;
    protected int edad;
    protected int id;

    public Animal() {
        this.id = (int) (Math.random()*10);
        this.nombre = Utilidades.nombres[(int)(Math.random()*Utilidades.nombres.length)];
        this.edad = Utilidades.edad[(int)(Math.random()*Utilidades.edad.length)];
    }

    public Animal(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public abstract boolean rentable();

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
