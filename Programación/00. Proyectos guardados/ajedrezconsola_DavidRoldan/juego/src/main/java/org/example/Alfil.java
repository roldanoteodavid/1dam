package org.example;

public class Alfil extends Pieza {

    /**
     * Método para construir un caballo y asignarle color.
     *
     * @param color
     */
    public Alfil(String color) {
        super(color);
    }

    /**
     * Método para validar movimiento de la torre. Este debe ser diagonal y no puede haber piezas entre.
     *
     * @param mov     - Introducido por el usuario
     * @param tablero
     * @return Booleano que verifica si el movimiento introducido por el usuario es válido
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero, Juego juego) {
        boolean valido = false;
        if (mov.esDiagonal() && !tablero.hayPiezaEntre(mov)) {
            valido = true;
        }
        return valido;
    }

    /**
     * Método para imprimir el nombre de la pieza a imprimir dependiendo del color de esta.
     *
     * @return String compuesto por la inicial de la letra y la inicial del color.
     */
    public String toString() {
        String pieza;
        if (Alfil.super.getColor().equals("negro"))
            pieza = "AN";
        else
            pieza = "AB";
        return pieza;
    }
}
