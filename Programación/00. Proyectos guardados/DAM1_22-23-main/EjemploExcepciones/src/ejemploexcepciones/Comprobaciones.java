/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploexcepciones;

/**
 *
 * @author gema
 */
public class Comprobaciones {
    /**
     * 
     * @param num
     * @throws MariaExcepction es arrojada cuando el número
     */
    public static void numeroRango(int num) throws MariaExcepction {
        if (num<1)
            throw new MariaExcepction();
        else if (num>5)
            throw new MariaExcepction("@ Policía (menor que 5)");
    }

    
}
