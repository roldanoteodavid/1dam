package org.example.service;

import org.example.common.CategoriaException;
import org.example.domain.Alojamiento;
import org.example.domain.Hotel;

import java.io.IOException;
import java.util.List;

public interface ServiciosAlojamientos {
    boolean anyadirAlojamiento(Alojamiento alojamiento);

    List<Alojamiento> listarAlojamientosProvPre(String provincia, double preciomin, double preciomax);

    List<Alojamiento> listarAlojamientosValoracionMedia(String provincia);

    boolean actualizarCategoria(String nombre, int categoria) throws CategoriaException;

    void crearFicheros() throws IOException;

    boolean escribirFicheroBinario();

    boolean escribirFichero();

    boolean cargarFichero() throws IOException;

    boolean cargarFicheroBinario();

    boolean eliminarAlojamiento(Alojamiento alojamiento);

    List<Hotel> listarHoteles(boolean ascendente);

}
