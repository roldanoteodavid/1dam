package org.example.dao;

import org.example.domain.Alojamiento;
import org.example.domain.CasaRural;
import org.example.domain.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoAlojamientoFicheros {
    public static final String FICHERO = "Fichero";
    public static final String FICHEROB = "FicheroBinario";

    public static void crearFicheros() throws IOException {
        File fichero1 = new File(FICHERO);
        File fichero2 = new File(FICHEROB);
        if (!fichero1.exists()) {
            fichero1.createNewFile();
        }
        if (!fichero2.exists()) {
            fichero2.createNewFile();
        }

    }

    public static boolean escribirFicheroBinario(List<Alojamiento> alojamientos) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROB))) {
            os.writeObject(alojamientos);
            escrito = true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return escrito;
    }

    public static boolean escribirFichero(List<Alojamiento> alojamientos) {
        boolean escrito = false;
        try (PrintWriter pw = new PrintWriter(FICHERO)) {
            alojamientos.stream().map(alojamiento -> alojamiento.toStringFichero() + ";" + alojamiento.toStringValoraciones()).forEach(pw::println);
            escrito = true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return escrito;
    }

    public static List<Alojamiento> cargarFichero() throws IOException {
        return cargarFichero(FICHERO);
    }

    public static List<Alojamiento> cargarFichero(String fichero) throws IOException {
        crearFicheros();
        List<Alojamiento> aux = null;
        try (Scanner teclado = new Scanner(new File(fichero))) {
            aux = new ArrayList<>();
            while (teclado.hasNextLine()) {
                String cadena = teclado.nextLine();
                String[] trozos = cadena.split(";");
                if (trozos[0].equalsIgnoreCase("HOTEL")) {
                    aux.add(new Hotel(trozos[1], trozos[2], Double.parseDouble(trozos[3]), getValoraciones(trozos[5]), Integer.parseInt(trozos[4])));
                } else if (trozos[0].equalsIgnoreCase("CASARURAL")) {
                    aux.add(new CasaRural(trozos[1], trozos[2], Double.parseDouble(trozos[3]), getValoraciones(trozos[5]), Boolean.parseBoolean(trozos[4])));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return aux;
    }

    public static List<Integer> getValoraciones(String valoraciones) {
        List<Integer> aux = new ArrayList<>();
        String[] trozos = valoraciones.split("/");
        for (int i = 0; i < trozos.length; i++) {
            aux.add(Integer.parseInt(trozos[i]));
        }
        return aux;
    }

    public static List<Alojamiento> cargarFicheroBinario() {
        List<Alojamiento> aux = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FICHEROB))) {
            aux = (List<Alojamiento>) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return aux;
    }
}
