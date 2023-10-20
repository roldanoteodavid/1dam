package org.example.service;

import org.example.common.CategoriaException;
import org.example.domain.Alojamiento;
import org.example.domain.Hotel;

import java.io.IOException;
import java.util.List;

public interface ServiciosAlojamientos {
    boolean isEmptyAlojamientosList();
    List<Alojamiento> getListaAlojamientos();
    boolean addAlojamiento(Alojamiento alojamiento)throws CategoriaException;
    List<Alojamiento> consulta(String provincia, double precio1, double precio2);
    void removeAlojamiento(Alojamiento alojamiento);
    List<Alojamiento> alojamientosPorValoracionMedia(String provincia);

    boolean actualizarCategoria(String nombre, int categoria) throws CategoriaException;

    List<Hotel> consultaHoteles(boolean ascendente);
    List<Alojamiento> getListaAlojamientosProvincia(String provincia);
    void crearFicheros()throws IOException;
    boolean cargarFichero() throws IOException;
    boolean cargarFichero(String fichero) throws IOException;
    boolean escribirFichero();
    boolean escribirFicheroBinario();
    boolean cargarFicheroBinario();


}
