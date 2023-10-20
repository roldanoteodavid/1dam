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

    boolean addReserva(Reserva reserva, String dni);

    List<Cliente> verClientes(boolean ascendente);

    boolean borrarCliente(String dni);

    boolean anyadirCliente(Cliente cliente);

    Map<String,List<Cliente>> clientesporPais();

    boolean modificarNombreCliente(String dni, String nombre);

    List<Reserva> listarReservasFecha(boolean ascendente, Cliente cliente);

    List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha);

    boolean isEmptyReservasList();

    boolean anyadirActividad(Actividad actividad);

    boolean borrarActividad(int id);

    List<Actividad> listarActividades(boolean ascendente);

    Map<String,Long> numeroClientesPais();

    boolean escribirFicheroBinario();

    boolean cargarFicheroBinario();
}
