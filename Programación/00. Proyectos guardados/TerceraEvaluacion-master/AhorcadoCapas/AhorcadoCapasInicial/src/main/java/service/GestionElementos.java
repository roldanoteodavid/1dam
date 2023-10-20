package service;

import common.CategoriaException;
import dao.DaoElementos;
import dao.DaoElementosImplementacion;
import domain.Elemento;

import java.io.IOException;
import java.util.List;

public class GestionElementos implements IGestionElementos {

    private final DaoElementos daoElementos;


    public GestionElementos() {
        this.daoElementos = new DaoElementosImplementacion();
    }

    public GestionElementos(DaoElementos daoElementos) {
        this.daoElementos = daoElementos;
    }

    @Override
    public boolean isEmptyElementosList() {
        return false;
    }

    @Override
    public List<Elemento> getListaElementos() {
        return null;
    }

    @Override
    public boolean insertarElemento(Elemento Elemento) {
        return false;
    }

    @Override
    public boolean insertarElemento(int id, int level, String incognita, String categoria) throws CategoriaException {
        return false;
    }

    @Override
    public List<Elemento> listar(String categoria) {
        return null;
    }

    @Override
    public List<Elemento> listar(int nivel, String categoria) {
        return null;
    }

    @Override
    public List<Elemento> listar(int nivel) {
        return null;
    }

    @Override
    public List<Elemento> listarElementos(boolean ascendente) {
        return null;
    }

    @Override
    public boolean modificarCategoria(int id, String categoria) throws CategoriaException {
        return false;
    }

    @Override
    public boolean modificarElemento(int id, String incognita) {
        return false;
    }

    @Override
    public List<Elemento> getListaElementosCategoria() {
        return null;
    }

    @Override
    public void eliminarElemento(Elemento Elemento) {

    }

    @Override
    public void crearFicheros() throws IOException {

    }

    @Override
    public boolean cargarFichero() throws IOException {
        return false;
    }

    @Override
    public boolean escribirFichero() {
        return false;
    }

    @Override
    public boolean escribirFicheroBinario() {
        return false;
    }

    @Override
    public boolean cargarFicheroBinario() {
        return false;
    }
}