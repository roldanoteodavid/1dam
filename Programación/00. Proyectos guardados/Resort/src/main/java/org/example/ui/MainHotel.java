package org.example.ui;

import org.example.common.Constantes;
import org.example.dao.DaoHotelFicheros;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainHotel {

    public void main() {
        Scanner teclado = new Scanner(System.in);
        try {
            DaoHotelFicheros.crearFicheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean fin = false;
        int opcion = 0;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    GestionarClientes clientes = new GestionarClientes();
                    clientes.gestion();
                    break;
                case 2:
                    GestionarHotel hotel = new GestionarHotel();
                    hotel.gestion();
                    break;
                case 3:
                    System.out.println(Constantes.HA_ELEGIDO_SALIR);
                    fin = true;
                    break;
                default:
                    System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
            }
        } while (!fin);
    }
    public static int mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_1_SI_ERES_CLIENTE_2_SI_ERES_ADMINISTRADOR_O_3_PARA_SALIR);
        boolean vuelve = false;
        int num = 0;
        while (!vuelve) {
            try {
                num = teclado.nextInt();
                vuelve = true;
                //has metido un número!!
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.TIENES_QUE_INTRODUCIR_UN_NÚMERO_NO_UNA_LETRA);
                teclado.nextLine();
            }
        }
        return num;
    }


}
