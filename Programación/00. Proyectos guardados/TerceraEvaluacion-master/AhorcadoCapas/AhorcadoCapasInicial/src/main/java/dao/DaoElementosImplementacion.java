package dao;

import domain.Elemento;

import java.util.List;

public class DaoElementosImplementacion implements DaoElementos {
    protected final Elementos lista;

    public DaoElementosImplementacion() {
        this.lista = new Elementos();
    }

    @Override
    public boolean isEmptyElementosList() {
        return false;
    }

    @Override
    public boolean insertarElemento(Elemento elemento) {
        return false;
    }

    @Override
    public boolean insertarElemento(int id, int level, String incognita, String categoria) {
        return false;
    }

    @Override
    public List<Elemento> getElementosCategoria(String categoria) {
        return null;
    }

    @Override
    public List<Elemento> getElementosNivelCategoria(int nivel, String categoria) {
        return null;
    }

    @Override
    public List<Elemento> getElementosNivel(int nivel) {
        return null;
    }

    @Override
    public List<Elemento> getElementos(boolean ascendente) {
        return null;
    }

    @Override
    public void eliminarElemento(Elemento elemento) {

    }

    @Override
    public void eliminarElemento(int id) {

    }

    @Override
    public boolean modificarCategoria(int id, String categoria) {
        return false;
    }

    @Override
    public boolean modificarElemento(int id, String incognita) {
        return false;
    }
}
