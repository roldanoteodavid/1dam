package com.example.ui;

import com.example.common.CategoriaException;
import com.example.common.Constantes;
import com.example.dao.DaoElementosFicheros;
import com.example.dao.IdException;
import com.example.service.GestionElementos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase con métodos de administración para consola
 */
public class GestionDiccionario {
    private static final String pass = "2223";

    public static void gestion() {
        Scanner teclado = new Scanner(System.in);
        GestionElementos gestionElementos = new GestionElementos(DaoElementosFicheros.cargarFichero());
        System.out.println(Constantes.INTRODUZCA_CONTRASEÑA);
        if (teclado.nextLine().equals(pass)) {
            System.out.println(Constantes.CONTRASEÑA_CORRECTA);
            int opcion = 0;
            do {
                opcion = mostrarMenu();
                switch (opcion) {

                    case 1:
                        listarOrdenados(gestionElementos);
                        break;
                    case 2:
                        try {
                            insertarElemento(gestionElementos);
                        } catch (CategoriaException | IdException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        modificarElemento(gestionElementos);
                        break;
                    case 4:
                        eliminarElemento(gestionElementos);
                        break;
                    case 5:
                        System.out.println(Constantes.HA_ELEGIDO_SALIR);
                        gestionElementos.escribirFichero();
                        break;
                    default:
                        System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
                }

            } while (opcion != 5);
        } else {
            System.out.println(Constantes.CONTRASEÑA_INCORRECTA);
        }
    }

    public static int mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.MENU + "\n" + Constantes.OPCION1 + "\n" + Constantes.OPCION2 + "\n" + Constantes.OPCION3 + "\n" + Constantes.OPCION4 + "\n" + Constantes.OPCION5);
        boolean vuelve = false;
        int num = 0;
        while (!vuelve) {
            try {
                System.out.println(Constantes.INTRODUCE_NÚMERO);
                num = teclado.nextInt();
                vuelve = true;
                //has metido un número!!
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.TIENES_QUE_INTRODUCIR_UN_NÚMERO_NO_UNA_LETRA);
                System.out.println(exception.getMessage());
                teclado.nextLine();
            }
        }
        return num;
    }

    public static void listarOrdenados(GestionElementos gestionElementos) {
        Scanner teclado = new Scanner(System.in);
        boolean ascendente = true;
        boolean vuelve = false;
        int num = 0;
        while (!vuelve) {
            try {
                System.out.println(Constantes.INTRODUCE_1_PARA_LISTAR_DE_FORMA_ASCENDENTE_O_2_PARA_DESCENDENTE);
                num = teclado.nextInt();
                if (num == 1) {
                    vuelve = true;
                } else if (num == 2) {
                    ascendente = false;
                    vuelve = true;
                }
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.TIENES_QUE_INTRODUCIR_UN_NÚMERO_NO_UNA_LETRA1);
                System.out.println(exception.getMessage());
                teclado.nextLine();
            }
        }
        System.out.println(gestionElementos.listarElementosOrdenados(ascendente).toString());
    }

    public static void insertarElemento(GestionElementos gestionElementos) throws CategoriaException, IdException {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DEL_NUEVO_ELEMENTO);
        int id = teclado.nextInt();
        gestionElementos.idOk(id);
        System.out.println(Constantes.INTRODUZCA_EL_NIVEL_DEL_NUEVO_ELEMENTO);
        int nivel = teclado.nextInt();
        teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_LA_INCÓGNITA_DEL_NUEVO_ELEMENTO);
        String incognita = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_LA_CATEGORÍA_DEL_NUEVO_ELEMENTO);
        String categoria = teclado.nextLine();
        gestionElementos.insertarElemento(id, nivel, incognita, categoria);
    }

    public static void modificarElemento(GestionElementos gestionElementos) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DEL_ELEMENTO_QUE_DESEA_MODIFICAR);
        int id = teclado.nextInt();
        boolean vuelve = false;
        int num = 0;
        while (!vuelve) {
            try {
                System.out.println(Constantes.INTRODUZCA_1_PARA_MODIFICAR_LA_INCÓGNITA_O_2_PARA_LA_CATEGORÍA);
                num = teclado.nextInt();
                teclado.nextLine();
                if (num == 1) {
                    vuelve = true;
                    System.out.println(Constantes.INTRODUZCA_LA_NUEVA_INCÓGNITA);
                    if (!gestionElementos.modificarElemento(id, teclado.nextLine())) {
                        System.out.println(Constantes.EL_ID_INTRODUCIDO_ES_INCORRECTO);
                    } else {
                        System.out.println(Constantes.MODIFICADA);
                    }
                } else if (num == 2) {
                    vuelve = true;
                    System.out.println(Constantes.INTRODUZCA_LA_NUEVA_CATEGORÍA);
                    if (!gestionElementos.modificarElemento(id, teclado.nextLine())) {
                        System.out.println(Constantes.EL_ID_O_LA_CATEGORÍA_INTRODUCIDA_ES_INCORRECTA);
                    } else {
                        System.out.println(Constantes.MODIFICADA1);
                    }
                }
                //has metido un número!!
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.TIENES_QUE_INTRODUCIR_UN_NÚMERO_NO_UNA_LETRA2);
                System.out.println(exception.getMessage());
                teclado.nextLine();
            }
        }
    }

    public static void eliminarElemento(GestionElementos gestionElementos) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DEL_ELEMENTO_QUE_DESEA_ELIMINAR);
        int id = teclado.nextInt();
        if (!gestionElementos.eliminarElemento(id)) {
            System.out.println(Constantes.EL_ID_INTRODUCIDO_ES_INCORRECTO);
        } else {
            System.out.println(Constantes.ELIMINADA);
        }
    }
}
