package org.example.dao;

import org.example.common.CategoriaException;
import org.example.domain.Elemento;
import java.util.List;

public interface DaoElementos {
    public boolean isEmptyElementosList() ;
    public List<Elemento> getListaElementos();
    public boolean insertarElemento(Elemento elemento) ;
    public boolean insertarElemento(int id, int level, String incognita, String categoria) throws CategoriaException;
    public List<Elemento> getElementosCategoria(String categoria);
    public List<Elemento> getElementosNivelCategoria(int nivel, String categoria);
    public List<Elemento> getElementosNivel (int nivel);
    public List<Elemento> getElementosOrdenados(boolean ascendente);
    public boolean modificarCategoria(int id, String categoria);
    public boolean modificarElemento(int id, String incognita);
    public boolean eliminarElemento(Elemento elemento) ;
    public boolean eliminarElemento(int id) ;

    public void idOK(int id) throws IdException;
}
