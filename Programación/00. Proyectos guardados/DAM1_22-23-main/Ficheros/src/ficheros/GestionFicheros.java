/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gema
 */
public class GestionFicheros {

    public static final String NOMBRE_FICHERO = "fichero";
    public static final String NOMBRE_FICHERO_BINARIO = "ficheroBinario";
//Class File: mirar esa clase y me contáis lo que hay

    public static void writeFileFromConsole() {
        Scanner lector = new Scanner(System.in);

        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(NOMBRE_FICHERO, true));
            for (int i = 0; i < 5; i++) {
                System.out.println("Introduce ciudad");
                String ciudad = lector.nextLine();
                pw.println(ciudad);
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Elemento> generarArrayList() {
        ArrayList<Elemento> ciudades = new ArrayList<>();
        ciudades.add(new Elemento(1, 1, "Ciudades", "Málaga"));
        ciudades.add(new Elemento(2, 1, "Ciudades", "Albacete"));
        ciudades.add(new Elemento(3, 1, "Ciudades", "Madrid"));
        return ciudades;
    }

    public static void writeFileFromArrayList(ArrayList<Elemento> lista) {
        try {
            PrintWriter pw = new PrintWriter(NOMBRE_FICHERO);
            //PrintWriter pw = new PrintWriter(new FileWriter(NOMBRE_FICHERO,true));
            for (int i = 0; i < lista.size(); i++) {
                pw.println(lista.get(i).toStringFichero());
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void read() {
        try {
            //File f = new File(NOMBRE_FICHERO);
            Scanner scanner = new Scanner(new File(NOMBRE_FICHERO));
            ArrayList<String> lista = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                lista.add(linea);
                System.out.println(linea);
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void readArrayList() {
        try {
            //File f = new File(NOMBRE_FICHERO);
            Scanner scanner = new Scanner(new File(NOMBRE_FICHERO));
            ArrayList<Elemento> lista = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String trozos[] = linea.split(";");
                Elemento elemento = new Elemento(Integer.parseInt(trozos[0]), Integer.parseInt(trozos[1]), trozos[2], trozos[3]);
                lista.add(elemento);
            }
            scanner.close();
            Collections.sort(lista);
            System.out.println(lista);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void readBuffered() {
        try ( BufferedReader bf = new BufferedReader(new FileReader(NOMBRE_FICHERO))) {
            //File f = new File(NOMBRE_FICHERO);
            // FileReader fr = new FileReader(new File(NOMBRE_FICHERO));

            String cadena = null;
            do {
                cadena = bf.readLine();
                if (cadena != null) {
                    System.out.println(cadena);
                }
            } while (cadena != null);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void writeBinary(ArrayList<Elemento> lista) throws IOException {
        //Código para explicar cómo utilizar file si queremos crear el fichero, si no existe, o en caso contrario borrarlo..
        /*File file = new File(NOMBRE_FICHERO_BINARIO);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }*/
        try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO_BINARIO))) {
            os.writeObject(lista);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Elemento> readBinary() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Elemento> lista = null;
        try ( ObjectInputStream os = new ObjectInputStream(new FileInputStream(NOMBRE_FICHERO_BINARIO))) {
            lista = (ArrayList<Elemento>) os.readObject();
        }
        return lista;
    }
}
