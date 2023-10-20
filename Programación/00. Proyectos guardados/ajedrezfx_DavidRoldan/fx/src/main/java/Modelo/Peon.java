package Modelo;

import DAO.*;
import javafx.scene.image.Image;

public class Peon extends Pieza {
    /**
     * Método para constroir un peón y asignarle color
     *
     * @param color
     */
    public Peon(String color) {
        super(color);
    }

    public Peon(String color, int movimientos) {
        super(color, movimientos);
    }

    /**
     * Método para validar movimiento del peón. Se puede mover 2 al principio, por el resto del tablero avanza de uno en uno y solo puede comer en diagonal.
     *
     * @param mov     - Introducido por el usuario
     * @param tablero
     * @return Booleano que verifica si el movimiento introducido por el usuario es válido
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero, Juego juego) {
        boolean valido = false;
        if (mov.getPosInicial().getFila() == 1 && getColor().equals("negro") && Math.abs(mov.saltoVertical()) == 2 && !tablero.hayPiezaEntre(mov) && mov.esVertical() && !tablero.hayPieza(mov.getPosFinal().getFila(), mov.getPosFinal().getColumna())) {
            valido = true;
        } else if (mov.getPosInicial().getFila() == 6 && getColor().equals("blanco") && Math.abs(mov.saltoVertical()) == 2 && !tablero.hayPiezaEntre(mov) && mov.esVertical() && !tablero.hayPieza(mov.getPosFinal().getFila(), mov.getPosFinal().getColumna())) {
            valido = true;
        } else if (getColor().equals("negro") && mov.saltoVertical() == 1 && !tablero.hayPieza(mov.getPosFinal().getFila(), mov.getPosFinal().getColumna()) && mov.esVertical()) {
            valido = true;
        } else if (getColor().equals("blanco") && mov.saltoVertical() == -1 && !tablero.hayPieza(mov.getPosFinal().getFila(), mov.getPosFinal().getColumna()) && mov.esVertical()) {
            valido = true;
        } else if (getColor().equals("negro") && mov.saltoVertical() == 1 && tablero.hayPieza(mov.getPosFinal().getFila(), mov.getPosFinal().getColumna()) && mov.esDiagonal()) {
            valido = true;
        } else if (getColor().equals("blanco") && mov.saltoVertical() == -1 && tablero.hayPieza(mov.getPosFinal().getFila(), mov.getPosFinal().getColumna()) && mov.esDiagonal()) {
            valido = true;
        } else if (tablero.enPassant(mov)) {
            valido = true;
        }
        return valido;
    }

    @Override
    public Image toImage() {
        Image image = null;
        if (Peon.super.getColor().equals("negro"))
            image = new Image("File:fx/src/main/resources/com/example/imagenes/PeonNegro.png");
        else
            image = new Image("File:fx/src/main/resources/com/example/imagenes/PeonBlanco.png");
        return image;
    }

    /**
     * Método para imprimir el nombre de la pieza a imprimir dependiendo del color de esta
     *
     * @return String compuesto por la inicial de la letra y la inicial del color
     */
    public String toString() {
        String pieza;
        if (Peon.super.getColor().equals("negro"))
            pieza = "PN";
        else
            pieza = "PB";
        return pieza;
    }
}
