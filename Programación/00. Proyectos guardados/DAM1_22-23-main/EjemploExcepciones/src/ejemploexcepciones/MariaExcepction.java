/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploexcepciones;

/**
 *
 * @author gema
 */
public class MariaExcepction extends Exception {

    public MariaExcepction() {
        super("Mari Loli por ahí no, no queremos un número menor que 1");
    }
    public MariaExcepction(String mensaje){
        super(mensaje);
    }
    
}
