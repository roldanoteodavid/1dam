package org.example.domain;

import lombok.Data;
import org.example.common.AlFrancesException;
import org.example.common.Comprobacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public @Data class Cliente implements Serializable, Comparable<Cliente> {
    private String dni;
    private String nombre;
    private LocalDate nacimiento;
    private String telefono;
    private List<Reserva> reservas;
    private String pais;
    private String contrasenya;
    private List<Actividad> actividades;

    public Cliente() {
        nacimiento = LocalDate.of(2001, 12, 31);
    }

    public Cliente(String dni, String nombre, LocalDate nacimiento, String telefono, String pais, String contrasenya) throws AlFrancesException {
        this.dni = dni;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.actividades = new ArrayList<>();
        this.reservas = new ArrayList<>();
        Comprobacion.alFrances(pais);
        this.pais = pais;
        this.contrasenya = contrasenya;

    }

    public Cliente(String dni, String nombre, LocalDate nacimiento, String telefono, List<Reserva> reservas, String pais, String contrasenya) throws AlFrancesException {
        this.dni = dni;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.reservas = reservas;
        this.actividades = new ArrayList<>();
        Comprobacion.alFrances(pais);
        this.pais = pais;
        this.contrasenya = contrasenya;
    }


    public Cliente(String nombre, String pais) throws AlFrancesException {
        this.dni = "123213";
        this.nombre = nombre;
        nacimiento = LocalDate.of(2001, 12, 31);
        this.telefono = telefono;
        Comprobacion.alFrances(pais);
        this.pais = pais;
    }

    public boolean anyadirreserva(Reserva reserva) {
        boolean anyadido = reservas.add(reserva);
        asignarIdReserva();
        return anyadido;
    }

    public void asignarIdReserva() {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId() == 0) {
                reservas.get(i).setId(i);
            }
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", telefono='" + telefono + '\'' +
                ", reservas=" + reservas +
                ", pais='" + pais + '\'' +
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
    public int compareTo(Cliente o) {
        //return String.com
        return this.dni.compareTo(o.dni);
    }


}
