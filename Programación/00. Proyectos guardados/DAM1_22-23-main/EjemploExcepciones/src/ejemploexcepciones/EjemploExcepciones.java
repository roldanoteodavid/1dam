/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploexcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author gema
 */
public class EjemploExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        Scanner lector = new Scanner(System.in);
        boolean vuelve = false;
        int num=0;
        while (!vuelve) {
            try {
                System.out.println("Introduce número");
                num = lector.nextInt();
                vuelve = true;
                //has metido un número!!
            } catch (InputMismatchException exception) {
                System.out.println("Tienes que introducir un número, no una letra");
                System.out.println(exception.getMessage());
                lector.nextLine();
            }
        }
        boolean otro = false;
        try {
            Comprobaciones.numeroRango(num);
            System.out.println("Enhorabuena, en breve en Entornos");
        } catch (MariaExcepction ex) {
            otro = true;
            System.out.println(ex.getMessage());
        }
        if (!otro)
            System.out.println("No te has encontrado ninguna excepción por el camino");
 }

}
