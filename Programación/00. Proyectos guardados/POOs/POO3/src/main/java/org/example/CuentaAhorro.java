package org.example;

public class CuentaAhorro extends CuentaCorriente {

    private double interes;

    public CuentaAhorro(Titular titular, String cuenta, double saldo, double interes) {
        super(titular, cuenta, saldo);
        this.interes = interes;
    }

    public CuentaAhorro(Titular titular, String cuenta, double interes) {
        super(titular, cuenta, 15.3);
        this.interes = interes;
    }

    public CuentaAhorro(Titular titular, String cuenta) {
        super(titular, cuenta, 15.3);
        this.interes = 2.5;
    }

    public double getInteres() {
        return interes;
    }

    public void calcularInteres() {

    }
}
