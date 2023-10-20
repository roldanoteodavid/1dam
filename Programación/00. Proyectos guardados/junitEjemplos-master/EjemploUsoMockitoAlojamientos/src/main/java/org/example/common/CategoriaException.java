/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.common;

/**
 *
 * @author examen
 */
public class CategoriaException extends Exception {

    public CategoriaException() {
        super("La categoria debe estar entre 1 y 5");
    }
}
