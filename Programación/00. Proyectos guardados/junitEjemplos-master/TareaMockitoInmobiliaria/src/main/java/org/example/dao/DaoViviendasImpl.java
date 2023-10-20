package org.example.dao;

import org.example.common.ComparacionPorCalleMetros;
import org.example.common.m2Exception;
import org.example.common.Comprobacion;
import org.example.domain.Vivienda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DaoViviendasImpl implements DaoViviendas {

    private final Database database;

    public DaoViviendasImpl() {
        this.database = new Database();
    }

    public DaoViviendasImpl(Database database) {
        this.database = database;
    }

    public List<Vivienda> getListaViviendas() {
        return database.getListaViviendas();
    }


    public boolean addVivienda(Vivienda vivienda) {
        List<Vivienda> lista = database.getListaViviendas();
        return lista.add(vivienda);
    }

    @Override
    public List<Vivienda> getListaviviendas() {
        return database.getListaViviendas();
    }

    @Override
    public boolean addvivienda(Vivienda vivienda) {
        return false;
    }

    public List<Vivienda> consulta(String provincia, double precio1, double precio2) {

        return database.getListaViviendas().stream().filter(Vivienda -> Vivienda.getProvincia().equals(provincia)
                && Vivienda.getPrecio() >= precio1
                && Vivienda.getPrecio() <= precio2).collect(Collectors.toList());
    }

    public List<Vivienda> viviendasPorCalleNumero(String provincia) {

        return database.getListaViviendas().stream()
                .filter(Vivienda -> Vivienda.getProvincia().equals(provincia))
                .sorted(new ComparacionPorCalleMetros())
                .collect(Collectors.toList());

    }

    public boolean actualizarm2(int id, double m2) {
        Vivienda h = database.getListaViviendas().stream()
                .filter(vivienda -> vivienda.getId()==id).findFirst().orElse(null);
        if (h != null) {
            try {
                Comprobacion.m2Ok(m2);
                h.setM2(m2);
                return true;
            } catch (m2Exception e) {
                throw new RuntimeException(e);
            }

        }

        return false;
    }

    public List<Vivienda> listadoOrdenadoViviendasCalle(String calle,boolean ascendente) {
        List<Vivienda> viviendas = database.getListaViviendas().stream().filter(v->v.getCalle().equalsIgnoreCase(calle)).sorted(new ComparacionPorCalleMetros()).toList();
        if (!ascendente) {
            viviendas = new ArrayList<>(viviendas);
            Collections.reverse(viviendas);
        }
        return viviendas;
    }

    @Override
    public List<Vivienda> getListaviviendasProvincia(String provincia) {
        return database.getListaViviendas().stream().filter(v->v.getProvincia().equalsIgnoreCase(provincia)).toList();
    }

    public List<Vivienda> getListaViviendasProvincia(String provincia) {
        return database.getListaViviendas().stream()
                .filter(Vivienda -> Vivienda.getProvincia().equals(provincia))
                .collect(Collectors.toList());
    }

    public void removeVivienda(Vivienda vivienda) {
        database.getListaViviendas().remove(vivienda);
    }


    public void setViviendas(List<Vivienda> viviendas) {
        database.setListaViviendas(viviendas);
    }


    public boolean isEmptyViviendasList() {
        return database.getListaViviendas().isEmpty();
    }
}
