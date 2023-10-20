package org.example.dao;

import org.example.domain.Alojamiento;
import org.example.domain.CasaRural;
import org.example.domain.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DaoAlojamientosFicheros {

    public static final String FICHERO = "Fichero";
    public static final String FICHEROB = "FicheroBinario";

    public static void crearFicheros() throws IOException {
        File fichero1 = new File(FICHERO);
        File fichero2 = new File(FICHEROB);
        if (!fichero1.exists())
            fichero1.createNewFile();
        if (!fichero2.exists())
            fichero2.createNewFile();

    }

    public static List<Alojamiento> leerFichero() throws IOException {
        return leerFichero(DaoAlojamientosFicheros.FICHERO);
    }

    public static List<Alojamiento> leerFichero(String fichero) throws IOException {
        crearFicheros();
        ArrayList<Alojamiento> auxiliar = null;
        try (Scanner sc = new Scanner(new File(fichero))) {
            auxiliar = new ArrayList<>();
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                if (trozos[0].equalsIgnoreCase("HOTEL")) {
                    //String nombre, String provincia, double precio, ArrayList<Integer> valoraciones, int categoria
                    auxiliar.add(new Hotel(trozos[1], trozos[2], Double.parseDouble(trozos[3]), getValoraciones(trozos[5]), Integer.parseInt(trozos[4])));
                } else if (trozos[0].equalsIgnoreCase("CASARURAL")) {
                    //String nombre, String provincia, double precio, ArrayList<Integer> valoraciones,boolean piscina
                    auxiliar.add(new CasaRural(trozos[1], trozos[2], Double.parseDouble(trozos[3]), getValoraciones(trozos[5]), Boolean.parseBoolean(trozos[4])));
                }
            }
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoAlojamientosFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return auxiliar;
    }

    public static List<Alojamiento> leerFicheroBinario() {
        List<Alojamiento> auxiliar = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FICHEROB))) {
            auxiliar = (List<Alojamiento>) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoAlojamientosFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

        }
        return auxiliar;
    }

    private static List<Integer> getValoraciones(String valoraciones) {
        ArrayList<Integer> aux = new ArrayList<>();
        String[] trozos = valoraciones.split("/");
        for (String trozo : trozos) {
            aux.add((Integer.parseInt(trozo)));
        }
        return aux;
    }

    public static boolean escribirFicheroBinario(List<Alojamiento> alojamientos) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROB))) {
            os.writeObject(alojamientos);
            escrito = true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            java.util.logging.Logger.getLogger(DaoAlojamientosFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return escrito;
    }

    public static boolean escribirFichero(List<Alojamiento> alojamientos) {
        boolean escrito = false;
        try (PrintWriter pw = new PrintWriter(FICHERO)) {
            alojamientos.stream()
                    .map(alojamiento -> alojamiento.toStringFichero() + ";"
                            + (alojamiento.getValoraciones().isEmpty() ? "" : alojamiento.getValoraciones().stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("/")))
                    )
                    .forEach(pw::println);
            escrito = true;
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoAlojamientosFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

        }
        return escrito;
    }

}
