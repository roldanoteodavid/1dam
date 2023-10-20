package org.example.service;

import org.example.common.m2Exception;
import org.example.domain.Vivienda;

import java.util.List;

public interface ServiciosViviendas {
    List<Vivienda> getListaViviendas();
    boolean addVivienda(Vivienda vivienda)throws m2Exception;
    List<Vivienda> consulta(String provincia, double precio1, double precio2);
    void removeVivienda(Vivienda vivienda);
    boolean actualizarm2(int id, double m2) throws m2Exception;

    List<Vivienda> consultaViviendas(String calle, boolean ascendente);
    List<Vivienda> getListaViviendasProvincia(String provincia);

}
