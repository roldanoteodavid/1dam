package org.example;

public class Rey extends Pieza {
    /**
     * Método para construir un caballo y asignarle color
     *
     * @param color
     */
    public Rey(String color) {
        super(color);
    }

    public Rey(String color, int movimientos) {
        super(color, movimientos);
    }

    /**
     * Método para validar movimiento del rey. Este se puede mover 1 casilla en cualquier dirección de tablero.
     *
     * @param mov     - Introducido por el usuario
     * @param tablero
     * @return Booleano que verifica si el movimiento introducido por el usuario es válido
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero, Juego juego) {
        boolean valido = false;
        if ((Math.abs(mov.getPosInicial().getFila() - mov.getPosFinal().getFila()) <= 1) && (Math.abs(mov.getPosInicial().getColumna() - mov.getPosFinal().getColumna()) <= 1) || tablero.enroque(mov,juego)) {
            valido = true;
        }
        return valido;
    }

    /**
     * Método para imprimir el nombre de la pieza a imprimir dependiendo del color de esta.
     *
     * @return String compuesto por la inicial de la letra y la inicial del color
     */

    public String toString() {
        String pieza;
        if (Rey.super.getColor().equals("negro"))
            pieza = "KN";
        else
            pieza = "KB";
        return pieza;
    }
}
