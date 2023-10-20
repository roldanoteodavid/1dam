package com.example.dao;
import cofig.Configuration;
import com.example.common.CategoriaException;
import com.example.domain.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class DaoElementosFicheros {
    private Configuration config;
    private static int contador = 0;
    public static final String FICHERO = "Fichero";
    public static final String FICHEROB = "FicheroBinario";
    public static void crearFicheros() throws IOException {
        File fichero1 = new File(FICHERO);
        File fichero2 = new File(FICHEROB);
        if (!fichero1.exists()){
            fichero1.createNewFile();
            ArrayList<Elemento> elementos = new Elementos();
            try (PrintWriter pw = new PrintWriter(new FileWriter("Fichero"))) //Si no existe, PW no lo crea, de ahí el FW, y por si queréis hacer append
            {
                for (int i = 0; i < elementos.size(); i++) {
                    pw.println(elementos.get(i).toStringFile());
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (!fichero2.exists())
            fichero2.createNewFile();
    }
    public static List<Elemento> leerFichero() throws IOException {
        return leerFichero(DaoElementosFicheros.FICHERO);
    }
    public static List<Elemento> leerFichero(String fichero) throws IOException {
        crearFicheros();
        ArrayList<Elemento> auxiliar = null;
        try (Scanner sc = new Scanner(new File(fichero))) {
            auxiliar = new ArrayList<>();
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                //crear elemento y añadirlo a auxiliar.
                try {
                    Elemento elemento = new Elemento(Integer.parseInt(trozos[0]), Integer.parseInt(trozos[1]), trozos[2], trozos[3]);
                    auxiliar.add(elemento);
                } catch (CategoriaException e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoElementosFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

        }
        return auxiliar;
    }
    public static List<Elemento> cargarFichero() {
        List<Elemento> listaE=new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(Paths.get(Configuration.getInstance().getProperty("pathLista")), StandardCharsets.UTF_8);
            lines.forEach(line -> {
                String[] article = line.split(";");
                try {
                    listaE.add(new Elemento(Integer.parseInt(article[0]), Integer.parseInt(article[1]), article[2], article[3]));
                } catch (CategoriaException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaE;
    }

    public static boolean escribirFichero(Elemento elemento){
        boolean resultado = false;
        contador++;
        try {
            if(contador==1) {
                Path path = Paths.get(Configuration.getInstance().getProperty("pathLista"));
                BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
                bufferedWriter.write(elemento.toStringFile());
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
            else {
                FileWriter fileWriter = new FileWriter(Configuration.getInstance().getProperty("pathLista"), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(elemento.toStringFile());
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
            resultado = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /**
     * Ejemplo de lectura de fichero binario. Pensad cómo utilizarlo para guardar y recuperar partida, guardando el objeto juego
     * en vez del ArrayList
     * @return
     */
    public static Juego cargarFicheroBinario() {
        Juego auxiliar = null;
        File file = new File(FICHEROB);
        if (file.exists()) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
                auxiliar = (Juego) is.readObject();

            } catch (IOException | ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(DaoElementosFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return auxiliar;
    }


    public static boolean escribirFicheroBinario(Juego juego) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROB))) {
            os.writeObject(juego);
            escrito = true;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DaoElementosFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return escrito;
    }
  }
