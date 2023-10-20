package POO4.src.main.java.org.example;

public class Centralita {
    private Llamada[] llamadas;

    public Centralita(Llamada[] llamadas) {
        this.llamadas = llamadas;
    }

    public void registrarLlamada(Llamada llamada){
        /*Llamada llamadas[i] = new Llamada();*/
    }

    public int numeroLlamadas() {
        int cont = 0;
        for (int i = 0; i < llamadas.length; i++) {
            if (llamadas[i] != null)
                cont++;
        }
        return cont;
    }

    public int costeTotal() {
        int coste = 0;
        for (int i = 0; i < llamadas.length; i++) {
            coste = coste + llamadas[i].coste();
        }
        return coste;
    }
}
