/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.dao;

import org.example.common.Categoria;

import java.util.Arrays;

public class IdException extends Exception {

    public IdException() {
        super("El id no debe estar repetido " + Arrays.toString(Categoria.values()));
    }

    public IdException(int id) {
        super("El id " + id + " ya está asignado a algún elemento.");
    }
}
