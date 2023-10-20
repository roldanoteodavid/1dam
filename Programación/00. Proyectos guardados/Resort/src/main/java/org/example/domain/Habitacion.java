package org.example.domain;

import lombok.Data;
import org.example.common.Comprobacion;
import org.example.common.TipoException;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public @Data class Habitacion implements Comparable<Habitacion>, Serializable {
    private int numero;
    private int capacidad;
    private int precio;
    private String tipo;
    private List<LocalDate> fechasocupadas;

    public Habitacion(int numero, int capacidad, String tipo) throws TipoException {
        this.numero = numero;
        this.capacidad = capacidad;
        this.fechasocupadas = new ArrayList<>();
        Comprobacion.tipoOk(tipo);
        this.tipo = tipo;
        this.precio = precioHabitacion(tipo);
    }

    public void anyadirFechasOcupadas(LocalDate entrada, LocalDate salida){
        boolean fin=false;
        for (int i = 0; !fin ; i++) {
            fechasocupadas.add(entrada.plusDays(i));
            if (entrada.plusDays(i).equals(salida)){
                fin=true;
            }
        }
    }

    public boolean estanOcupadas(LocalDate entrada, LocalDate salida){
        boolean ocupada = false;
        List<LocalDate> aux = new ArrayList<>();
        boolean fin = false;
        for (int i = 0; !fin; i++) {
            aux.add(entrada.plusDays(i));
            if (entrada.plusDays(i).equals(salida)){
                fin=true;
            }
        }
        for (int i = 0; i < fechasocupadas.size(); i++) {
            for (int j = 0; j < aux.size(); j++) {
                if (fechasocupadas.get(i).equals(aux.get(j))){
                    ocupada=true;
                }
            }
        }
        return ocupada;
    }

    //quad, doble, king;
    public int precioHabitacion(String tipo){
        int precio=0;
        if (tipo.equalsIgnoreCase("king")){
            precio=180;
            //setPrecio(precio);
        } else if (tipo.equalsIgnoreCase("doble")) {
            precio=120;
            //setPrecio(precio);
        } else if (tipo.equalsIgnoreCase("quad")) {
            precio=140;
            //setPrecio(precio);
        }
        return precio;
    }

    public String toStringCliente() {
        return "Habitacion{" +
                "numero=" + numero +
                ", capacidad=" + capacidad +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Habitacion o) {
        return Integer.compare(numero,o.numero);
    }

}
