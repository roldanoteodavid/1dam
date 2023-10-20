package org.example.dao;

import org.example.common.CategoriaException;
import org.example.domain.Alojamiento;
import org.example.domain.Hotel;

import java.util.List;

public interface DaoAlojamientos {
    List<Alojamiento> getListaAlojamientos();

    void setListaAlojamientos(List<Alojamiento> alojamientos);

    boolean anyadirAlojamiento(Alojamiento alojamiento);

    List<Alojamiento> listarAlojamientosProvPre(String provincia, double preciomin, double preciomax);

    List<Alojamiento> listarAlojamientosValoracionMedia(String provincia);

    boolean actualizarCategoria(String nombre, int categoria);

    boolean eliminarAlojamiento(Alojamiento alojamiento);

    List<Hotel> listarHoteles(boolean ascendente);
}
