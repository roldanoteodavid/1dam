package org.example;

public class Reina extends Pieza {
    /**
     * Método para construir un caballo y asignarle color.
     *
     * @param color
     */
    public Reina(String color) {
        super(color);
    }

    /**
     * Método para validar movimiento de la torre. Este debe ser en vertical, horizontal o diagonal y no puede haber piezas entre.
     *
     * @param mov     - Introducido por el usuario
     * @param tablero
     * @return Booleano que verifica si el movimiento introducido por el usuario es válido
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero, Juego juego) {
        boolean valido = false;
        if ((mov.esVertical() || mov.esHorizontal() || mov.esDiagonal()) && !tablero.hayPiezaEntre(mov)) {
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
        if (Reina.super.getColor().equals("negro"))
            pieza = "QN";
        else
            pieza = "QB";
        return pieza;
    }
}
