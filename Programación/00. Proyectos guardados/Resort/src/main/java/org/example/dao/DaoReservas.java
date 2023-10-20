package org.example.dao;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;

public interface DaoReservas {
    Hotel getHotel();
    List<Actividad> verMisActividades(Cliente cliente, boolean ascendente);
    List<Actividad> listarActividades(boolean ascendente);
    void setHotel(Hotel hotel);
    boolean anyadirCliente(Cliente cliente);
    boolean iniciarSesion(String dni, String contrasenya);
    boolean addReserva(Cliente cliente, Reserva reserva);
    boolean modificarContrasenya(String dni, String contrasenya);
    boolean cancelarReserva(int id, Cliente cliente);
    boolean reservarActividad(int id, Cliente cliente);
    boolean cancelarActividad(int id, Cliente cliente);
    List<Reserva> verReservas(boolean ascendente,Cliente cliente);
    Cliente clientePorDni(String dni);
    boolean moficarReservaFecha(int id, LocalDate entrada, LocalDate salida, Cliente cliente);
    List<Habitacion> obtenerHabitaciones(LocalDate entrada, LocalDate salida);
    int obtenerCosto(Reserva reserva);

    //boolean modificar

}
