package org.example;

import java.util.Arrays;

public class OperacionesArray2 {

        private OperacionesArray2(){}
        public static void cargar(int [] numeros) {
                for (int i = 0; i < numeros.length; i++) {
                        numeros[i] = (int) (Math.random() * 9 + 1);
                }
        }

        public static String imprimir(int[] numeros){
                return "Array{" +
                        "numeros=" + Arrays.toString(numeros) +
                        '}';
        }

        public static double media(int [] numeros) {
                double media = 0;
                for (int i = 0; i < numeros.length; i++) {
                        media=media+numeros[i];
                }
                media=media/ numeros.length;
                return media;
        }

        public static String ordenar(int [] numeros){
                int ordenado [] = new int [numeros.length];
                for (int i = 0; i < numeros.length; i++) {
                        ordenado[i]=numeros[i];
                }
                Arrays.sort(ordenado);
                return "ArrayOrdenado{" +
                        "numeros=" + Arrays.toString(ordenado) +
                        '}';
        }

        public static String invertir(int [] numeros){
                int invertido [] = new int [numeros.length];
                for (int i = 0; i < numeros.length; i++) {
                        invertido[i]=numeros[numeros.length-1-i];
                }

                return "ArrayInvertido{" +
                        "numeros=" + Arrays.toString(invertido) +
                        '}';
        }
}
