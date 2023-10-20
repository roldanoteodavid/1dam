package org.example.ui;

import org.example.common.CategoriaException;
import org.example.common.Comprobacion;
import org.example.domain.CasaRural;
import org.example.domain.Hotel;
import org.example.service.ServiciosAlojamientos;
import org.example.service.ServiciosAlojamientosImpl;

import java.io.IOException;
import java.util.Scanner;

public class MainAlojamientos {
    private final ServiciosAlojamientos serviciosAlojamientos;

    public MainAlojamientos() {
        serviciosAlojamientos = new ServiciosAlojamientosImpl();
    }

    public void main() {
        Scanner teclado = new Scanner(System.in);
        try {
            crearFicheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int opcion = 0;
        do {
            System.out.println("menú");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    try {
                        anyadirAlojamientos();
                    } catch (CategoriaException e) {
                        System.out.println(e.getMessage());
                        ;
                    }
                    break;
                case 2:
                    consultarAlojamientos();
                    break;
                case 3:
                    alojamientosProValo();
                    break;
                case 4:
                    actualizarCategoria();
                    break;
                case 5:
                    escribirFicheroBinario();
                    break;
                case 6:
                    escribirFichero();
                    break;
                case 7:
                    try {
                        cargarFichero();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    cargarFicheroBinario();
                    break;
                case 9:
                    eliminarAlojamiento();
                    break;
                case 10:
                    listarHoteles();
                    break;
                case 11:
                    System.out.println("Ha elegido salir.");
                    break;
                default:
                    System.out.println("Introduzca una opción entre 1 y 11.");

            }
        } while (opcion != 11);
    }

    private void anyadirAlojamientos() throws CategoriaException {
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int opcion = 0;
            do {
                System.out.println("Pulsa 1 para crear un hotel o 2 para crear una casa rural.");
                opcion = teclado.nextInt();
                teclado.nextLine();
            } while (opcion != 1 && opcion != 2);
            System.out.println("Introduzca el nombre del alojamiento.");
            String nombre = teclado.nextLine();
            System.out.println("Introduzca la provincia.");
            String provincia = teclado.nextLine();
            System.out.println("Introduzca el precio.");
            double precio = teclado.nextDouble();
            if (opcion == 1) {
                System.out.println("Introduzca la categoría del hotel.");
                int categoria = teclado.nextInt();
                teclado.nextLine();
                Comprobacion.categoriaOk(categoria);
                Hotel hotel = new Hotel(nombre, provincia, precio, categoria);
                serviciosAlojamientos.anyadirAlojamiento(hotel);
            } else {
                int piscina = 0;
                do {
                    System.out.println("Introduzca 1 si la casa tiene piscina o 2 si no.");
                    piscina = teclado.nextInt();
                    teclado.nextLine();
                } while (piscina != 1 && piscina != 2);
                boolean pisci = false;
                if (piscina == 1) {
                    pisci = true;
                }
                CasaRural casaRural = new CasaRural(nombre, provincia, precio, pisci);
                serviciosAlojamientos.anyadirAlojamiento(casaRural);
            }
        }
    }

    private void consultarAlojamientos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca provincia.");
        String provincia = teclado.nextLine();
        System.out.println("Introduzca precio mínimo.");
        double preciomin = teclado.nextDouble();
        System.out.println("Introduzca precio máximo.");
        double preciomax = teclado.nextDouble();
        teclado.nextLine();
        System.out.println(serviciosAlojamientos.listarAlojamientosProvPre(provincia, preciomin, preciomax));
    }

    private void alojamientosProValo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca la provincia.");
        String provincia = teclado.nextLine();
        System.out.println(serviciosAlojamientos.listarAlojamientosValoracionMedia(provincia));
    }

    private void actualizarCategoria() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el nombre del hotel que deses modificar.");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca nueva categoría.");
        int categoria = teclado.nextInt();
        teclado.nextLine();
        try {
            boolean actualizada = serviciosAlojamientos.actualizarCategoria(nombre, categoria);
            if (actualizada) {
                System.out.println("Categoría actualizada");
            } else {
                System.out.println("Error al actualizar la categoría");
            }
        } catch (CategoriaException e) {
            System.out.println(e.getMessage());
        }
    }

    private void escribirFicheroBinario() {
        serviciosAlojamientos.escribirFicheroBinario();
    }

    private void escribirFichero() {
        serviciosAlojamientos.escribirFichero();
    }

    private void cargarFichero() throws IOException {
        if (serviciosAlojamientos.cargarFichero()) {
            System.out.println("Fichero cargado.");
        } else {
            System.out.println("Error al cargar el fichero.");
        }
    }

    private void cargarFicheroBinario() {
        if (serviciosAlojamientos.cargarFicheroBinario()) {
            System.out.println("Fichero binario cargado.");
        } else {
            System.out.println("Error al cargar el fichero.");
        }
    }

    private void eliminarAlojamiento() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce Provincia");
        String provincia = s.nextLine();
        serviciosAlojamientos.listarAlojamientosValoracionMedia(provincia).stream().forEach(alojamiento -> {
            System.out.println("Eliminar" + alojamiento.getClass().getSimpleName() + " " + alojamiento.getNombre() + " (S/N)?");
            String respuesta = s.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                serviciosAlojamientos.eliminarAlojamiento(alojamiento);
            }
        });
    }

    private void listarHoteles() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca 1 si desea listar los hoteles de forma ascendente o 2 si desea de forma descendente.");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        boolean ascendente = true;
        if (opcion == 2) {
            ascendente = false;
        }
        System.out.println(serviciosAlojamientos.listarHoteles(ascendente));
    }

    private void crearFicheros() throws IOException {
        serviciosAlojamientos.crearFicheros();
    }
}