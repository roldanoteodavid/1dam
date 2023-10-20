package org.example.ui;

import org.example.common.AlFrancesException;
import org.example.common.Constantes;
import org.example.common.LugarException;
import org.example.common.TipoException;
import org.example.dao.DaoHotelFicheros;
import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Habitacion;
import org.example.service.GestionHotel;
import org.example.service.IGestionHotel;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionarHotel {
    private static final String pass = "2223";
    private final IGestionHotel serviciosHotel = null;

    /*public GestionarHotel() {
        this.serviciosHotel = new GestionHotel(DaoHotelFicheros.leerFicheroBinario());
    }*/

    public void gestion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_CONTRASEÑA);
        if (teclado.nextLine().equals(pass)) {
            System.out.println(Constantes.CONTRASEÑA_CORRECTA);
            int opcion = 0;
            do {
                System.out.println(Constantes.INTRODUZCA_1_PARA_GESTIONAR_LOS_CLIENTES_2_PARA_GESTIONAR_HABITACIONES_3_PARA_LAS_ACTIVIDADES_Y_4_PARA_SALIR);
                opcion = mostrarMenu();
                switch (opcion) {
                    case 1:
                        System.out.println(Constantes.INTRODUZCA_1_PARA_VER_LA_LISTA_DE_CLIENTES_2_PARA_AÑADIR_UN_CLIENTE_3_PARA_BORRAR_UN_CLIENTE_Y_4_PARA_SALIR);
                        opcion = mostrarMenu();
                        switch (opcion) {
                            case 1:
                                verClientes();
                                break;
                            case 2:
                                anyadirCliente();
                                break;
                            case 3:
                                borrarCliente();
                                break;
                            case 4:
                                System.out.println(Constantes.HA_ELEGIDO_SALIR);
                                break;
                            default:
                                System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
                        }
                        break;
                    case 2:
                        System.out.println(Constantes.INTRODUZCA_1_PARA_VER_LA_LISTA_DE_HABITACIONES_2_PARA_AÑADIR_UNA_HABITACIÓN_3_PARA_BORRAR_UNA_HABITACIÓN_4_PARA_COMPROBAR_LA_DISPONIBILIDAD_Y_5_PARA_SALIR);
                        opcion = mostrarMenu();
                        switch (opcion) {
                            case 1:
                                verHabitaciones();
                                break;
                            case 2:
                                anyadirHabitacion();
                                break;
                            case 3:
                                borrarHabitacion();
                                break;
                            case 4:
                                comprobarDisponibilidad();
                                break;
                            case 5:
                                System.out.println(Constantes.HA_ELEGIDO_SALIR);
                                break;
                            default:
                                System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
                        }
                        break;
                    case 3:
                        System.out.println(Constantes.INTRODUZCA_1_PARA_VER_LA_LISTA_DE_ACTIVIDADES_2_PARA_AÑADIR_UNA_ACTIVIDAD_3_PARA_AÑADIR_UNA_FECHA_A_UNA_ACTIVIDAD_4_PARA_BORRAR_UNA_ACTIVIDAD_Y_5_PARA_SALIR);
                        opcion = mostrarMenu();
                        switch (opcion) {
                            case 1:
                                verActividades();
                                break;
                            case 2:
                                anyadirActividad();
                                break;
                            case 3:
                                anyadirFechaActividad();
                                break;
                            case 4:
                                borrarActividad();
                                break;
                            case 5:
                                System.out.println(Constantes.HA_ELEGIDO_SALIR);
                                break;
                            default:
                                System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
                        }
                        break;
                    case 4:
                        System.out.println(Constantes.HA_ELEGIDO_SALIR);
                        DaoHotelFicheros.escribirFicheroBinario(serviciosHotel.getHotel());
                        break;
                    default:
                        System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
                }

            } while (opcion != 4);
        } else {
            System.out.println(Constantes.CONTRASEÑA_INCORRECTA);
        }
    }

    public static int mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
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

    public void anyadirHabitacion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_NÚMERO_DE_HABITACIÓN);
        int numero = teclado.nextInt();
        teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_LA_CAPACIDAD_DE_LA_HABITACIÓN);
        int capacidad = teclado.nextInt();
        teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_TIPO_DE_HABITACIÓN);
        String tipo = teclado.next();
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(numero, capacidad, tipo);
            if (this.serviciosHotel.anyadirHabitacion(habitacion)) {
                System.out.println(Constantes.AÑADIDA);
            } else {
                System.out.println(Constantes.ERROR_AL_AÑADIR_LA_HABITACIÓN);
            }
        } catch (TipoException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    public void borrarHabitacion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_NÚMERO_DE_LA_HABITACIÓN_QUE_DESEA_BORRAR);
        if (serviciosHotel.borrarHabitacion(teclado.nextInt())) {
            System.out.println(Constantes.HABITACIÓN_BORRADA);
        } else {
            System.out.println(Constantes.ERROR_AL_ELIMINAR_LA_HABITACIÓN);
        }
        teclado.nextLine();
    }

    public void comprobarDisponibilidad() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_DÍA);
        int dia = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_EL_MES);
        int mes = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_EL_AÑO);
        int anyo = teclado.nextInt();
        teclado.nextLine();
        serviciosHotel.comprobarDisponibilidad(LocalDate.of(anyo, mes, dia));
    }

    public void verClientes() {
        Scanner teclado = new Scanner(System.in);
        boolean ascendente = true;
        System.out.println(Constantes.INTRODUZCA_1_SI_DESEA_VER_LA_LISTA_ASCENDENTE_O_2_PARA_DESCENDENTE);
        int opcion = mostrarMenu();
        if (opcion == 1) {
            ascendente = true;
        } else if (opcion == 2) {
            ascendente = false;
        }
        System.out.println(serviciosHotel.verClientes(ascendente));
    }

    public void borrarCliente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_DNI_DEL_CLIENTE_QUE_DESEA_BORRAR);
        if (serviciosHotel.borrarCliente(teclado.nextLine())) {
            System.out.println(Constantes.CLIENTE_BORRADO);
        } else {
            System.out.println(Constantes.ERROR_AL_ELIMINAR_EL_CLIENTE);
        }
    }

    public void anyadirActividad() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DE_LA_ACTIVIDAD);
        int id = teclado.nextInt();
        teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_NOMBRE_DE_LA_ACTIVIDAD);
        String nombre = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_LUGAR_DONDE_SE_VA_AREALIZAR_LA_ACTIVIDAD);
        String lugar = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_PRECIO_DE_LA_ACTIVIDAD);
        int precio = teclado.nextInt();
        teclado.nextLine();
        try {
            if (serviciosHotel.anyadirActividad(new Actividad(id, nombre, lugar, precio))) {
                System.out.println(Constantes.ACTIVIDAD_AÑADIDA);
            } else {
                System.out.println(Constantes.ERROR_AL_AÑADIR_LA_ACTIVIDAD);
            }
        } catch (LugarException e) {
            System.out.println(e.getMessage());
        }
    }

    public void borrarActividad() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DE_LA_ACTIVIDAD_QUE_DESEA_BORRAR);
        if (serviciosHotel.borrarActividad(teclado.nextInt())) {
            System.out.println(Constantes.ACTIVIDAD_BORRADA);
        } else {
            System.out.println(Constantes.ERROR_AL_ELIMINAR_LA_ACTIVIDAD);
        }
        teclado.nextLine();
    }

    public void anyadirCliente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_DNI_DEL_CLIENTE);
        String dni = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_NOMBRE_DEL_CLIENTE);
        String nombre = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_TELÉFONO_DEL_CLIENTE);
        String telefono = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_LA_CONTRASEÑA_DEL_CLIENTE);
        String contrasenya = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_PAÍS_DEL_CLIENTE);
        String pais = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_DÍA_DE_NACIMIENTO_DEL_CLIENTE);
        int dia = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_EL_MES_DE_NACIMIENTO_DEL_CLIENTE);
        int mes = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_EL_AÑO_DE_NACIMIENTO_DEL_CLIENTE);
        int anyo = teclado.nextInt();
        teclado.nextLine();
        try {
            Cliente cliente = new Cliente(dni, nombre, LocalDate.of(anyo, mes, dia), telefono, pais, contrasenya);
            if (serviciosHotel.anyadirCliente(cliente)) {
                System.out.println(Constantes.CLIENTE_AÑADIDO);
            } else {
                System.out.println(Constantes.ERROR_AL_AÑADIR_EL_CLIENTE);
            }
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
        }
    }

    public void anyadirFechaActividad() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DE_LA_ACTIVIDAD);
        int id = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_EL_DÍA);
        int dia = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_EL_MES);
        int mes = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_EL_AÑO);
        int anyo = teclado.nextInt();
        teclado.nextLine();
        if (serviciosHotel.anyadirFechaActividad(LocalDate.of(anyo, mes, dia), id)) {
            System.out.println(Constantes.FECHA_AÑADIDA);
        } else {
            System.out.println(Constantes.ERROR_AL_AÑADIR_LA_FECHA);
        }
    }

    public void verHabitaciones() {
        Scanner teclado = new Scanner(System.in);
        boolean ascendente = true;
        System.out.println(Constantes.INTRODUZCA_1_SI_DESEA_VER_LA_LISTA_ASCENDENTE_O_2_PARA_DESCENDENTE);
        int opcion = mostrarMenu();
        if (opcion == 1) {
            ascendente = true;
        } else if (opcion == 2) {
            ascendente = false;
        }
        System.out.println(serviciosHotel.listarHabitaciones(ascendente));
    }

    public void verActividades() {
        Scanner teclado = new Scanner(System.in);
        boolean ascendente = true;
        System.out.println(Constantes.INTRODUZCA_1_SI_DESEA_VER_LA_LISTA_ASCENDENTE_O_2_PARA_DESCENDENTE);
        int opcion = mostrarMenu();
        if (opcion == 1) {
            ascendente = true;
        } else if (opcion == 2) {
            ascendente = false;
        }
        System.out.println(serviciosHotel.listarActividades(ascendente));
    }
}
