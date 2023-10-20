package org.example;

public class MedicoCentroSalud extends Medico {

    private CentroSalud centroSalud;

    public MedicoCentroSalud(String nombre, int edad, char sexo, int horas, double salarioHora, CentroSalud centroSalud) {
        super(nombre, edad, sexo, horas, salarioHora);
        this.centroSalud = centroSalud;
    }

    public String  mostrarDatos() {
        return super.mostrarDatos()+", Centro de salud: " + this.centroSalud.getNombre() + ", Domicilio: " + this.centroSalud.getDomicilio() + ", Localidad: " + this.centroSalud.getLocalidad();
    }

    public double calcularSalario(){
        return getSalarioHora()*getHoras();
    }

}
