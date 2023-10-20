package org.example;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class Main {

    public static DoubleSummaryStatistics obtenerResumen(double ...operandos){
//        double suma=0;
//        for (int i = 0; i < operandos.length; i++) {
//             suma = suma + operandos[i];
//        }
//        for (double operando : operandos) {
//            suma = suma + operando;
//        }
        return Arrays.stream(operandos).summaryStatistics();
    }

    public static void main(String[] args) {
        /*System.out.println(obtenerResumen (4,6,4,6,4,6));

        System.out.println(Operations.sonPares(3,5,6,7,9));
        System.out.println(Operations.sonPares(3,5));

        System.out.println(Operations.addNumbers(4,6,5,7,10));
        System.out.println((Operations.addNumbers(3,5)));*/
    }
}