package org.example.dao;

import org.example.common.*;
import org.example.domain.Asesino;
import org.example.domain.Campeon;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class DaoCampeonesImpl implements DaoCampeones {
    private final Database database;

    public DaoCampeonesImpl(Database database) {
        this.database = database;
    }

    public DaoCampeonesImpl() {
        this.database = new Database();
    }

    @Override
    public List<Campeon> getListaCampeones() {
        return database.getCampeones();
    }

    @Override
    public void setListaCampeones(List<Campeon> campeones) {
        database.setCampeones(campeones);
    }

    @Override
    public List<Campeon> listadoOrdenadoNombre(boolean ascendente) {
        List<Campeon> lista = getListaCampeones();
        lista.sort(Comparator.comparing(Campeon::getNombre));
        if (!ascendente) {

        }
        return getListaCampeones().stream()
                .sorted(ascendente ? new ComparacionNombre() : new ComparacionNombre().reversed())
                .collect(Collectors.toList());
    }

    @Override
    public boolean addCampeon(Campeon campeon) throws IdException {
        Comprobacion.idOk(campeon.getIdentificador(), getListaCampeones());
        return getListaCampeones().add(campeon);
    }

    @Override
    public List<Campeon> consulta(double ataque1, double ataque2) {
        return getListaCampeones().stream()
                .filter(campeon -> campeon.getAtaque() >= ataque1 && campeon.getAtaque() <= ataque2)
                .collect(Collectors.toList());
    }

    @Override
    public boolean actualizarBurst(int id, double burst) {
        boolean actualizado = false;
        Asesino asesino = getListaCampeones().stream()
                .filter(Asesino.class::isInstance)
                .map(Asesino.class::cast)
                .filter(asesino1 -> asesino1.getIdentificador() == id)
                .findFirst()
                .orElse(null);
        if (asesino != null) {
            asesino.setProbabilidadBurst(burst);
            actualizado = true;
        }
        return actualizado;
    }

    @Override
    public Campeon confirmarRemoveCampeon(int id) {
        return getListaCampeones().stream()
                .filter(asesino1 -> asesino1.getIdentificador() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean removeCampeon(int id) {
        return getListaCampeones().remove(getListaCampeones().stream()
                .filter(asesino1 -> asesino1.getIdentificador() == id)
                .findFirst()
                .orElse(null));
    }


    @Override
    public Map<String, List<Campeon>> getCampeonesHabilidad() {
        Map<String, List<Campeon>> mapHabilidad = new HashMap<>();
        mapHabilidad.put("inspiracion", getListaCampeones().stream().filter(campeon -> campeon.getHabilidades().contains("inspiracion")).collect(toList()));
        mapHabilidad.put("valor", getListaCampeones().stream().filter(campeon -> campeon.getHabilidades().contains("valor")).collect(toList()));
        mapHabilidad.put("brujeria", getListaCampeones().stream().filter(campeon -> campeon.getHabilidades().contains("brujeria")).collect(toList()));
        mapHabilidad.put("precision", getListaCampeones().stream().filter(campeon -> campeon.getHabilidades().contains("precision")).collect(toList()));
        mapHabilidad.put("dominacion", getListaCampeones().stream().filter(campeon -> campeon.getHabilidades().contains("dominacion")).collect(toList()));
        return mapHabilidad;
    }
}
