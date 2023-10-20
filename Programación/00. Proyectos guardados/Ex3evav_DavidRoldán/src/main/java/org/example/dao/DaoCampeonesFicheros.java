package org.example.dao;

import org.example.common.Habilidades;
import org.example.domain.Campeon;
import org.example.domain.Mago;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DaoCampeonesFicheros {
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

    public static boolean escribirFicheroBinario(List<Campeon> campeones) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROB))) {
            os.writeObject(campeones);
            escrito = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return escrito;
    }

    public static List<Campeon> cargarFicheroBinario() {
        List<Campeon> campeones = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FICHEROB))) {
            campeones = (List<Campeon>) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return campeones;
    }

    public static boolean escribirFichero(List<Campeon> campeones) {
        boolean escrito = false;
        try (PrintWriter pw = new PrintWriter(FICHERO)) {
            campeones.stream().map(campeon -> (campeon.toStringFichero() + ";" + campeon.toStringHabilidadesFichero())).forEach(pw::println);
            escrito = true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return escrito;
    }

    public static List<Campeon> cargarFichero() throws IOException {
        return cargarFichero(FICHERO);
    }

    public static List<Campeon> cargarFichero(String fichero) throws IOException {
        crearFicheros();
        List<Campeon> magos = null;
        try (Scanner sc = new Scanner(new File(fichero))) {
            magos = new ArrayList<>();
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                if (trozos[0].equalsIgnoreCase("MAGO")) {
                    magos.add(new Mago(Integer.parseInt(trozos[1]), trozos[2], Double.parseDouble(trozos[3]), Integer.parseInt(trozos[4]), getHabilidadesFichero(trozos[7]), Integer.parseInt(trozos[5]), Boolean.parseBoolean(trozos[6])));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return magos;
    }

    public static List<String> getHabilidadesFichero(String habilidades) {
        List<String> habilidadesfichero = new ArrayList<>();
        String[] arrayhabilidades = habilidades.split("/");
        for (int i = 0; i < arrayhabilidades.length; i++) {
            habilidadesfichero.add(arrayhabilidades[i]);
        }
        return habilidadesfichero;
    }
}
