package domain.modelo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public @Data class Actividad implements Comparable<Actividad> {
    private int id;
    private String nombre;
    private String lugar;
    private double precio;
    private LocalDate fecha;

    public Actividad(int id, String nombre, String lugar, double precio, LocalDate fecha) {
        this.id=id;
        this.nombre=nombre;
        this.lugar=lugar;
        this.precio=precio;
        this.fecha=fecha;
    }
    @Override
    public int compareTo(Actividad o) {
        return Integer.compare(id,o.id);
    }

}
