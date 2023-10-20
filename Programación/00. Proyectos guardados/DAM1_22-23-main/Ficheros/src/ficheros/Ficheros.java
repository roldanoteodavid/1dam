/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gema
 */
public class Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //GestionFicheros.writeFileFromArrayList(GestionFicheros.generarArrayList());
        //GestionFicheros.readBuffered();
        /*ArrayList<Elemento> lista = new ArrayList<>();
        lista.add(new Elemento(0, 1, "animales", "rana"));
        lista.add(new Elemento(1, 1, "animales", "gato"));
        try {
            GestionFicheros.writeBinary(lista);
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        ArrayList<Elemento> lista= null;
        try {
            lista = GestionFicheros.readBinary();
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(lista);
    }

}
