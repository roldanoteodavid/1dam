package org.example;

public class CuentaCorriente {
    private Titular titular;
    private String cuenta;
    private double saldo;

    public CuentaCorriente(Titular titular, String cuenta, double saldo) {
        this.titular = titular;
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public CuentaCorriente(Titular titular, String cuenta) {
        this.titular = titular;
        this.cuenta = cuenta;
        this.saldo = 15.3;
    }

    public Titular getTitular() {
        return titular;
    }

    public String getCuenta() {
        return cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingresar(double ingreso) {
        this.saldo = saldo + ingreso;
    }

    public void reintegro(double reintegro) {
        this.saldo = saldo - reintegro;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "cuenta='" + cuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public boolean compararCuentas(String cuenta2){
        boolean iguales=false;
        if (cuenta.compareTo(cuenta2)==0)
            iguales=true;
        return iguales;
    }
}
