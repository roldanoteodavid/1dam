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
public class Comprobacion {

    public static void categoriaOk(int categoria) throws CategoriaException {
        if (categoria > 5 || categoria < 1) {
            throw new CategoriaException();
        }
    }
}
