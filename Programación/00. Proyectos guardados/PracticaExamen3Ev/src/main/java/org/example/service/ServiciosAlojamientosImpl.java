package org.example.service;

import org.example.common.CategoriaException;
import org.example.common.Comprobacion;
import org.example.dao.DaoAlojamientoFicheros;
import org.example.dao.DaoAlojamientos;
import org.example.dao.DaoAlojamientosImpl;
import org.example.domain.Alojamiento;
import org.example.domain.Hotel;

import java.io.IOException;
import java.util.List;

public class ServiciosAlojamientosImpl implements ServiciosAlojamientos {
    private final DaoAlojamientos daoAlojamientos;

    public ServiciosAlojamientosImpl() {
        this.daoAlojamientos = new DaoAlojamientosImpl();
    }

    public ServiciosAlojamientosImpl(DaoAlojamientos daoAlojamientos) {
        this.daoAlojamientos = daoAlojamientos;
    }

    @Override
    public boolean anyadirAlojamiento(Alojamiento alojamiento) {
        return daoAlojamientos.anyadirAlojamiento(alojamiento);
    }

    @Override
    public List<Alojamiento> listarAlojamientosProvPre(String provincia, double preciomin, double preciomax) {
        return daoAlojamientos.listarAlojamientosProvPre(provincia, preciomin, preciomax);
    }

    @Override
    public List<Alojamiento> listarAlojamientosValoracionMedia(String provincia) {
        return daoAlojamientos.listarAlojamientosValoracionMedia(provincia);
    }

    @Override
    public boolean actualizarCategoria(String nombre, int categoria) throws CategoriaException {
        Comprobacion.categoriaOk(categoria);
        return daoAlojamientos.actualizarCategoria(nombre, categoria);
    }

    @Override
    public void crearFicheros() throws IOException {
        DaoAlojamientoFicheros.crearFicheros();
    }

    @Override
    public boolean escribirFicheroBinario() {
        return DaoAlojamientoFicheros.escribirFicheroBinario(daoAlojamientos.getListaAlojamientos());
    }

    @Override
    public boolean escribirFichero() {
        return DaoAlojamientoFicheros.escribirFichero(daoAlojamientos.getListaAlojamientos());
    }

    @Override
    public boolean cargarFichero() throws IOException {
        boolean cargado = false;
        List<Alojamiento> alojamientos = DaoAlojamientoFicheros.cargarFichero();
        if (alojamientos != null && alojamientos.size() != 0) {
            daoAlojamientos.setListaAlojamientos(alojamientos);
            cargado = true;
        }
        return cargado;
    }

    @Override
    public boolean cargarFicheroBinario() {
        boolean cargado = false;
        List<Alojamiento> alojamientos = DaoAlojamientoFicheros.cargarFicheroBinario();
        if (alojamientos != null && alojamientos.size() != 0) {
            daoAlojamientos.setListaAlojamientos(alojamientos);
            cargado = true;
        }
        return cargado;
    }

    @Override
    public boolean eliminarAlojamiento(Alojamiento alojamiento) {
        return daoAlojamientos.eliminarAlojamiento(alojamiento);
    }

    @Override
    public List<Hotel> listarHoteles(boolean ascendente) {
        return daoAlojamientos.listarHoteles(ascendente);
    }
}
