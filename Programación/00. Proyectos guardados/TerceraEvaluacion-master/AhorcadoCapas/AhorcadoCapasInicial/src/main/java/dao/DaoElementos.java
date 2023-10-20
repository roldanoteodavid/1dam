package dao;

import domain.Elemento;
import java.util.List;

public interface DaoElementos {
    public boolean isEmptyElementosList() ;
    public boolean insertarElemento(Elemento elemento) ;
    public boolean insertarElemento(int id, int level, String incognita, String categoria);
    public List<Elemento> getElementosCategoria(String categoria);
    public List<Elemento> getElementosNivelCategoria(int nivel, String categoria);
    public List<Elemento> getElementosNivel (int nivel);
    public List<Elemento> getElementos(boolean ascendente);
    public boolean modificarCategoria(int id, String categoria);
    public boolean modificarElemento(int id, String incognita);
    public void eliminarElemento(Elemento elemento) ;
    public void eliminarElemento(int id) ;
    }
