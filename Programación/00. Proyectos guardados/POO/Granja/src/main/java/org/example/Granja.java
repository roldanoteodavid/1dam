package Granja.src.main.java.org.example;

import java.util.Scanner;

public class Granja {
    private static Animal[] animales;

    public Granja(String nombre, int edad, int id, int produccion) {
        animales = new Animal[10];
        for (int i = 0; i < animales.length; i++) {
            if (i % 2 == 0) {
                animales[i] = new Gallina(nombre, edad, id, produccion);
            } else {
                animales[i] = new Vaca(nombre, edad, id, produccion);
            }
        }
    }

    public static void listarAnimales() {
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] != null) {
                System.out.println(animales[i]);
            }
        }
    }

    public static void darDeAltaAnimal() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el nombre del animal");
        String nombre = teclado.next();
        System.out.println("Introduzca el ID del animal");
        int id = teclado.nextInt();
        System.out.println("Introduzca la edad del animal");
        int edad = teclado.nextInt();
        System.out.println("Introduzca 1 si se trata de una vaca y 2 si es una gallina");
        if (teclado.nextInt() == 1) {
            System.out.println("Introduzca la media de litros de leche/día de la vaca");
            int leche = teclado.nextInt();
            Granja vaca = new Granja(nombre, edad, id, leche);
        } else {
            System.out.println("Introduzca la media de huevos/día de la gallina");
            int huevos = teclado.nextInt();
            Granja gallina = new Granja(nombre, edad, id, huevos);
        }
    }

    public static void eliminarAnimal(int id) {
        for (int i = 0; i < animales.length; i++) {
            if (animales[i].getId() == id) {
                animales[i] = null;
                i = animales.length;
            }
        }
    }

    public static void listarEdad(int edad) {

    }

    public static void modificar(int id) {
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < animales.length; i++) {
            if (animales[i].getId() == id) {
                System.out.println("Introduzca 1 para modificar el nombre, 2 para el id y 3 para la edad.");
                switch (teclado.nextInt()) {
                    case 1:
                        System.out.println("Introduzca el nuevo nombre.");
                        animales[i].setNombre(teclado.next());
                        break;
                    case 2:
                        System.out.println("Introduzca el nuevo id.");
                        animales[i].setId(teclado.nextInt());
                        break;
                    case 3:
                        System.out.println("Introduzca la nueva edad.");
                        animales[i].setEdad(teclado.nextInt());
                        break;
                    /*case 4:
                        System.out.println("Introduzca la nueva media de produccion/dia.");
                        animales[i].setId(teclado.nextInt());
                        break;*/
                    default:
                        System.out.println("Introduzca una opción válida.");
                }
            }
        }
    }

    public static void listarRentables(int tipo) {
        for (int i = 0; i < animales.length; i++) {
            if (tipo % 2 == 0) {
                if (animales[i].rentable() == true) {
                    System.out.println(animales[i]);
                }
            } else {
                if (animales[i].rentable() == true) {
                    System.out.println(animales[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int option = 1;
        do {
            System.out.println("Introduzca 1 para listar todos los animales, 2 para dar de alta un animal, 3 para eliminar un animal, 4 para listar los animales mayores a una edad, 5 para modificar el atributo de algún animal, 6 para mostrar el número de animales rentables de la granja de un tipo o 0 para salir.");
            option = teclado.nextInt();
            switch (option) {
                case 1:
                    Granja.listarAnimales();
                    break;
                case 2:
                    Granja.darDeAltaAnimal();
                    break;
                case 3:
                    System.out.println("Introduzca el id del animales que desea eliminar.");
                    Granja.eliminarAnimal(teclado.nextInt());
                    break;
                case 4:
                    System.out.println("Introduzca la edad desde la que desea busca animales.");
                    Granja.listarEdad(teclado.nextInt());
                    break;
                case 5:
                    System.out.println("Introduzca el id del animal que desea modificar.");
                    Granja.modificar(teclado.nextInt());
                    break;
                case 6:
                    System.out.println("Introduzca 1 para listar las vacas rentable y 2 para las gallinas.");
                    Granja.listarRentables(teclado.nextInt());
                    break;
                default:
                    System.out.println("Introduzca una opción válida.");
            }
        } while (option != 0);
    }
}
