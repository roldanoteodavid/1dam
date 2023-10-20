package org.example.service;

import lombok.Data;
import org.example.dao.DaoHotelFicheros;
import org.example.dao.DaoReservas;
import org.example.dao.DaoReservasImplementacion;
import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class GestionReservas implements IGestionReservas{
    private final DaoReservas daoReservas;

    public GestionReservas() {
        this.daoReservas = new DaoReservasImplementacion();
    }
    public GestionReservas(Hotel hotel) {
        this.daoReservas = new DaoReservasImplementacion(hotel);
    }


    @Override
    public Hotel getHotel() {
        return daoReservas.getHotel();
    }

    @Override
    public List<Actividad> verMisActividades(Cliente cliente, boolean ascendente) {
        return daoReservas.verMisActividades(cliente, ascendente);
    }

    @Override
    public List<Actividad> listarActividades(boolean ascendente) {
        return daoReservas.listarActividades(ascendente);
    }

    @Override
    public boolean anyadirCliente(Cliente cliente) {
        return daoReservas.anyadirCliente(cliente);
    }

    @Override
    public boolean iniciarSesion(String dni, String contrasenya) {
        return daoReservas.iniciarSesion(dni,contrasenya);
    }

    @Override
    public Cliente clientePorDni(String dni) {
        return daoReservas.clientePorDni(dni);
    }

    @Override
    public boolean addReserva(Cliente cliente, Reserva reserva) {
        return daoReservas.addReserva(cliente, reserva);
    }

    @Override
    public boolean modificarContrasenya(String dni, String contrasenya) {
        return daoReservas.modificarContrasenya(dni, contrasenya);
    }

    @Override
    public boolean cancelarReserva(int id, Cliente cliente) {
        return daoReservas.cancelarReserva(id, cliente);
    }

    @Override
    public boolean reservarActividad(int id, Cliente cliente) {
        return daoReservas.reservarActividad(id, cliente);
    }

    @Override
    public boolean cancelarActividad(int id, Cliente cliente) {
        return daoReservas.cancelarActividad(id, cliente);
    }

    @Override
    public List<Reserva> verReservas(boolean ascendente, Cliente cliente) {
        return daoReservas.verReservas(ascendente, cliente);
    }

    @Override
    public boolean modificarReservaFecha(int id, LocalDate entrada, LocalDate salida, Cliente cliente) {
        return daoReservas.moficarReservaFecha(id, entrada, salida, cliente);
    }

    @Override
    public List<Habitacion> obtenerHabitaciones(LocalDate entrada, LocalDate salida) {
        return daoReservas.obtenerHabitaciones(entrada, salida);
    }

    @Override
    public int obtenerCosto(Reserva reserva) {
        return daoReservas.obtenerCosto(reserva);
    }

    @Override
    public boolean escribirFicheroBinario() {
        return DaoHotelFicheros.escribirFicheroBinario(daoReservas.getHotel());
    }

    @Override
    public boolean cargarFicheroBinario() {
        boolean cargado = false;
        Hotel hotel = DaoHotelFicheros.leerFicheroBinario();
        if (hotel != null) {
            daoReservas.setHotel(hotel);
            cargado = true;
        }
        return cargado;
    }


}
