/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listsetejemplos;

import java.util.Comparator;

/**
 *
 * @author gema
 */
public class CriteriosComparacion {
    
}
class porNivel implements Comparator<Elemento>{

    @Override
    public int compare(Elemento o1, Elemento o2) {
        return Integer.compare(o1.getNivel(),o2.getNivel());
    }



}
