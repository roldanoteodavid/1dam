package org.example.dao;

import org.example.common.ComparacionValoracionMedia;
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

    @Override
    public List<Alojamiento> getListaAlojamientos() {
        return database.getAlojamientos();
    }

    @Override
    public void setListaAlojamientos(List<Alojamiento> alojamientos) {
        database.setAlojamientos(alojamientos);
    }

    @Override
    public boolean anyadirAlojamiento(Alojamiento alojamiento) {
        return getListaAlojamientos().add(alojamiento);
    }

    @Override
    public List<Alojamiento> listarAlojamientosProvPre(String provincia, double preciomin, double preciomax) {
        return getListaAlojamientos().stream().filter(alojamiento -> alojamiento.getProvincia().equals(provincia) && alojamiento.getPrecio() >= preciomin && alojamiento.getPrecio() <= preciomax).collect(Collectors.toList());
    }

    @Override
    public List<Alojamiento> listarAlojamientosValoracionMedia(String provincia) {
        return getListaAlojamientos().stream()
                .filter(alojamiento -> alojamiento.getProvincia().equals(provincia))
                .sorted(new ComparacionValoracionMedia())
                .collect(Collectors.toList());
    }

    @Override
    public boolean actualizarCategoria(String nombre, int categoria) {
        boolean actualizado = false;
        Hotel hotel = getListaAlojamientos().stream()
                .filter(Hotel.class::isInstance)
                .map(Hotel.class::cast)
                .filter(h -> h.getNombre().equals(nombre)).findFirst().orElse(null);
        if (hotel != null) {
            hotel.setCategoria(categoria);
            actualizado = true;
        }
        return actualizado;
    }

    @Override
    public boolean eliminarAlojamiento(Alojamiento alojamiento) {
        return getListaAlojamientos().remove(alojamiento);
    }

    @Override
    public List<Hotel> listarHoteles(boolean ascendente) {
        return getListaAlojamientos().stream()
                .filter(Hotel.class::isInstance)
                .map(Hotel.class::cast)
                .sorted(ascendente ? new ComparacionValoracionMedia() : new ComparacionValoracionMedia().reversed())
                .collect(Collectors.toList());
    }
}
