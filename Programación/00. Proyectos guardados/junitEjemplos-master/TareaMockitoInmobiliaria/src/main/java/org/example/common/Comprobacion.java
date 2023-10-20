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

    public static void m2Ok(double m2) throws m2Exception {
        if (m2 < 1) {
            throw new m2Exception();
        }
    }
}
