package org.example.service;

import org.example.common.Comprobacion;
import org.example.common.HabilidadException;
import org.example.common.HabilidadRepetidaException;
import org.example.common.IdException;
import org.example.dao.DaoCampeones;
import org.example.dao.DaoCampeonesImpl;
import org.example.dao.DaoCampeonesFicheros;
import org.example.domain.Campeon;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ServiceInterfaceImpl implements ServiceInterface {

    private final DaoCampeones daoCampeones;

    public ServiceInterfaceImpl(DaoCampeones daoCampeones) {
        this.daoCampeones = daoCampeones;
    }

    public ServiceInterfaceImpl() {
        this.daoCampeones = new DaoCampeonesImpl();
    }

    @Override
    public List<Campeon> getListaCampeones() {
        return daoCampeones.getListaCampeones();
    }

    @Override
    public List<Campeon> listadoOrdenadoNombre(boolean ascendente) {
        return daoCampeones.listadoOrdenadoNombre(ascendente);
    }

    @Override
    public boolean addCampeon(Campeon campeon) throws HabilidadException, HabilidadRepetidaException, IdException {
        Comprobacion.habilidadOk(campeon.getHabilidades());
        Comprobacion.habilidadRepetida(campeon.getHabilidades());
        return daoCampeones.addCampeon(campeon);
    }

    @Override
    public List<Campeon> consulta(double ataque1, double ataque2) {
        return daoCampeones.consulta(ataque1, ataque2);
    }

    @Override
    public boolean actualizarBurst(int id, double burst) {
        return daoCampeones.actualizarBurst(id, burst);
    }

    @Override
    public Campeon confirmarRemoveCampeon(int id) {
        return daoCampeones.confirmarRemoveCampeon(id);
    }

    @Override
    public boolean removeCampeon(int id) {
        return daoCampeones.removeCampeon(id);
    }

    @Override
    public Map<String, List<Campeon>> getCampeonesHabilidad() {
        return daoCampeones.getCampeonesHabilidad();
    }


    @Override
    public void crearFicheros() throws IOException {
        DaoCampeonesFicheros.crearFicheros();
    }

    @Override
    public List<Campeon> cargarFichero() throws IOException {
        daoCampeones.setListaCampeones(DaoCampeonesFicheros.cargarFichero());
        return DaoCampeonesFicheros.cargarFichero();
    }

    @Override
    public boolean escribirFichero() {
        return DaoCampeonesFicheros.escribirFichero(daoCampeones.getListaCampeones());
    }

    @Override
    public boolean escribirFicheroBinario() {
        return DaoCampeonesFicheros.escribirFicheroBinario(daoCampeones.getListaCampeones());
    }

    @Override
    public List<Campeon> cargarFicheroBinario() {
        daoCampeones.setListaCampeones(DaoCampeonesFicheros.cargarFicheroBinario());
        return DaoCampeonesFicheros.cargarFicheroBinario();
    }
}
