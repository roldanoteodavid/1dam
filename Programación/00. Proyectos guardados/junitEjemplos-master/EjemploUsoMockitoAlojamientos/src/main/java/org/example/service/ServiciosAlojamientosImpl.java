package org.example.service;

import org.example.common.CategoriaException;
import org.example.common.Comprobacion;
import org.example.dao.DaoAlojamientos;
import org.example.dao.DaoAlojamientosFicheros;
import org.example.dao.DaoAlojamientosImpl;
import org.example.domain.Alojamiento;
import org.example.domain.Hotel;

import java.io.IOException;
import java.util.List;

public class ServiciosAlojamientosImpl implements ServiciosAlojamientos{

    private final DaoAlojamientos daoAlojamientos;


    public ServiciosAlojamientosImpl() {
        this.daoAlojamientos = new DaoAlojamientosImpl();

    }
    public ServiciosAlojamientosImpl(DaoAlojamientos daoAlojamientos) {
        this.daoAlojamientos = daoAlojamientos;
    }

    public boolean isEmptyAlojamientosList(){
        return daoAlojamientos.isEmptyAlojamientosList();
    }
    public List<Alojamiento> getListaAlojamientos() {
        return daoAlojamientos.getListaAlojamientos();
    }

    public boolean addAlojamiento(Alojamiento alojamiento) throws CategoriaException {
         if (alojamiento instanceof Hotel)
             Comprobacion.categoriaOk(((Hotel) alojamiento).getCategoria());
         return daoAlojamientos.addAlojamiento(alojamiento);
     }

    public List<Alojamiento> consulta(String provincia, double precio1, double precio2) {

        if (precio1 > precio2) {
            double aux = precio1;
            precio1 = precio2;
            precio2 = aux;
        }
        return daoAlojamientos.consulta(provincia, precio1, precio2);
    }

    public List<Alojamiento> alojamientosPorValoracionMedia(String provincia) {

        return daoAlojamientos.alojamientosPorValoracionMedia(provincia);
    }

    public boolean actualizarCategoria(String nombre, int categoria) throws CategoriaException {

        Comprobacion.categoriaOk(categoria);
        return daoAlojamientos.actualizarCategoria(nombre, categoria);
    }


    public List<Hotel> consultaHoteles(boolean ascendente) {

        return daoAlojamientos.consultaHoteles(ascendente);
    }

    public List<Alojamiento> getListaAlojamientosProvincia(String provincia) {

        return daoAlojamientos.getListaAlojamientosProvincia(provincia);
    }

    public void removeAlojamiento(Alojamiento alojamiento) {
        daoAlojamientos.removeAlojamiento(alojamiento);
    }

    public void crearFicheros() throws IOException {
        DaoAlojamientosFicheros.crearFicheros();
    }
    public boolean cargarFichero() throws IOException {
        return cargarFichero(DaoAlojamientosFicheros.FICHERO);
    }
    public boolean cargarFichero(String fichero) throws IOException {
        boolean cargado = false;
        List<Alojamiento> alojamientos = DaoAlojamientosFicheros.leerFichero(fichero);
        if (alojamientos != null  && alojamientos.size()!=0) {
            daoAlojamientos.setAlojamientos(alojamientos);
            cargado = true;
        }
        return cargado;
    }

    public boolean escribirFichero() {
        return DaoAlojamientosFicheros.escribirFichero(daoAlojamientos.getListaAlojamientos());
    }

    public boolean escribirFicheroBinario() {
        return DaoAlojamientosFicheros.escribirFicheroBinario(daoAlojamientos.getListaAlojamientos());
    }

    public boolean cargarFicheroBinario() {
        boolean cargado = false;
        List<Alojamiento> alojamientos =DaoAlojamientosFicheros.leerFicheroBinario();
        if (alojamientos != null) {
            daoAlojamientos.setAlojamientos(alojamientos);
            cargado = true;
        }
        return cargado;
    }
}

