package Modelo;

import DAO.*;
import javafx.scene.image.Image;

public class Torre extends Pieza {
    /**
     * Método para construir un caballo y asignarle color.
     *
     * @param color
     */
    public Torre(String color) {
        super(color);
    }


    public Torre(String color, int movimientos) {
        super(color, movimientos);
    }

    /**
     * Método para validar movimiento de la torre. Este debe ser en vertical u horizontal y no puede haber piezas entre.
     *
     * @param mov     - Introducido por el usuario
     * @param tablero
     * @return Booleano que verifica si el movimiento introducido por el usuario es válido
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero, Juego juego) {
        boolean valido = false;
        if ((mov.esHorizontal() || mov.esVertical()) && !tablero.hayPiezaEntre(mov) || tablero.enroque(mov, juego)) {
            valido = true;
        }
        return valido;
    }

    public Image toImage() {
        Image image = null;
        if (Torre.super.getColor().equals("negro"))
            image = new Image("File:fx/src/main/resources/com/example/imagenes/TorreNegra.png");
        else
            image = new Image("File:fx/src/main/resources/com/example/imagenes/TorreBlanca.png");
        return image;
    }

    /**
     * Método para imprimir el nombre de la pieza a imprimir dependiendo del color de esta.
     *
     * @return String compuesto por la inicial de la letra y la inicial del color.
     */

    public String toString() {
        String pieza;
        if (Torre.super.getColor().equals("negro"))
            pieza = "TN";
        else
            pieza = "TB";
        return pieza;
    }
}
