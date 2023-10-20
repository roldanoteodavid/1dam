package org.example.dao;

import config.Configuration;
import org.example.domain.Hotel;

import java.io.*;

public class DaoHotelFicheros {
    //public static final String FICHERO = "Fichero";
    //public static final String FICHEROB = "FicheroBinario";
    private Configuration config;

    public static void crearFicheros() throws IOException {
        String pathLista = Configuration.getInstance().getProperty("pathLista");
        File fichero2 = new File(pathLista);
        if (!fichero2.exists()) {
            fichero2.createNewFile();
            Hotel hotel = new Hotel();
            try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(pathLista))) {
                os.writeObject(hotel);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                java.util.logging.Logger.getLogger(DaoHotelFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

    public static Hotel leerFicheroBinario() {
        Hotel auxiliar = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File(Configuration.getInstance().getProperty("pathLista"))))) {
            auxiliar = (Hotel) is.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoHotelFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

        }
        return auxiliar;
    }

    public static boolean escribirFicheroBinario(Hotel hotel) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(Configuration.getInstance().getProperty("pathLista"))))) {
            os.writeObject(hotel);
            escrito = true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            java.util.logging.Logger.getLogger(DaoHotelFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return escrito;
    }
}
