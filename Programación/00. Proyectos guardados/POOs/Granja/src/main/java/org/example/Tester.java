package org.example;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Granja miGranja = new Granja();
        int option = 1;
        do {
            System.out.println("Introduzca 1 para listar todos los animales, 2 para dar de alta un animal, 3 para eliminar un animal, 4 para listar los animales mayores a una edad, 5 para modificar el atributo de algún animal, 6 para mostrar el número de animales rentables de la granja de un tipo o 0 para salir.");
            option = teclado.nextInt();
            switch (option) {
                case 1:
                    miGranja.listarAnimales();
                    break;
                case 2:
                    miGranja.darDeAltaAnimal();
                    break;
                case 3:
                    System.out.println("Introduzca el id del animales que desea eliminar.");
                    miGranja.eliminarAnimal(teclado.nextInt());
                    break;
                case 4:
                    System.out.println("Introduzca la edad desde la que desea busca animales.");
                    miGranja.listarEdad(teclado.nextInt());
                    break;
                case 5:
                    System.out.println("Introduzca el id del animal que desea modificar.");
                    miGranja.modificar(teclado.nextInt());
                    break;
                case 6:
                    System.out.println("Introduzca 1 para listar las vacas rentable y 2 para las gallinas.");
                    miGranja.listarRentables(teclado.nextInt());
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Introduzca una opción válida.");
            }
        } while (option != 0);
    }
}
