package org.example.ui;

import org.example.common.CategoriaException;
import org.example.common.Constantes;
import org.example.domain.Alojamiento;
import org.example.domain.CasaRural;
import org.example.domain.Hotel;
import org.example.service.ServiciosAlojamientos;
import org.example.service.ServiciosAlojamientosImpl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainAlojamientos {
    private final ServiciosAlojamientos serviciosAlojamientos;

    public MainAlojamientos() {
        this.serviciosAlojamientos = new ServiciosAlojamientosImpl();
    }

    public void main() {
        Scanner s = new Scanner(System.in);
        int opcion;
        try {
            crearFicheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(serviciosAlojamientos.getListaAlojamientos());
        do {
            System.out.println();
            System.out.println(Constantes.MENU);
            opcion = s.nextInt();
            s.nextLine();
            System.out.println();
            switch (opcion) {
                case 1:
                    añadirAlojamiento();
                    break;
                case 2:
                    System.out.println(Constantes.INTRODUCE_PROVINCIA);
                    String provincia = s.nextLine();
                    System.out.println(Constantes.INTRODUCE_PRECIO_MINIMO);
                    double precio1 = s.nextDouble();
                    System.out.println(Constantes.INTRODUCE_PRECIO_MAXIMO);
                    double precio2 = s.nextDouble();
                    System.out.println();
                    System.out.println(serviciosAlojamientos.consulta(provincia, precio1, precio2));
                    break;
                case 3:
                    alojamientosPorValoracionMedia();
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
                        System.out.println(Constantes.ERROR_DE_E_S);
                    }
                    break;
                case 8:
                    cargarFicheroBinario();
                    break;
                case 9:
                    eliminarAlojamiento();
                    break;
                case 10:
                    consultaHoteles();
                    break;
                case 11:
                    System.out.println(serviciosAlojamientos.getListaAlojamientos());
                    break;
                case 12:
                    System.out.println(Constantes.GRACIAS_POR_USAR_LA_APLICACIÓN);
                    break;
                default:
                    System.out.println(Constantes.ELIJA_UNA_OPCION_ENTRE_1_Y_12);
                    break;

            }
        } while (opcion != 12);
    }

    private void escribirFichero() {
        if (serviciosAlojamientos.escribirFichero()) {
            System.out.println(Constantes.SE_HA_GUARDADO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.NO_SE_HA_GUARDADO);
        }
    }

    private void crearFicheros() throws IOException {
        serviciosAlojamientos.crearFicheros();
    }

    private void escribirFicheroBinario() {
        if (serviciosAlojamientos.escribirFicheroBinario()) {
            System.out.println(Constantes.SE_HA_GUARDADO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.NO_SE_HA_GUARDADO);
        }
    }

    private void cargarFicheroBinario() {
        if (serviciosAlojamientos.cargarFicheroBinario()) {
            System.out.println(Constantes.FICHERO_BINARIO_CARGADO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.ERROR_AL_CARGAR_FICHERO_BINARIO);
        }
    }

    private void cargarFichero() throws IOException {
        if (serviciosAlojamientos.cargarFichero()) {
            System.out.println(Constantes.FICHERO_CARGADO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.ERROR_AL_CARGAR_FICHERO);
        }
    }

    public void añadirAlojamiento() {
        Scanner s = new Scanner(System.in);
        System.out.println(Constantes.INTRODUCE_NOMBRE);
        String nombre = s.nextLine();
        System.out.println(Constantes.INTRODUCE_PROVINCIA);
        String provincia = s.nextLine();
        System.out.println(Constantes.INTRODUCE_PRECIO);
        double precio = s.nextDouble();
        s.nextLine();
        System.out.println(Constantes.HOTEL_O_CASARURAL);
        String tipo = s.nextLine();
        if (!tipo.equalsIgnoreCase(Constantes.HOTEL) && !tipo.equalsIgnoreCase(Constantes.CASARURAL)) {
            System.out.println(Constantes.SOLO_SE_PUEDEN_INTRODUCIR_HOTEL_O_CASA_RURAL);
        } else {
            Alojamiento nuevo = null;
            if (tipo.equalsIgnoreCase(Constantes.HOTEL)) {
                int categoria;
                System.out.println(Constantes.INTRODUCE_CATEGORIA);
                categoria = s.nextInt();
                s.nextLine();
                nuevo = new Hotel(nombre, provincia, precio, new ArrayList<>(), categoria);
            } else if (tipo.equalsIgnoreCase(Constantes.CASARURAL)) {
                System.out.println(Constantes.PISCINA_TRUE_FALSE);
                boolean piscina = s.nextBoolean();
                nuevo = new CasaRural(nombre, provincia, precio, new ArrayList<>(), piscina);
                System.out.println(Constantes.CASA_RURAL_DADA_DE_ALTA);
            }
            try {
                boolean ok = serviciosAlojamientos.addAlojamiento(nuevo);
                if (ok) {
                    System.out.println(Constantes.ALOJAMIENTO_AÑADIDO_CORRECTAMENTE);
                } else {
                    System.out.println(Constantes.EL_ALOJAMIENTO_NO_AÑADIDO);
                }
            } catch (CategoriaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void alojamientosPorValoracionMedia() {
        Scanner s = new Scanner(System.in);
        System.out.println(Constantes.INTRODUCE_PROVINCIA);
        String provincia = s.nextLine();
        System.out.println(serviciosAlojamientos.alojamientosPorValoracionMedia(provincia));

    }

    private void actualizarCategoria() {
        Scanner s = new Scanner(System.in);
        int categoria;
        System.out.println(Constantes.INTRODUCE_NOMBRE);
        String nombre = s.nextLine();
        System.out.println(Constantes.INTRODUCE_CATEGORIA);
        categoria = s.nextInt();
        s.nextLine();
        try {
            boolean ok = serviciosAlojamientos.actualizarCategoria(nombre, categoria);
            if (ok) {
                System.out.println(Constantes.CATEGORIA_ACTUALIZADA_CORRECTAMENTE);
            } else {
                System.out.println(Constantes.CATEGORIA_NO_ACTUALIZADA);
            }
        } catch (CategoriaException e) {
            System.out.println(e.getMessage());
        }

    }


    private void consultaHoteles() {
        Scanner s = new Scanner(System.in);
        boolean ascendente = false;
        System.out.println(Constantes.ORDEN_ASCENDENTE_O_DESCENDENTE);
        String orden = s.nextLine();
        if (!orden.equalsIgnoreCase(Constantes.ASCENDENTE) && !orden.equalsIgnoreCase(Constantes.DESCENDENTE)) {
            System.out.println(Constantes.INTRODUZCA_ASCENDENTE_O_DESCENDENTE);
        } else {
            if (orden.equalsIgnoreCase(Constantes.ASCENDENTE)) {
                ascendente = true;
            }
            System.out.println(serviciosAlojamientos.consultaHoteles(ascendente));
        }
    }


    private void eliminarAlojamiento() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce Provincia");
        String provincia = s.nextLine();
        serviciosAlojamientos.getListaAlojamientosProvincia(provincia).stream().forEachOrdered(alojamiento -> {
            System.out.println(Constantes.ELIMINAR + alojamiento.getClass().getSimpleName() + " " + alojamiento.getNombre() + Constantes.S_N);
            String respuesta = s.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                serviciosAlojamientos.removeAlojamiento(alojamiento);
            }
        });

    }


}
