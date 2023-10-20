package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;

public class Operations2 {
    public boolean sonPares(int... operandos) {
        //System.out.println(operandos.length);
        return operandos.length % 2 == 0 ? true : false;
    }

    public double addNumbers(double... operandos) {
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

    public double multiplyNumbers(double... operandos) {
        return DoubleStream.of(operandos).reduce(1, (a, b) -> a * b);
    }

    public double averageArray(int[] lista) {
        return Arrays.stream(lista).average().orElse(0);
    }

    public void sortArray(int[] lista, boolean ascendente) {
        Arrays.sort(lista);
        if (!ascendente)
            Collections.reverse(List.of(lista));
    }
}
