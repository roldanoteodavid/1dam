package POO4.src.main.java.org.example;

public class LlamadaLocal extends Llamada{

    public LlamadaLocal(int norigen, int ndestino, int duracion) {
        super(norigen, ndestino, duracion);
    }

    @Override
    public int coste() {
        return getDuracion()*15;
    }
}
