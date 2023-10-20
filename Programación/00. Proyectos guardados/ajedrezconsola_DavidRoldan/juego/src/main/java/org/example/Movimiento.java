package org.example;

public class Movimiento {
    Posicion posInicial;
    Posicion posFinal;

    public Posicion getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(Posicion posInicial) {
        this.posInicial = posInicial;
    }

    public Posicion getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    /**
     * Método para construir un movimiento en blanco.
     */
    public Movimiento() {
        posInicial = new Posicion();
        posFinal = new Posicion();
    }

    /**
     * Método para construir un moviemiento con una posición inicial y una posición final.
     * @param posInicial
     * @param posFinal
     */
    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    /**
     * Comprueba si el movimiento es vertical. Para ello la columna inicial y la final no cambia y la fila sí.
     * @return Booleano de si el movimiento es vertical.
     */
    public boolean esVertical() {
        boolean vertical = false;
        if (posInicial.getColumna() == posFinal.getColumna() && posInicial.getFila() != posFinal.getFila()) {
            vertical = true;
        }
        return vertical;
    }

    /**
     * Comprueba si el movimiento es horizontal. Para ello la fila inicial y la fila final no cambia y la columna sí.
     * @return Booleano de si el movimiento es horizontal.
     */
    public boolean esHorizontal() {
        boolean horizontal = false;
        if (posInicial.getColumna() != posFinal.getColumna() && posInicial.getFila() == posFinal.getFila()) {
            horizontal = true;
        }
        return horizontal;
    }

    /**
     * Comprueba si el movimiento es diagonal. Para ello la fila y la columna debe variar lo mismo.
     * @return Booleano de si el movimiento es diagonal.
     */
    public boolean esDiagonal() {
        boolean diagonal = false;
        if (Math.abs(posInicial.getFila() - posFinal.getFila()) == Math.abs(posInicial.getColumna() - posFinal.getColumna())) {
            diagonal = true;
        }
        return diagonal;
    }

    /**
     * Método para ver el número de casillas que recorre una pieza en un movimiento horizontal. Para ello resta la columna final menos la inicial.
     * @return Int con el número de casillas que salta la pieza en al movimiento horizontal.
     */
    public int saltoHorizontal() {
        return Math.abs(posFinal.getColumna() - posInicial.getColumna());
    }

    /**
     * Método para ver el número de casillas que recorre una pieza en un movimiento vertical. Para ello resta la fila final menos la inicial.
     * @return Int con el número de casillas que salta la pieza en el movimiento vertical.
     */
    public int saltoVertical() {
        return posFinal.getFila() - posInicial.getFila();
    }

}
