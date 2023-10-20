package org.example.ui;

import org.example.common.AlFrancesException;
import org.example.common.Constantes;
import org.example.dao.DaoHotelFicheros;
import org.example.domain.*;
import org.example.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestionarClientes {
    private final IGestionReservas serviciosReservas;
    private Cliente cliente;

    public GestionarClientes() {
        this.serviciosReservas = new GestionReservas(DaoHotelFicheros.leerFicheroBinario());
    }

    public void gestion() {
        Scanner teclado = new Scanner(System.in);
        boolean valido = false;
        do {
            System.out.println(Constantes.INTRODUZCA_1_PARA_INICIAR_SESIÓN_2_PARA_REGISTRARSE_Y_3_PARA_SALIR);
            int opcion = obtenerNumero();
            switch (opcion) {
                case 1:
                    boolean entrar = false;
                    while (!entrar) {
                        System.out.println(Constantes.INTRODUZCA_SU_USUARIO_DNI);
                        String dni = teclado.nextLine();
                        System.out.println(Constantes.INTRODUZCA_LA_CONTRASEÑA);
                        if (serviciosReservas.iniciarSesion(dni, teclado.nextLine())) {
                            entrar = true;
                            cliente = serviciosReservas.clientePorDni(dni);
                            sacarMenu();
                            valido = true;
                        } else {
                            System.out.println(Constantes.CONTRASEÑA_O_USUARIO_INCORRECTO);
                        }
                    }
                    break;
                case 2:
                    if (registrarse()) {
                        valido = true;
                        sacarMenu();
                    }
                    break;
                case 3:
                    System.out.println(Constantes.HA_ELEGIDO_SALIR);
                    DaoHotelFicheros.escribirFicheroBinario(serviciosReservas.getHotel());
                    valido = true;
                    break;
                default:
                    System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
            }
        } while (!valido);
    }

    public boolean registrarse() {
        Scanner teclado = new Scanner(System.in);
        boolean iniciado = false;
        System.out.println(Constantes.INTRODUZCA_SU_DNI);
        String dni = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_SU_NOMBRE);
        String nombre = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_SU_TELÉFONO);
        String telefono = teclado.nextLine();
        boolean passvalid = false;
        String contrasenya = null;
        do {
            System.out.println(Constantes.INTRODUZCA_SU_CONTRASEÑA);
            contrasenya = teclado.nextLine();
            Pattern p = Pattern.compile("^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$");
            Matcher mat = p.matcher(contrasenya);
            if (mat.matches()) {
                passvalid = true;
            } else {
                System.out.println(Constantes.CONTRASEÑA_NO_VALIDA);
            }

        } while (!passvalid);
        System.out.println(Constantes.INTRODUZCA_SU_PAÍS);
        String pais = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_SU_DÍA_DE_NACIMIENTO);
        int dia = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_SU_MES_DE_NACIMIENTO);
        int mes = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_SU_AÑO_DE_NACIMIENTO);
        int anyo = teclado.nextInt();
        try {
            Cliente cliente = new Cliente(dni, nombre, LocalDate.of(anyo, mes, dia), telefono, pais, contrasenya);
            if (serviciosReservas.anyadirCliente(cliente)) {
                System.out.println(Constantes.CLIENTE_REGISTRADO);
                iniciado = true;
            } else {
                System.out.println(Constantes.ERROR_AL_REGISTRARSE);
            }
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
        return iniciado;
    }

    public void sacarMenu() {

        //cliente = serviciosReservas.clientePorDni(dni);
        int opcion = 0;
        do {
            System.out.println(Constantes.INTRODUZCA_1_PARA_GESTIONAR_LAS_RESERVAS_2_PARA_GESTIONAR_LAS_ACTIVIDADES_3_PARA_CAMBIAR_LA_CONTRASEÑA_Y_4_PARA_SALIR);
            opcion = obtenerNumero();
            switch (opcion) {
                case 1:
                    System.out.println(Constantes.INTRODUZCA_1_PARA_AÑADIR_UNA_RESERVA_2_PARA_CANCELAR_UNA_RESERVA_3_PARA_VER_SUS_RESERVAS_4_PARA_MODIFICAR_LA_FECHA_DE_UNA_RESERVA_EXISTENTE_Y_5_PARA_SALIR);
                    opcion = obtenerNumero();
                    switch (opcion) {
                        case 1 -> anyadirReserva();
                        case 2 -> cancelarReserva();
                        case 3 -> verReservas();
                        case 4 -> modificarReservaFecha();
                        case 5 -> System.out.println(Constantes.HAS_ELEGIDO_SALIR);
                        default -> System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
                    }

                    break;
                case 2:
                    System.out.println(Constantes.INTRODUZCA_1_PARA_RESERVAR_UNA_ACTIVIDAD_2_PARA_CANCELAR_UNA_ACTIVIDAD_3_PARA_VER_SUS_ACTIVIDADES_Y_4_PARA_SALIR);
                    opcion = obtenerNumero();
                    switch (opcion) {
                        case 1 -> anyadirActividad();
                        case 2 -> cancelarActividad();
                        case 3 -> verMisActividades();
                        case 4 -> System.out.println(Constantes.HAS_ELEGIDO_SALIR);
                        default -> System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
                    }
                    break;
                case 3:
                    modificarContrasenya();
                    break;
                case 4:
                    System.out.println(Constantes.HA_ELEGIDO_SALIR);
                    break;
                default:
                    System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
            }

        } while (opcion != 10);
    }

    public static int obtenerNumero() {
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

    public void anyadirReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.INTRODUCE_EL_DIA_MES_Y_AÑO_DE_LA_LLEGADA);
        System.out.println(Constantes.DÍA);
        int dia = sc.nextInt();
        System.out.println(Constantes.MES);
        int mes = sc.nextInt();
        System.out.println(Constantes.AÑO);
        int anyo = sc.nextInt();
        sc.nextLine();
        LocalDate entrada = LocalDate.of(anyo, mes, dia);
        System.out.println(Constantes.INTRODUCE_EL_DIA_MES_Y_AÑO_DE_LA_SALIDA);
        System.out.println(Constantes.DÍA);
        int dia2 = sc.nextInt();
        System.out.println(Constantes.MES);
        int mes2 = sc.nextInt();
        System.out.println(Constantes.AÑO);
        int anyo2 = sc.nextInt();
        sc.nextLine();
        LocalDate salida = LocalDate.of(anyo2, mes2, dia2);
        List<Habitacion> aux = serviciosReservas.obtenerHabitaciones(entrada, salida);
        System.out.println(aux);
        System.out.println(Constantes.INTRODUCE_EL_NUMERO_DE_LAS_HABITACIONES_QUE_VAS_A_NECESITAR);
        int opcion = obtenerNumero();
        List<Integer> habitaciones = new ArrayList<>();
        for (int i = 0; i < opcion; i++) {
            System.out.println(Constantes.INTRODUCE_EL_ID_DE_LA_HABITACIÓN_DESEADA);
            int habitacion = obtenerNumero();
            for (int j = 0; j < aux.size(); j++) {
                if (((Integer) aux.get(j).getNumero()).equals(habitacion)) {
                    habitaciones.add(habitacion);
                    System.out.println(Constantes.HABITACIÓN_AÑADIDA);
                }
            }
        }
        System.out.println(Constantes.INTRODUCE_EL_NUMERO_DE_INQUILINOS);
        int personas = sc.nextInt();
        sc.nextLine(); //ID
        Reserva reserva = new Reserva(5,entrada, salida, cliente.getDni(), personas, habitaciones);
        reserva.setCosto(serviciosReservas.obtenerCosto(reserva));
        serviciosReservas.addReserva(cliente, reserva);
    }

    public void cancelarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.INTRODUCE_EL_ID_DE_LA_RESERVA);
        serviciosReservas.cancelarReserva(sc.nextInt());
    }

    public void verReservas() {
        boolean sigue = false;
        boolean ascendente = false;
        do {

            System.out.println(Constantes.PULSE_1_SI_LO_QUIERE_DE_MANERA_ASCENDENTE_Y_2_SI_LO_QUIERE_DESCENDENTE);
            int opcion = obtenerNumero();
            switch (opcion) {
                case 1:
                    ascendente = true;
                    sigue = true;
                case 2:
                    sigue = true;
                default:
            }
        } while (!sigue);
        System.out.println(serviciosReservas.verReservas(ascendente, cliente));
    }

    public void modificarReservaFecha() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.INTRODUCE_EL_DIA_MES_Y_AÑO_DE_LA_NUEVA_FECHA_DE_LLEGADA);
        LocalDate entrada = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println(Constantes.INTRODUCE_EL_DIA_MES_Y_AÑO_DE_LA_NUEVA_FECHA_DE_SALIDA);
        LocalDate salida = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println(Constantes.INTRODUCE_EL_ID_DE_LA_RESERVA1);
        int id = sc.nextInt();
        serviciosReservas.modificarReservaFecha(id, entrada, salida);

    }

    public void anyadirActividad() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DE_LA_ACTIVIDAD);
        int id = sc.nextInt();
        System.out.println(Constantes.INTRODUCE_EL_DIA_MES_Y_AÑO_DE_TU_FECHA_DE_LLEGADA);
        LocalDate entrada = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println(Constantes.INTRODUCE_EL_DIA_MES_Y_AÑO_DE_TU_FECHA_DE_SALIDA);
        LocalDate salida = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        if (serviciosReservas.reservarActividad(id, cliente))
            System.out.println(Constantes.ACTIVIDAD_RESERVADA_CN_EXITO);
    }

    public void cancelarActividad() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DE_LA_ACTIVIDAD_QUE_DESEAS_CANCELAR);
        serviciosReservas.cancelarActividad(sc.nextInt(), cliente);
    }

    public void verMisActividades() {
        Scanner teclado = new Scanner(System.in);
        boolean ascendente = true;
        System.out.println(Constantes.INTRODUZCA_1_SI_DESEA_VER_LA_LISTA_ASCENDENTE_O_2_PARA_DESCENDENTE);
        int opcion = obtenerNumero();
        if (opcion == 1) {
            ascendente = true;
        } else if (opcion == 2) {
            ascendente = false;
        }
        System.out.println(serviciosReservas.verMisActividades(cliente, ascendente));
    }

    public void modificarContrasenya() {
        Scanner teclado = new Scanner(System.in);
        String contrasenya = null;
        for (boolean coinciden = false; !coinciden; ) {
            boolean passvalid = false;
            do {
                System.out.println(Constantes.INTRODUCE_UNA_NUEVA_CONTRASEÑA);
                contrasenya = teclado.nextLine();
                Pattern p = Pattern.compile("^(?=.*[0-9])"
                        + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=.*[@#$%^&+=])"
                        + "(?=\\S+$).{8,20}$");
                Matcher mat = p.matcher(contrasenya);
                if (mat.matches()) {
                    passvalid = true;
                } else {
                    System.out.println(Constantes.CONTRASEÑA_NO_VALIDA);
                }
            } while (!passvalid);
            System.out.println(Constantes.CONFIRMAR_CONTRASEÑA);
            String cotrasenya2 = teclado.nextLine();
            if (contrasenya.equalsIgnoreCase(cotrasenya2))
                coinciden = true;
        }
        serviciosReservas.modificarContrasenya(cliente.getDni(), contrasenya);
    }

}
