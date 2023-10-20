package org.example.dao;

import org.example.domain.Alojamiento;
import org.example.domain.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TESTDaoAlojamientoFicheros {
    private static final String FICHERO = "Fichero";
    private static final String FICHEROB = "FicheroBinario";

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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return escrito;
    }

    public static List<Alojamiento> cargarFicheroBinario() {
        List<Alojamiento> alojamientos = new ArrayList<>();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FICHEROB))) {
            alojamientos = (List<Alojamiento>) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return alojamientos;
    }

    public static boolean escribirFichero(List<Alojamiento> alojamientos) {
        boolean escrito = false;
        try (PrintWriter pw = new PrintWriter(FICHERO)) {
            alojamientos.stream().map(alojamiento -> alojamiento.toStringFichero()).forEach(pw::println);
            escrito = true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return escrito;
    }

    public static List<Alojamiento> cargarFichero() throws IOException {
        return cargarFichero(FICHERO);
    }

    public static List<Alojamiento> cargarFichero(String fichero) throws IOException {
        crearFicheros();
        List<Alojamiento> alojamientos = null;
        try (Scanner sc = new Scanner(new File(fichero))) {
            alojamientos = new ArrayList<>();
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                alojamientos.add(new Hotel(trozos[0], trozos[1], Double.parseDouble(trozos[2]), Integer.parseInt(trozos[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return alojamientos;
    }
}
