package org.example.service;

import org.example.common.HabilidadException;
import org.example.common.HabilidadRepetidaException;
import org.example.common.IdException;
import org.example.domain.Campeon;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ServiceInterface {
    List<Campeon> getListaCampeones();
    List<Campeon> listadoOrdenadoNombre(boolean ascendente);
    boolean addCampeon(Campeon campeon) throws HabilidadException, HabilidadRepetidaException, IdException;
    List<Campeon> consulta(double ataque1, double ataque2);
    boolean actualizarBurst(int id, double burst);
    Campeon confirmarRemoveCampeon(int id);
    boolean removeCampeon(int id);
    Map<String,List<Campeon>> getCampeonesHabilidad();
    void crearFicheros() throws IOException;
    List<Campeon> cargarFichero() throws IOException;
    boolean escribirFichero();
    boolean escribirFicheroBinario();
    List<Campeon> cargarFicheroBinario();
}
