package POO3.src.main.java.org.example;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Titular titular1 = new Titular("Raul", "Dominguez", 27);
        CuentaCorriente cuenta1 = new CuentaCorriente(titular1, "123123E", 24.52);
        Titular titular2 = new Titular("Julio","Perez", 76);
        CuentaAhorro cuenta2 = new CuentaAhorro(titular2, "645234F", 423);
        System.out.println(cuenta1.toString());
        System.out.println("-------");
        System.out.println(cuenta2.toString());
        System.out.println("Introduzca cantidad para ingresar en la cuenta 1");
        cuenta1.ingresar(teclado.nextDouble());
        System.out.println(cuenta1.toString());
        System.out.println("Introduzca cantidad para sacar de la cuenta 2");
        cuenta2.reintegro(teclado.nextDouble());
        System.out.println(cuenta2.toString());
        System.out.println(cuenta1.compararCuentas(cuenta2.getCuenta()));
    }
}
