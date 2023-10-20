package Medico.src.main.java.org.example;

public class MedicoAsistenciaDomiciliaria extends Medico{
    private int[] kmVisitas;
    private double tarifaKm;

    public MedicoAsistenciaDomiciliaria(String nombre, int edad, char sexo, int horas, double salarioHora, int[] kmVisitas, double tarifaKm) {
        super(nombre, edad, sexo, horas, salarioHora);
        this.kmVisitas = kmVisitas;
        this.tarifaKm = tarifaKm;
    }

    public int[] getKmVisitas() {
        return kmVisitas;
    }

    public double getTarifaKm() {
        return tarifaKm;
    }

    public double calcularKm(){
        int kmtotal = 0;
        for (int i = 0; i < kmVisitas.length; i++) {
            kmtotal = kmtotal + kmVisitas[i];
        }
        return kmtotal*2;
    }

    public String mostrarDatos() {
        return super.mostrarDatos()+", kmVisitas:"+calcularKm()+", tarifaKm:"+tarifaKm;
    }

    public double calcularSalario(){
        return getSalarioHora()*getHoras()+calcularKm()*tarifaKm;
    }
}
