package org.example.service;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IGestionHotel {
    Hotel getHotel();
    boolean anyadirHabitacion(Habitacion habitacion);

    boolean borrarHabitacion(int numeroHab);

    List<Habitacion> listarHabitaciones(boolean ascendente);

    boolean comprobarDisponibilidad(LocalDate date);

    boolean anyadirFechaActividad(LocalDate fecha, int id);
    boolean addReserva(Reserva reserva, String dni);//dni cliente

    List<Cliente> verClientes(boolean ascendente); //booleano

    boolean borrarCliente(String dni);

    boolean anyadirCliente(Cliente cliente);

    boolean modificarNombreCliente(String dni, String nombre);

    List<Reserva> listarReservasFecha(boolean ascendente, Cliente cliente); //por dni

    List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha);

    boolean isEmptyReservasList(); //borrar?

    boolean anyadirActividad(Actividad actividad);

    boolean borrarActividad(int id);

    List<Actividad> listarActividades(boolean ascendente); //booleano

    public Map<String,List<Cliente>> clientesporPais();

    public Map<String,Long> numeroClientesPais();

    boolean escribirFicheroBinario();

    boolean cargarFicheroBinario();
}
