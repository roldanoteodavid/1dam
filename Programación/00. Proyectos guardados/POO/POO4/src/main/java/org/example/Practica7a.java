package POO4.src.main.java.org.example;

public class Practica7a {
    public static void main(String[] args) {
        Llamada llamadas[]= new Llamada[3];
        Centralita centralita = new Centralita(llamadas);
        centralita.registrarLlamada(new LlamadaLocal(123456, 789012, 124));
        centralita.registrarLlamada(new LlamadaLocal(789012, 345678, 54));
        centralita.registrarLlamada(new LlamadaProvincial(345678, 789012, 236));
        System.out.println("El número total de llamadas es"+ centralita.numeroLlamadas());
        System.out.println("El coste total de las llamadas es "+centralita.costeTotal());
    }
}
