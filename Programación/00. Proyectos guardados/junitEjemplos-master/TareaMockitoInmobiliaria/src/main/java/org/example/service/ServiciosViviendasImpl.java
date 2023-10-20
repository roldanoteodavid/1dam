package org.example.service;

import org.example.common.m2Exception;
import org.example.common.Comprobacion;
import org.example.dao.DaoViviendas;
import org.example.dao.DaoViviendasImpl;
import org.example.domain.Vivienda;
import java.util.List;

public class ServiciosViviendasImpl implements ServiciosViviendas{

    private final DaoViviendas daoViviendas;


    public ServiciosViviendasImpl()  {
        this.daoViviendas = new DaoViviendasImpl();

    }
    public ServiciosViviendasImpl(DaoViviendas daoViviendas) {
        this.daoViviendas = daoViviendas;
    }

    public boolean isEmptyViviendasList(){
        return daoViviendas.isEmptyViviendasList();
    }
    public List<Vivienda> getListaViviendas() {
        return daoViviendas.getListaviviendas();
    }

    public boolean addVivienda(Vivienda vivienda) throws m2Exception {
         Comprobacion.m2Ok(vivienda.getM2());
         return daoViviendas.addvivienda(vivienda);
     }

    public List<Vivienda> consulta(String provincia, double precio1, double precio2) {
        if (precio1 > precio2) {
            double aux = precio1;
            precio1 = precio2;
            precio2 = aux;
        }
        return daoViviendas.consulta(provincia, precio1, precio2);
    }


    public boolean actualizarm2(int id, double m2) throws m2Exception {
        Comprobacion.m2Ok(m2);
        return daoViviendas.actualizarm2(id, m2);
    }


    public List<Vivienda> consultaViviendas(String calle, boolean ascendente) {
        return daoViviendas.listadoOrdenadoViviendasCalle(calle,ascendente);
    }

    public List<Vivienda> getListaViviendasProvincia(String provincia) {
        return daoViviendas.getListaviviendasProvincia(provincia);
    }

    public void removeVivienda(Vivienda vivienda) {
        daoViviendas.removeVivienda(vivienda);
    }

}

