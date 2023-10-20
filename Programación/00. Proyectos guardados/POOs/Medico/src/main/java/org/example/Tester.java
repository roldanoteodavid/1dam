package org.example;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Medico medico = new Medico("Julian", 45, 'M', 80, 25.3);
        CentroSalud centroSalud1 = new CentroSalud(123, "Manzanares", "Musas", 28022);
        MedicoCentroSalud medicoCentroSalud = new MedicoCentroSalud("Alberto", 63, 'M', 20, 30.4, centroSalud1);
        int [] kmtotales = new int[5];
        for (int i = 0; i < kmtotales.length; i++) {
            System.out.println("Introduzca los km de la "+(i+1)+"º visita");
            kmtotales[i]= teclado.nextInt();
        }
        MedicoAsistenciaDomiciliaria medicoAsistenciaDomiciliaria = new MedicoAsistenciaDomiciliaria("Julia", 32, 'F', 50, 22.5, kmtotales, 5);
        System.out.println(medico.mostrarDatos());
        System.out.println("Salario="+medico.calcularSalario());
        System.out.println(medicoCentroSalud.mostrarDatos());
        System.out.println("Salario="+medicoCentroSalud.calcularSalario());
        System.out.println(medicoAsistenciaDomiciliaria.mostrarDatos());
        System.out.println("Salario="+medicoAsistenciaDomiciliaria.calcularSalario());
    }
}
