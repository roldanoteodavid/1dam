package Modelo;

public class Posicion {
    private int fila;
    private int columna;

    /**
     * Método constructor vacío de la posición, poniendo la fila y la columna a 0.
     */
    public Posicion() {
        fila = 0;
        columna = 0;
    }

    /**
     * Método constructor de posición con los valores introducidos por el usuario.
     *
     * @param fila
     * @param columna
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Método para obtener la fila.
     *
     * @return int con el número de la fila.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Método para cambiar la fila de una posición con el valor introducido por el usuario.
     *
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Método para obtener la columna.
     *
     * @return int con el número de la columna.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Método para cambiar la columna de una posición con el valor introducido por el usuario.
     *
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Método para obtener un string con la fila y la columna de una posición.
     *
     * @return String con la fila y la columna de la posición
     */
    @Override
    public String toString() {
        return "Posicion{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
