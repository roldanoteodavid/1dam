package org.example.dao;

import org.example.domain.Alojamiento;
import org.example.domain.Hotel;

import java.util.List;

public interface DaoAlojamientos {


    List<Alojamiento> getListaAlojamientos() ;


    boolean addAlojamiento(Alojamiento alojamiento) ;

    List<Alojamiento> consulta(String provincia, double precio1, double precio2) ;
    List<Alojamiento> alojamientosPorValoracionMedia(String provincia) ;

    boolean actualizarCategoria(String nombre, int categoria) ;

    List<Hotel> consultaHoteles(boolean ascendente);

    List<Alojamiento> getListaAlojamientosProvincia(String provincia) ;

    void removeAlojamiento(Alojamiento alojamiento) ;

    void setAlojamientos(List<Alojamiento> alojamientos);
    boolean isEmptyAlojamientosList() ;
}
