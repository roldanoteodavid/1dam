package org.example.dao;

import org.example.common.Categoria;
import org.example.common.CategoriaException;
import org.example.domain.Elemento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoElementosImplementacion implements DaoElementos {
    protected final Elementos lista;

    public DaoElementosImplementacion() {
        this.lista = new Elementos();
    }

    public List<Elemento> getListaElementos() {
        return lista.getListaelementos();
    }

    @Override
    public boolean isEmptyElementosList() {
        return lista.getListaelementos().isEmpty();
    }

    @Override
    public boolean insertarElemento(Elemento elemento) {
        return lista.getListaelementos().add(elemento);
    }

    @Override
    public boolean insertarElemento(int id, int level, String incognita, String categoria) throws CategoriaException {
        return lista.getListaelementos().add(new Elemento(id, level, incognita, categoria));
    }

    @Override
    public List<Elemento> getElementosCategoria(String categoria) {
        ArrayList<Elemento> elementosCat = new ArrayList<>();
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getCategoria().equalsIgnoreCase(categoria)) {
                elementosCat.add(lista.getListaelementos().get(i));
            }
        }
        return elementosCat;
    }

    @Override
    public List<Elemento> getElementosNivelCategoria(int nivel, String categoria) {
        ArrayList<Elemento> elementosCatLev = new ArrayList<>();
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getCategoria().equalsIgnoreCase(categoria) && lista.getListaelementos().get(i).getLevel() == nivel) {
                elementosCatLev.add(lista.getListaelementos().get(i));
            }
        }
        return elementosCatLev;
    }

    @Override
    public List<Elemento> getElementosNivel(int nivel) {
        ArrayList<Elemento> elementosLev = new ArrayList<>();
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getLevel() == nivel) {
                elementosLev.add(lista.getListaelementos().get(i));
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
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i) == elemento) {
                lista.getListaelementos().remove(i);
                i = lista.getListaelementos().size();
                eliminado = true;
            }
        }
        return eliminado;
    }

    @Override
    public boolean eliminarElemento(int id) {
        boolean eliminado = false;
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getId() == id) {
                lista.getListaelementos().remove(i);
                i = lista.getListaelementos().size();
                eliminado = true;
            }
        }
        return eliminado;
    }

    @Override
    public void idOK(int id) throws IdException {
        boolean esta = false;
        for(int i=0; i<lista.getListaelementos().size() && !esta;i++){
            //System.out.println(aux[i].toString()+" - ");
            if (lista.getListaelementos().get(i).getId()==id)
                esta=true;
        }
        if (esta)
            throw new IdException(id);
    }

    @Override
    public boolean modificarCategoria(int id, String categoria) {
        boolean cambio = false;
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getId() == id) {
                try {
                    lista.getListaelementos().get(i).setCategoria(categoria);
                } catch (CategoriaException e) {
                    throw new RuntimeException(e);
                }
                cambio = true;
                i = lista.getListaelementos().size();
            }
        }
        return cambio;
    }

    @Override
    public boolean modificarElemento(int id, String incognita) {
        boolean cambio = false;
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getId() == id) {
                lista.getListaelementos().get(i).setIncognita(incognita);
                cambio = true;
                i = lista.getListaelementos().size();
            }
        }
        return cambio;
    }
}
