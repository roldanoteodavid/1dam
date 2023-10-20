package org.example;

import java.util.*;
import java.util.stream.DoubleStream;

import static java.util.Arrays.asList;

public class Operations {
    public static boolean sonPares(int ... operandos){
        //System.out.println(operandos.length);
        return operandos.length%2==0?true:false;
    }

    public static double addNumbers(double ...operandos) {
//        double suma=0;
//        for (int i = 0; i < operandos.length; i++) {
//             suma = suma + operandos[i];
//        }
//        for (double operando : operandos) {
//            suma = suma + operando;
//        }
         return Arrays.stream(operandos).sum();
        //return Arrays.stream(operandos).reduce(0, (a, b) -> a + b);
        //return Arrays.stream(operandos).reduce(0,Double::sum);

    }
    public static double multiplyNumbers(double ...operandos) {
        return DoubleStream.of(operandos).reduce(1, (a, b) -> a * b);
    }
    public static double averageArray(int[] lista){
        return Arrays.stream(lista).average().orElse(0);
    }
    public static void sortArray(int[] lista, boolean ascendente){
        Arrays.sort(lista);
        if(!ascendente)
            Collections.reverse(List.of(lista));
    }
}
