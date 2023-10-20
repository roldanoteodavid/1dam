package org.example;

public abstract class Pieza {
    protected String color;
    protected int movimientos;

    /**
     * Contructor de pieza recibiendo un color y movimientos a 0.
     * @param color
     */
    public Pieza(String color) {
        this.color = color;
        this.movimientos = 0;
    }

    public Pieza(String color, int movimientos) {
        this.color = color;
        this.movimientos = movimientos;
    }
    /**
     * Método para devolver el color de una pieza.
     * @return String con el color de la pieza (blanco o negro).
     */
    public String getColor() {
        return color;
    }

    /**
     * Método para obtener el número de movimientos de una pieza.
     * @return int con el número de movimientos de la pieza.
     */
    public int getMovimientos() {
        return movimientos;
    }

    /**
     * Método para sumar 1 al número de movimientos de una pieza.
     */
    public void setMovimientos() {
        this.movimientos = movimientos+1;
    }

    /**
     * Método para comprobar si el movimiento introducido por el usuario es válido dependido de las condiciones de cada pieza.
     *
     * @param mov     - Introducido por el usuario
     * @param tablero
     * @return Booleano que verifica si el movimiento introducido por el usuario es válido
     */
    public abstract boolean validoMovimiento(Movimiento mov, Tablero tablero, Juego juego);

    /**
     * Método para imprimir la inicial de la pieza y la inicial del color.
     *
     * @return String compuesto por la inicial de la letra y la inicial del color.
     */
    @Override
    public abstract String toString();

}
