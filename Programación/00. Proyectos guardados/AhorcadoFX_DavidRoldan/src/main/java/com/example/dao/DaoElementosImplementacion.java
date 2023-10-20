package com.example.dao;

import com.example.common.Categoria;
import com.example.common.CategoriaException;
import com.example.common.Comprobacion;
import com.example.domain.CatLevException;
import com.example.domain.Elemento;
import com.example.domain.Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoElementosImplementacion implements DaoElementos {
    protected final List<Elemento> lista;

    public DaoElementosImplementacion() {
        this.lista = new Elementos();
    }
    public DaoElementosImplementacion(List<Elemento> elementos){
        this.lista = elementos;
    }

    public List<Elemento> getListaElementos() {
        return lista;
    }

    @Override
    public boolean isEmptyElementosList() {
        return lista.isEmpty();
    }

    @Override
    public boolean insertarElemento(Elemento elemento) {
        return lista.add(elemento);
    }

    @Override
    public boolean insertarElemento(int id, int level, String incognita, String categoria) throws CategoriaException {
        return lista.add(new Elemento(id, level, incognita, categoria));
    }

    @Override
    public List<Elemento> getElementosCategoria(String categoria) {
        ArrayList<Elemento> elementosCat = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCategoria().equalsIgnoreCase(categoria)) {
                elementosCat.add(lista.get(i));
            }
        }
        return elementosCat;
    }

    @Override
    public List<Elemento> getElementosNivelCategoria(int nivel, String categoria) {
        ArrayList<Elemento> elementosCatLev = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCategoria().equalsIgnoreCase(categoria) && lista.get(i).getLevel() == nivel) {
                elementosCatLev.add(lista.get(i));
            }
        }
        return elementosCatLev;
    }

    @Override
    public Elemento getElementoNivelCategoria(int nivel, String categoria) throws CatLevException, CategoriaException {
        Comprobacion.categoriaOk(categoria);
        Juego.categoriaLevOk(categoria,nivel);
        Elemento elemento = null;
        ArrayList<Elemento> elementosCatLev = (ArrayList<Elemento>) getElementosNivelCategoria(nivel, categoria);
        if (elementosCatLev.size() > 0) {
            elemento = elementosCatLev.get((int) (Math.random() * elementosCatLev.size()));
        }
        return elemento;
    }

    @Override
    public List<Elemento> getElementosNivel(int nivel) {
        ArrayList<Elemento> elementosLev = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getLevel() == nivel) {
                elementosLev.add(lista.get(i));
            }
        }
        return elementosLev;
    }

    @Override
    public List<Elemento> getElementosOrdenados(boolean ascendente) {
        ArrayList<Elemento> elementosOrdenados = new ArrayList<>();
        elementosOrdenados = (ArrayList<Elemento>) getListaElementos();
        Collections.sort(elementosOrdenados);
        if (!ascendente) {
            Collections.reverse(elementosOrdenados);
        }
        return elementosOrdenados;
    }

    @Override
    public boolean eliminarElemento(Elemento elemento) {
        boolean eliminado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == elemento) {
                lista.remove(i);
                i = lista.size();
                eliminado = true;
            }
        }
        return eliminado;
    }

    @Override
    public boolean eliminarElemento(int id) {
        boolean eliminado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                i = lista.size();
                eliminado = true;
            }
        }
        return eliminado;
    }

    @Override
    public boolean escribirFichero() {
        for (int i = 0; i < getListaElementos().size(); i++) {
            DaoElementosFicheros.escribirFichero(getListaElementos().get(i));
        }
        return true;
    }

    @Override
    public void idOK(int id) throws IdException {
        boolean esta = false;
        for(int i=0; i<lista.size() && !esta;i++){
            if (lista.get(i).getId()==id)
                esta=true;
        }
        if (esta)
            throw new IdException(id);
    }

    @Override
    public boolean modificarCategoria(int id, String categoria) {
        boolean cambio = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                try {
                    lista.get(i).setCategoria(categoria);
                } catch (CategoriaException e) {
                    throw new RuntimeException(e);
                }
                cambio = true;
                i = lista.size();
            }
        }
        return cambio;
    }

    @Override
    public boolean modificarElemento(int id, String incognita) {
        boolean cambio = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.get(i).setIncognita(incognita);
                cambio = true;
                i = lista.size();
            }
        }
        return cambio;
    }
}
