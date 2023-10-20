/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mapejemplos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author gema
 */
public class MapEjemplos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Map<String, String> objMap = new HashMap<>();
        objMap.put("Nombre", "Suzuki");
        objMap.put("Potencia", "220");
        objMap.put("Tipo", "2-wheeler");
        objMap.put("Precio", "85000");
        System.out.println("Elementos del mapa:");
        System.out.println(objMap);
        System.out.println("-------------TreeMap (ordena el HashMap por clave---------------");
        Map<String, String> objOMap = new TreeMap<>(objMap);
        System.out.println(objOMap);

        Map<Integer,String> mapa = new HashMap<>();
        for(int i=100;i>0;i--){
            mapa.put(i,"lenguaje"+i);
        }

        mapa.put(3, "PHP");
        mapa.put(4, "Java");
        mapa.put(5, "C");
        mapa.put(1, "SQL");
        mapa.put(2, "Python");

        System.out.println("Tutorial en Guru99:" + mapa);

        // Eliminar el valor de la clave 5
        mapa.remove(3);
        mapa.compute(5,(k,v)->v.concat("#"));
        mapa.put(5,mapa.get(5)+"++");

        /*
        HashMap<String, Integer> prices = new HashMap<>();
        prices.put("Mustang", 10000);
        prices.put("Megane", 55000);
        prices.put("Toledo", 44300);
        prices.put("I30", 53200);

        // print map details
        System.out.println("Car prices before update: " + prices.toString());

        prices.computeIfAbsent("A6", k -> 2000 + 33000);
        prices.computeIfAbsent("A5", k -> 2000 * 34);
        System.out.println("Car prices after update " + prices);
        */
        System.out.println("Tutorial en Guru99 después de eliminar el 3 y actualizar el 5:" + mapa);

        Set<Integer> listaClaves = mapa.keySet();
        //1. Clásica
        /*Iterator<Integer> it = listaClaves.iterator();
        while(it.hasNext()){
            Integer aux = it.next();
            System.out.println("Clave:"+ aux + "="+ " Valor: "+ mapa.get(aux));
        }*/
        
        //2. Foreach
        for (Integer aux : listaClaves) {
        System.out.println("Clave:"+ aux + "="+ " Valor: "+ mapa.get(aux));
        }
        //3. Lambda y programación funcional
        mapa.keySet().forEach(aux ->System.out.println("Clave:"+ aux + "="+ " Valor: "+ mapa.get(aux)));
        
        System.out.println("--------------Otra forma-----------------");
        //streams y lambda

        mapa.keySet().stream().forEach(c-> System.out.println("Clave:"+ c + "="+ " Valor: "+ mapa.get(c)));
        System.out.println("---------------Sólo muestra aquellas claves que cumplen un filtrado-----------------");
        mapa.keySet().stream().filter(k->k.intValue()>=20 && k.intValue()<=30).forEach(System.out::println);
        System.out.println("--------------Listando solo valores-------------------");
        mapa.values().stream().forEach(System.out::println);
        System.out.println("--------------Listando solo los valores que cumplen una condición-------------------");
        mapa.values().stream().filter(c->c.contains("1")).forEach(c-> System.out.println(c));
    }
    
}
