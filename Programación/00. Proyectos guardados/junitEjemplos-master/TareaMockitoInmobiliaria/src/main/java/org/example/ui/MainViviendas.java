package org.example.ui;

import org.example.common.Comprobacion;
import org.example.common.m2Exception;
import org.example.common.Constantes;
import org.example.domain.Vivienda;
import org.example.service.ServiciosViviendas;
import org.example.service.ServiciosViviendasImpl;
import java.util.Scanner;

public class MainViviendas {
    private final ServiciosViviendas serviciosViviendas;

    public MainViviendas() {
        this.serviciosViviendas = new ServiciosViviendasImpl();
    }

    public void main() {
        Scanner s = new Scanner(System.in);
        int opcion;
        System.out.println(serviciosViviendas.getListaViviendas());
        do {
            System.out.println();
            System.out.println(Constantes.MENU);
            opcion = s.nextInt();
            s.nextLine();
            System.out.println();
            switch (opcion) {
                case 1:
                    añadirVivienda();
                    break;
                case 2:
                    System.out.println(Constantes.INTRODUCE_PROVINCIA);
                    String provincia = s.nextLine();
                    System.out.println(Constantes.INTRODUCE_PRECIO_MINIMO);
                    double precio1 = s.nextDouble();
                    System.out.println(Constantes.INTRODUCE_PRECIO_MAXIMO);
                    double precio2 = s.nextDouble();
                    System.out.println();
                    System.out.println(serviciosViviendas.consulta(provincia, precio1, precio2));
                    break;
                case 3:
                    actualizarM2();
                    break;
                case 4:
                    eliminarVivienda();
                    break;
                case 5:
                    consultaViviendas();
                    break;
                case 6:
                    System.out.println(serviciosViviendas.getListaViviendas());
                    break;
                case 7:
                    System.out.println(Constantes.GRACIAS_POR_USAR_LA_APLICACIÓN);
                    break;
                default:
                    System.out.println(Constantes.ELIJA_UNA_OPCION_ENTRE_1_Y_7);
                    break;

            }
        } while (opcion != 7);
    }

    public void añadirVivienda() {
        Scanner s = new Scanner(System.in);
        System.out.println((Constantes.INTRODUCE_ID));
        int id = s.nextInt();
        s.nextLine();
        System.out.println(Constantes.INTRODUCE_CALLE);
        String calle = s.nextLine();
        System.out.println((Constantes.INTRODUCE_NUMERO));
        int numero = s.nextInt();
        s.nextLine();
        System.out.println(Constantes.INTRODUCE_PROVINCIA);
        String provincia = s.nextLine();
        System.out.println(Constantes.INTRODUCE_PRECIO);
        double precio = s.nextDouble();
        s.nextLine();
        System.out.println(Constantes.INTRODUCE_M2);
        double m2 = s.nextDouble();
        Vivienda nuevo = null;
        s.nextLine();
        try {
            nuevo = new Vivienda(id,calle, numero, provincia, precio, m2);
            boolean ok = serviciosViviendas.addVivienda(nuevo);
            if (ok) {
                System.out.println(Constantes.VIVIENDA_AÑADIDA_CORRECTAMENTE);
            } else {
                System.out.println(Constantes.VIVIENDA_NO_AÑADIDA);
            }
        } catch (m2Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    private void actualizarM2() {
        Scanner s = new Scanner(System.in);
        double m2;
        System.out.println(Constantes.INTRODUCE_ID);
        int id = s.nextInt();
        System.out.println(Constantes.m2);
        m2 = s.nextDouble();
        s.nextLine();
        try {
            Comprobacion.m2Ok(m2);
            boolean ok = serviciosViviendas.actualizarm2(id, m2);
            if (ok) {
                System.out.println(Constantes.VIVIENDA_ACTUALIZADA_CORRECTAMENTE);
            } else {
                System.out.println(Constantes.VIVIENDA_NO_ACTUALIZADA_CORRECTAMENTE);
            }
        } catch (m2Exception e) {
            System.out.println(e.getMessage());
        }

    }


    private void consultaViviendas() {
        Scanner s = new Scanner(System.in);
        boolean ascendente = false;
        System.out.println(Constantes.INTRODUCE_CALLE);
        String calle = s.nextLine();
        System.out.println(Constantes.ORDEN_ASCENDENTE_O_DESCENDENTE);
        String orden = s.nextLine();
        if (!orden.equalsIgnoreCase(Constantes.ASCENDENTE) && !orden.equalsIgnoreCase(Constantes.DESCENDENTE)) {
            System.out.println(Constantes.INTRODUZCA_ASCENDENTE_O_DESCENDENTE);
        } else {
            if (orden.equalsIgnoreCase(Constantes.ASCENDENTE)) {
                ascendente = true;
            }
            System.out.println(serviciosViviendas.consultaViviendas(calle, ascendente));
        }
    }


    private void eliminarVivienda() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce Provincia");
        String provincia = s.nextLine();
        serviciosViviendas.getListaViviendasProvincia(provincia).stream().forEachOrdered(vivienda -> {
            System.out.println(Constantes.ELIMINAR + vivienda.getClass().getSimpleName() + " " + vivienda.getCalle() + Constantes.S_N);
            String respuesta = s.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                serviciosViviendas.removeVivienda(vivienda);
            }
        });

    }


}
