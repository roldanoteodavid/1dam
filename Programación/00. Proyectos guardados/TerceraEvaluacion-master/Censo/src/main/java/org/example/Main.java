package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion = 11;

        Censo censo = new Censo();
        do {
            System.out.println("----------------------");
            System.out.println("| OPCIONES           |");
            System.out.println("----------------------");
            System.out.printf("|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n|%-80s|%n",
                    "1 Listar datos", "2 Añadir", "3 Mostrar datos a partir del nombre", "4 Listar registros de una población", "5 Listar mayores de una edad",
                    "6 Listar mayores de una edad y de una provincia", "7 Máxima edad provincia", "8 Número individuos provincia", "9 Conteo, media y min edad agrupadas por provincia",
                    "10 Ordenar", "11 Modificar población de un registro a partir del nombre", "12 Baja", "13 Mapeo", "14 Salir");
            System.out.println("----------------------");
            try {
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        censo.listar();
                        break;
                    case 2:
                        censo.alta();
                        break;
                    case 3:
                        System.out.println("Dime nombre");
                        String nombre = br.readLine();
                        censo.mostrar(nombre);
                        break;
                    case 4:
                        System.out.println("Dime poblacion");
                        String poblacion = br.readLine();
                        censo.mostrarPoblacion(poblacion);
                        break;
                    case 5:
                        System.out.println("Dime edad");
                        int edad = Integer.parseInt(br.readLine());
                        censo.mostrarMayores(edad);
                        break;
                    case 6:
                        System.out.println("Dime edad");
                        edad = Integer.parseInt(br.readLine());
                        System.out.println("Dime poblacion");
                        String poblacion3 = br.readLine();
                        censo.mostrarMayores(edad, poblacion3);
                        break;
                    case 7:
                        System.out.println("Dime poblacion");
                        poblacion3 = br.readLine();
                        System.out.println(censo.maxEdadrovincia(poblacion3));
                        break;
                    case 8:
                        System.out.println("Dime poblacion");
                        poblacion3 = br.readLine();
                        System.out.println(censo.individuosConteoProvincia(poblacion3));
                        break;
                    case 9:
                        censo.estadisticaProvincia();
                        break;
                    case 10:
                        censo.ordenar();
                        System.out.println(censo.devolverListadoOrdenado(true));
                        break;
                    case 11:
                        System.out.println("Dime nombre");
                        String nombre2 = br.readLine();
                        censo.mostrar(nombre2);
                        System.out.println("Dime poblacion nueva");
                        String poblacion2 = br.readLine();
                        censo.actualizarPoblacion(nombre2, poblacion2);
                        break;
                    case 12:
                        System.out.println("Dime poblacion");
                        String poblacion4 = br.readLine();
                        //System.out.println(censo.eliminarProvincia(poblacion4));
                        //no modifica censo
                        censo.eliminarIndividuosProvincia(poblacion4).forEach(System.out::println);
                        //para modificar censo
                        censo.setCenso(censo.eliminarIndividuosProvincia(poblacion4));
                        censo.listar();
                        //censo.baja(poblacion4);
                        break;
                    case 13:
                        System.out.println("Mapeo de individuos a simplemente sus nombres");
                        censo.mapeoIndividuosCadenas();
                        break;
                    default:
                        try {
                            throw new IllegalStateException("Unexpected value: " + opcion);
                        } catch (Exception e) {
                            System.out.println("Introduzca opcion entre 1 y 13");
                        }
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (opcion != 14);
    }
}

