package com.example.service;

import com.example.common.CategoriaException;
import com.example.dao.Elementos;
import com.example.dao.IdException;
import com.example.domain.CatLevException;
import com.example.domain.Elemento;

import java.io.IOException;
import java.util.List;

public interface IGestionElementos {
    public boolean isEmptyElementosList();
    public List<Elemento> getListaElementos();
    public boolean insertarElemento(Elemento Elemento);

    /**
     *
     * @param id
     * @param level
     * @param incognita
     * @param categoria si la categoria no es válida se lanzará una excepción y no será insertado el elememto
     * @return
     * @throws CategoriaException
     */
    public boolean insertarElemento(int id, int level, String incognita, String categoria) throws CategoriaException;
    public List<Elemento> listar(String categoria);
    public List<Elemento> listar(int nivel, String categoria);
    public List<Elemento> listar (int nivel);
    public List<Elemento> listarElementosOrdenados(boolean ascendente);
    public boolean modificarCategoria(int id, String categoria) throws CategoriaException;
    public boolean modificarElemento(int id, String incognita);

    public List<Elemento> getListaElementosCategoria(String categoria);
    public Elemento getElementoNivelCategoria(int dificultad, String categoria) throws CatLevException, CategoriaException;
    public boolean eliminarElemento(Elemento Elemento);
    public boolean eliminarElemento(int id);
    public void idOk(int id) throws IdException;
    public void crearFicheros()throws IOException;
    public boolean cargarFichero() throws IOException;
    public boolean escribirFichero();
    public boolean escribirFicheroBinario();
    public boolean cargarFicheroBinario();


}
