package org.example.common;

import org.example.domain.Campeon;

import java.util.List;

public class Comprobacion {

    public static void habilidadOk(List<String> habilidadesusuario) throws HabilidadException {
        boolean valida = false;
        Habilidades[] habilidades = Habilidades.values();
        for (int i = 0; i < habilidadesusuario.size(); i++) {
            /*if (habilidadesusuario.get(i).equalsIgnoreCase("valor") || habilidadesusuario.get(i).equalsIgnoreCase("inspiracion") || habilidadesusuario.get(i).equalsIgnoreCase("brujeria") || habilidadesusuario.get(i).equalsIgnoreCase("precision") || habilidadesusuario.get(i).equalsIgnoreCase("dominacion")) {
                valida = true;
            }*/
            for (int j = 0; j < habilidades.length; j++) {
                if (habilidadesusuario.get(i).equalsIgnoreCase(habilidades[j].toString())) {
                    valida = true;
                }
            }
            if (!valida) {
                i = habilidades.length;
            } else if (i + 1 != habilidadesusuario.size()) {
                valida = false;
            }
        }
        if (!valida) {
            throw new HabilidadException(habilidadesusuario);
        }
    }

    public static void habilidadRepetida(List<String> habilidades) throws HabilidadRepetidaException {
        boolean repetida = false;
        for (int i = 0; i < habilidades.size(); i++) {
            for (int j = 0; j < habilidades.size(); j++) {
                if (i == j) {
                    j++;
                }
                if (habilidades.get(i).equals(habilidades.get(j))) {
                    repetida = true;
                    i = habilidades.size();
                    j = habilidades.size();
                }
            }
        }
        if (repetida) {
            throw new HabilidadRepetidaException();
        }
    }

    public static void idOk(int id, List<Campeon> campeones) throws IdException {
        boolean repetida = false;
        for (int i = 0; i < campeones.size(); i++) {
            if (campeones.get(i).getIdentificador() == id) {
                repetida = true;
            }
        }
        if (repetida) {
            throw new IdException();
        }
    }
}