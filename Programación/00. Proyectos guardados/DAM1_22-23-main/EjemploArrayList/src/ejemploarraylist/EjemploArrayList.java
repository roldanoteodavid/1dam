/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploarraylist;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gema
 */
public class EjemploArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> ciudades = new ArrayList();
        ciudades.add("Madrid"); //ciudades[0]="Sevilla";
        ciudades.add("Barcelona");
        ciudades.add("Quito");
        ciudades.add("Zamora");
        for (int i = 0; i < ciudades.size() ; i++) {
            System.out.println(ciudades.get(i));
        }
        Collections.sort(ciudades);
        Collections.reverse(ciudades);
        System.out.println(ciudades);
        Object [] ciudadesArrays = ciudades.toArray();
        

    }

}
