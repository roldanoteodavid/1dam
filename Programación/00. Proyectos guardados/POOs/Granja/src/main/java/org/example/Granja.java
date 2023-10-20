package org.example;

import java.util.Scanner;

public class Granja {
    private Animal[] animales;

    public Granja() {
        animales = new Animal[10];
        for (int i = 0; i < animales.length / 2; i++) {
            if (i % 2 == 0) {
                animales[i] = new Gallina();
            } else {
                animales[i] = new Vaca();
            }
        }
    }

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

    public void listarAnimales() {
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] != null) {
                System.out.println(animales[i]);
            }
        }
    }

    public void darDeAltaAnimal() {
        Scanner teclado = new Scanner(System.in);
        boolean hueco = false;
        for (int i = 0; i < animales.length && !hueco; i++) {
            if (animales[i] == null)
                hueco = true;
        }
        if (hueco) {
            Animal animal = null;
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
                animal = new Vaca(nombre, edad, id, leche);
            } else {
                System.out.println("Introduzca la media de huevos/día de la gallina");
                int huevos = teclado.nextInt();
                animal = new Gallina(nombre, edad, id, huevos);
            }
            for (int i = 0; i < animales.length; i++) {
                if (animales[i] == null) {
                    animales[i] = animal;
                    i = animales.length;
                }
            }
        } else {
            System.out.println("No queda hueco en la granja para nuevos animales.");
        }
    }

    public void eliminarAnimal(int id) {
        for (int i = 0; i < animales.length; i++) {
            if (animales[i].getId() == id) {
                animales[i] = null;
                i = animales.length;
            }
        }
    }

    public void listarEdad(int edad) {
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] != null) {
                System.out.println(animales[i]);
            }
        }
    }

    public void modificar(int id) {
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

    public void listarRentables(int tipo) {
        for (int i = 0; i < animales.length; i++) {
            if (tipo % 2 == 0) {
                if (animales[i].rentable() == true && animales[i]!=null) {
                    System.out.println(animales[i]);
                }
            } else {
                if (animales[i].rentable() == true && animales[i]!=null) {
                    System.out.println(animales[i]);
                }
            }
        }
    }

    public int cuantosColacaos(){
        int cantidad=0;
        for (int i = 0; i < animales.length; i++) {
            if (animales[i]!=null && animales[i].getClass().getSimpleName().equals("Vaca")){
                Vaca aux = (Vaca) animales[i];
                cantidad = cantidad + aux.getLitrosLeche();

            }
        }
        return cantidad/4;
    }
}
