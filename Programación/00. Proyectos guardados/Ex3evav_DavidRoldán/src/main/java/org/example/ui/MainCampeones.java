package org.example.ui;

import org.example.common.Constantes;
import org.example.common.HabilidadException;
import org.example.common.HabilidadRepetidaException;
import org.example.common.IdException;
import org.example.domain.Asesino;
import org.example.domain.Campeon;
import org.example.domain.Mago;
import org.example.service.ServiceInterface;
import org.example.service.ServiceInterfaceImpl;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainCampeones {
    private final ServiceInterface serviceInterface;

    public MainCampeones() {
        this.serviceInterface = new ServiceInterfaceImpl();
    }

    public MainCampeones(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public void main() {
        try {
            crearFicheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println(Constantes.MENU_1_VER_CAMPEONES_2_VER_CAMPEONES_ORDENADOS_3_AÑADIR_UN_CAMPEÓN_4_CONSULTAR_CAMPEONES_CON_UN_RANGO_DE_DAÑO_5_ACTUALIZAR_LA_PROBABILIDAD_DE_BURST_DE_UN_CAMPEÓN_6_ELIMINAR_UN_CAMPEÓN_7_ESCRIBIR_FICHERO_8_CARGAR_FICHERO_9_ESCRIBIR_FICHERO_BINARIO_10_CARGAR_FICHERO_BINARIO_11_MAPA_CAMPEONES_CON_CADA_HABILIDAD_12_SALIR);
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    verListaCampeones();
                    break;
                case 2:
                    verListaOrdenada();
                    break;
                case 3:
                    anyadirCampeon();
                    break;
                case 4:
                    consultarCampeonesRango();
                    break;
                case 5:
                    actualizarBurst();
                    break;
                case 6:
                    eliminarCampeon();
                    break;
                case 7:
                    escribirFichero();
                    break;
                case 8:
                    try {
                        cargarFichero();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 9:
                    escribirFicheroBinario();
                    break;
                case 10:
                    cargarFicheroBinario();
                    break;
                case 11:
                    getCampeonesHabilidad();
                    break;
                case 12:
                    System.out.println(Constantes.HA_ELEGIDO_SALIR);
                    break;
                default:
                    System.out.println(Constantes.INTRODUZCA_UNA_OPCIÓN_VÁLIDA);
            }
        } while (opcion != 12);
    }

    private int mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        boolean valido = false;
        do {
            try {
                opcion = teclado.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INTRODUZCA_UN_NÚMERO);
                teclado.nextLine();
            }

        } while (!valido);
        return opcion;
    }

    private void verListaCampeones() {
        System.out.println(serviceInterface.getListaCampeones());
    }

    private void verListaOrdenada() {
        Scanner teclado = new Scanner(System.in);
        boolean ascendente = true;
        System.out.println(Constantes.INTRODUZCA_1_SI_DESEA_VER_LA_LISTA_DE_MANERA_ASCENDENTE_O_2_PARA_DESCENDENTE);
        if (teclado.nextInt() == 2) {
            ascendente = false;
        }
        teclado.nextLine();
        System.out.println(serviceInterface.listadoOrdenadoNombre(ascendente));
    }

    private void anyadirCampeon() {
        Scanner teclado = new Scanner(System.in);
        int tipo = 0;
        do {
            System.out.println(Constantes.INTRODUZCA_1_SI_DESEA_AÑADIR_UN_MAGO_O_2_PARA_AÑADIR_UN_ASESINO);
            tipo = mostrarMenu();
        } while (tipo != 1 && tipo != 2);
        System.out.println(Constantes.INTRODUZCA_EL_IDENTIFICADOR_DEL_CAMPEÓN);
        int id = teclado.nextInt();
        teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_NOMBRE_DEL_CAMPEÓN);
        String nombre = teclado.nextLine();
        System.out.println(Constantes.INTRODUZCA_EL_ATAQUE_DEL_CAMPEÓN);
        Double ataque = teclado.nextDouble();
        System.out.println(Constantes.INTRODUZCA_EL_NÚMERO_DE_SKINS_QUE_TIENE);
        int skins = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_LA_ALTURA);
        int altura = teclado.nextInt();
        int cantidad = 0;
        do {
            System.out.println(Constantes.INTRODUZCA_CUANTAS_HABILIDADES_DESEA_QUE_TENGA_EL_CAMPEÓN_1_5);
            cantidad = mostrarMenu();
        } while (cantidad <= 0 && cantidad >= 6);
        teclado.nextLine();
        List<String> habilidades = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println(Constantes.INTRODUZCA_LA_HABILIDAD + (i + 1));
            habilidades.add(teclado.nextLine());
        }
        if (tipo == 1) {
            int stunt = 0;
            boolean stun = false;
            do {
                System.out.println(Constantes.INTRODUZCA_1_SI_EL_STUND_DE_SU_CAMPEON_PERMITE_QUE_EL_ADVERSARIO_PUEDE_ATACAR_O_2_SI_NO);
                stunt = mostrarMenu();
            } while (stunt != 1 && stunt != 2);
            if (stunt == 1) {
                stun = true;
            }
            try {
                serviceInterface.addCampeon(new Mago(id, nombre, ataque, skins, habilidades, altura, stun));
            } catch (HabilidadException | HabilidadRepetidaException | IdException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(Constantes.INTRODUZCA_LA_PROBABILIDAD_DE_QUE_HAGA_UN_BURST_AL_ADVERSARIO);
            double probabilidad = teclado.nextDouble();
            try {
                serviceInterface.addCampeon(new Asesino(id, nombre, ataque, skins, habilidades, altura, probabilidad));
            } catch (HabilidadException | HabilidadRepetidaException | IdException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void consultarCampeonesRango() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ATAQUE_MÍNIMO);
        double ataquemin = teclado.nextDouble();
        System.out.println(Constantes.INTRODUZCA_EL_ATAQUE_MÁXIMO);
        double ataquemax = teclado.nextDouble();
        teclado.nextLine();
        System.out.println(serviceInterface.consulta(ataquemin, ataquemax));
    }

    private void actualizarBurst() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DEL_MAGO_AL_QUE_LE_DESEA_ACTUALIZAR_LA_PROBABILIDAD_DE_BURST);
        int idactualizar = teclado.nextInt();
        System.out.println(Constantes.INTRODUZCA_LA_NUEVA_PROBABILIDAD_DE_BURST);
        double probabilidad = teclado.nextDouble();
        teclado.nextLine();
        if (serviceInterface.actualizarBurst(idactualizar, probabilidad)) {
            System.out.println(Constantes.EL_BURST_HA_SIDO_ACTUALIZADO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.ERROR_AL_ACTUALIZAR_EL_BURST_DEL_CAMPEÓN_INDICADO);
        }
    }

    private void eliminarCampeon() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_EL_ID_DEL_CAMPEÓN_QUE_DESEA_ELIMINAR);
        int idborrar = teclado.nextInt();
        if (serviceInterface.confirmarRemoveCampeon(idborrar) != null) {
            System.out.println(Constantes.SI_DESEA_BORRAR_AL_CAMPEON + serviceInterface.confirmarRemoveCampeon(idborrar) + Constantes.INTRODUZCA_1);
            if (teclado.nextInt() == 1) {
                serviceInterface.removeCampeon(idborrar);
            }
            teclado.nextLine();
        } else {
            System.out.println(Constantes.NO_EXISTE_NINGÚN_CAMPEÓN_CON_EL_ID_INDICADO);
        }

    }

    private void crearFicheros() throws IOException {
        serviceInterface.crearFicheros();
    }

    private void escribirFichero() {
        if (serviceInterface.escribirFichero()) {
            System.out.println(Constantes.FICHERO_ESCRITO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.ERROR_AL_ESCRIBIR_EL_FICHERO);
        }
    }

    private void cargarFichero() throws IOException {
        if (serviceInterface.cargarFichero() != null) {
            System.out.println(Constantes.FICHERO_CARGADO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.ERROR_AL_CARGAR_EL_FICHERO);
        }
    }

    private void escribirFicheroBinario() {
        if (serviceInterface.escribirFicheroBinario()) {
            System.out.println(Constantes.FICHERO_ESCRITO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.ERROR_AL_ESCRIBIR_EL_FICHERO);
        }
    }

    private void cargarFicheroBinario() {
        if (serviceInterface.cargarFicheroBinario() != null) {
            System.out.println(Constantes.FICHERO_CARGADO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.ERROR_AL_CARGAR_EL_FICHERO);
        }
    }

    private void getCampeonesHabilidad() {
        Map<String, List<Campeon>> porHabilidad = serviceInterface.getCampeonesHabilidad();
        porHabilidad.forEach((k, v) -> {
            System.out.println(k + ": " + v.stream().collect(Collectors.toList()));
        });
        porHabilidad.forEach((k, v) -> {
            int suma = (int) v.stream().count();
            //int suma = v.stream().mapToInt().sum();
            System.out.println(k + " total de " + suma);
        });
    }

}
