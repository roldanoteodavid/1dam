package Medico.src.main.java.org.example;

public class CentroSalud {

    private int identificador;
    private String nombre;
    private String domicilio;
    private int localidad;

    public CentroSalud(int identificador, String nombre, String domicilio, int localidad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.localidad = localidad;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getLocalidad() {
        return localidad;
    }
}
