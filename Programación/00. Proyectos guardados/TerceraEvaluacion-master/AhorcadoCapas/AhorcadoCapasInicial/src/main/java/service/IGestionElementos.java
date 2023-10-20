package service;

import common.CategoriaException;
import domain.Elemento;

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
    public List<Elemento> listarElementos(boolean ascendente);
    public boolean modificarCategoria(int id, String categoria) throws CategoriaException;
    public boolean modificarElemento(int id, String incognita);

    public List<Elemento> getListaElementosCategoria();
    public void eliminarElemento(Elemento Elemento);
    public void crearFicheros()throws IOException;
    public boolean cargarFichero() throws IOException;
    public boolean escribirFichero();
    public boolean escribirFicheroBinario();
    public boolean cargarFicheroBinario();

}
