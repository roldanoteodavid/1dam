package org.example.dao;

import org.example.common.CategoriaException;
import org.example.common.ComparacionPorCategoriaNombre;
import org.example.common.ComparacionPorValoracionMedia;
import org.example.common.Comprobacion;
import org.example.domain.Alojamiento;
import org.example.domain.Hotel;

import java.util.List;
import java.util.stream.Collectors;

public class DaoAlojamientosImpl implements DaoAlojamientos {

    private final Database database;

    public DaoAlojamientosImpl() {
        this.database = new Database();
    }

    public DaoAlojamientosImpl(Database database) {
        this.database = database;
    }

    public List<Alojamiento> getListaAlojamientos() {
        return database.getListaAlojamientos();
    }


    public boolean addAlojamiento(Alojamiento alojamiento) {
        List<Alojamiento> lista = database.getListaAlojamientos();
        return lista.add(alojamiento);
    }

    public List<Alojamiento> consulta(String provincia, double precio1, double precio2) {
        return database.getListaAlojamientos(). stream().filter(alojamiento -> alojamiento.getProvincia().equals(provincia)
                && alojamiento.getPrecio() >= precio1
                && alojamiento.getPrecio() <= precio2).collect(Collectors.toList());
    }

    public List<Alojamiento> alojamientosPorValoracionMedia(String provincia) {
        return database.getListaAlojamientos().stream()
                .filter(alojamiento -> alojamiento.getProvincia().equals(provincia))
                .sorted(new ComparacionPorValoracionMedia() )
                .collect(Collectors.toList());
    }

    public boolean actualizarCategoria(String nombre, int categoria) {
        Hotel h = database.getListaAlojamientos().stream()
                .filter(Hotel.class::isInstance)
                .map(Hotel.class::cast)
                .filter(hotel -> hotel.getNombre().equals(nombre)).findFirst().orElse(null);
        if (h != null) {
            try {
                Comprobacion.categoriaOk(categoria);
                h.setCategoria(categoria);
                return true;
            } catch (CategoriaException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public List<Hotel> consultaHoteles(boolean ascendente) {
        return database.getListaAlojamientos().stream()
                .filter(Hotel.class::isInstance)
                .map(Hotel.class::cast)
                .sorted(ascendente ? new ComparacionPorCategoriaNombre() : new ComparacionPorCategoriaNombre().reversed())
                .collect(Collectors.toList());
    }

    public List<Alojamiento> getListaAlojamientosProvincia(String provincia) {
        return database.getListaAlojamientos().stream()
                .filter(alojamiento -> alojamiento.getProvincia().equals(provincia))
                .collect(Collectors.toList());
    }

    public void removeAlojamiento(Alojamiento alojamiento) {
        database.getListaAlojamientos().remove(alojamiento);
    }

    public void setAlojamientos(List<Alojamiento> alojamientos) {
        database.setListaAlojamientos(alojamientos);
    }


    public boolean isEmptyAlojamientosList() {
        return database.getListaAlojamientos().isEmpty();
    }
}
