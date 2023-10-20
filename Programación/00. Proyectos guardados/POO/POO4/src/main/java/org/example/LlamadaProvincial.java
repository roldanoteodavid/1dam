package POO4.src.main.java.org.example;

public class LlamadaProvincial extends Llamada {
    private int franja;

    public LlamadaProvincial(int norigen, int ndestino, int duracion) {
        super(norigen, ndestino, duracion);
    }

    @Override
    public int coste() {
        int coste = 0;
        if (franja == 1)
            coste = getDuracion() * 20;
        else if (franja == 2) {
            coste = getDuracion() * 25;
        } else if (franja == 3) {
            coste = getDuracion() * 30;
        }
        return coste;
    }
}
