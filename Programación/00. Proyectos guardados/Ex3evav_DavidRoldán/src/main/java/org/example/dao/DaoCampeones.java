package org.example.dao;

import org.example.common.IdException;
import org.example.domain.Campeon;

import java.util.List;
import java.util.Map;

public interface DaoCampeones {
    List<Campeon> getListaCampeones();
    void setListaCampeones(List<Campeon> campeones);
    List<Campeon> listadoOrdenadoNombre(boolean ascendente);
    boolean addCampeon(Campeon campeon) throws IdException;
    List<Campeon> consulta(double ataque1, double ataque2);
    boolean actualizarBurst(int id, double burst);
    Campeon confirmarRemoveCampeon(int id);
    boolean removeCampeon(int id);
    Map<String,List<Campeon>> getCampeonesHabilidad();
}
