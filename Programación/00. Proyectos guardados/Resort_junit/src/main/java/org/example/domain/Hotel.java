package org.example.domain;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.example.common.AlFrancesException;
import org.example.common.LugarException;
import org.example.common.TipoException;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public @Data class Hotel implements Serializable {
    private List<Actividad> actividades;
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;

    public Hotel() {
        actividades = new ArrayList<>();
        habitaciones = new ArrayList<>();
        clientes = new ArrayList<>();
        try {
            Actividad act1 = new Actividad(1, "escalada", "rocodromo", 15);
            Actividad act2 = new Actividad(2, "natación", "piscina", 10);
            Actividad act3 = new Actividad(3, "badminton", "playa", 12);
            Actividad act4 = new Actividad(4, "yoga", "gimnasio", 10);
            Actividad act5 = new Actividad(5, "aquagym", "piscina", 20);
            Actividad act6 = new Actividad(6, "rapel", "rocodromo", 25);
            actividades.add(act1);
            actividades.add(act2);
            actividades.add(act3);
            actividades.add(act4);
            actividades.add(act5);
            actividades.add(act6);
            Habitacion hab1 = new Habitacion(1, 2, "doble");
            Habitacion hab2 = new Habitacion(1, 4, "quad");
            Habitacion hab3 = new Habitacion(1, 2, "doble");
            Habitacion hab4 = new Habitacion(1, 6, "king");
            Habitacion hab5 = new Habitacion(1, 6, "king");
            Habitacion hab6 = new Habitacion(1, 4, "quad");
            habitaciones.add(hab1);
            habitaciones.add(hab2);
            habitaciones.add(hab3);
            habitaciones.add(hab4);
            habitaciones.add(hab5);
            habitaciones.add(hab6);
            Cliente cli1 = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
            Cliente cli2 = new Cliente("16008692B", "Ramiro", LocalDate.of(1973, 4, 1), "+52 695498108", "México", "1234");
            Cliente cli3 = new Cliente("36008692Y", "Julia", LocalDate.of(1945, 6, 30), "+54 609126096", "Argentina", "1234");
            Cliente cli4 = new Cliente("86048692Z", "Brytiago", LocalDate.of(1993, 8, 7), "+1 719063092", "Puerto Rico", "1234");
            Cliente cli5 = new Cliente("76008692X", "Carlota", LocalDate.of(2000, 2, 12), "+39 691095287", "Italia", "1234");
            clientes.add(cli1);
            clientes.add(cli2);
            clientes.add(cli3);
            clientes.add(cli4);
            clientes.add(cli5);
        } catch (LugarException | TipoException | AlFrancesException e) {
            throw new RuntimeException(e);
        }
    }

    public  void convertirJson(){
        Gson gson = new Gson();
        String actividadesJson = gson.toJson(actividades);
        try (FileWriter fileWriter = new FileWriter("actividades.json")) {
            fileWriter.write(actividadesJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Actividad> leerJson() {
        Gson gson = new Gson();
        try {
            File archivo = new File("actividades.json");
            if (!archivo.exists()) {
                archivo.createNewFile();
                return actividades;
            }
            try (FileReader fileReader = new FileReader(archivo)) {
                Type actividadListType = new TypeToken<ArrayList<Actividad>>(){}.getType();
                actividades = gson.fromJson(fileReader, actividadListType);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return actividades;
    }

}
