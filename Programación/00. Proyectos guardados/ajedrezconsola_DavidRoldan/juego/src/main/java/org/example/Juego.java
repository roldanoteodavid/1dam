package org.example;

import org.example.common.Constantes;

public class Juego {
    private int Turno = 0;

    public String getTurno() {
        return (Turno % 2 == 0) ? "B" : "N";
    }

    public int getTurnoInt() {
        return Turno;
    }

    public Juego() {
        this.Turno = 0;
    }

    public void setTurno() {
        this.Turno = Turno + 1;
    }

    public Posicion movimientosValidos(Tablero tablero, String pieza, Juego juego) {
        int cont = 0;
        Posicion pos = null;
        pieza = pieza.toUpperCase();
        if (pieza.length() == 2) {
            if (pieza.charAt(0) >= 'A' && pieza.charAt(0) <= 'H' && pieza.charAt(1) >= '1' && pieza.charAt(1) <= '8') {
                int poc = (pieza.charAt(0) - 65);
                int pof = (pieza.charAt(1) - 49);
                Posicion posorigen = new Posicion(pof, poc);
                if (tablero.hayPieza(pof, poc)) {
                    if ((tablero.colorPieza(pof, poc).equals("blanco") && getTurno().equals("B")) || (tablero.colorPieza(pof, poc).equals("negro") && getTurno().equals("N"))) {
                        System.out.println(Constantes.POSICIONES_FINALES_VÁLIDAS);
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                Posicion posfin = new Posicion(i, j);
                                if (validadMovimiento(tablero, posorigen, posfin, juego)) {
                                    char col = (char) (j + 65);
                                    System.out.println(col + "" + (i + 1));
                                    cont++;
                                }
                            }
                        }
                        if (cont != 0) {
                            pos = posorigen;
                        } else {
                            System.out.println("No puedes mover esta pieza a ninguna posición.");
                        }
                    } else {
                        System.out.println("Solo puedes mover piezas de tu color.");
                    }
                } else {
                    System.out.println("En la posición introducida no hay pieza.");
                }
            } else {
                System.out.println("Introduzca una posición válida columna A-H, fila 1-8.");
            }
        } else {
            System.out.println("La posición debe ser de dos caracteres.");
        }
        return pos;
    }

    public Movimiento validarPosFinal(Tablero tablero, String posfinal, Posicion posorigen, Juego juego) {
        Movimiento mov = null;
        posfinal = posfinal.toUpperCase();
        if (posfinal.length() == 2) {
            if (posfinal.charAt(0) >= 'A' && posfinal.charAt(0) <= 'H' && posfinal.charAt(1) >= '1' && posfinal.charAt(1) <= '8') {
                int pfc = (posfinal.charAt(0) - 65);
                int pff = (posfinal.charAt(1) - 49);
                Posicion posfin = new Posicion(pff, pfc);
                mov = new Movimiento(posorigen, posfin);
                if (!validadMovimiento(tablero, posorigen, posfin, juego)) {
                    mov = null;
                    System.out.println("El movimiento introducido no es válido.");
                }
            } else {
                System.out.println("Introduzca una posición válida columna A-H, fila 1-8.");
            }
        } else {
            System.out.println("La posición debe ser de dos caracteres.");
        }
        return mov;
    }

    /**
     * Método para validar si la jugada introducida por el usuario es válida. Comprueba que es de 4 caracteres, está entre los valores que debe y comprueba si se puede realizar el movimiento por la ficha indicada teniendo en cuenta que no puede comer una pieza de su color.
     *
     * @param tablero
     * @param jugada
     * @return Movimiento compuesto por una posición inicial y una posición final.
     */
    public Movimiento validarJugada(Tablero tablero, String jugada, Juego juego) {
        int pof = 0, poc = 0, pff = 0, pfc = 0;
        Movimiento mov = null;
        boolean jugadaa = false;
        jugada = jugada.toUpperCase();
        if (jugada.length() == 4) {
            if (jugada.charAt(0) >= 'A' && jugada.charAt(0) <= 'H' && jugada.charAt(1) >= '1' && jugada.charAt(1) <= '8' && jugada.charAt(2) >= 'A' && jugada.charAt(2) <= 'H' && jugada.charAt(3) >= '1' && jugada.charAt(3) <= '8') {
                poc = (jugada.charAt(0) - 65);
                pof = (jugada.charAt(1) - 49);
                pfc = (jugada.charAt(2) - 65);
                pff = (jugada.charAt(3) - 49);
                Posicion posorigen = new Posicion(pof, poc);
                Posicion posfinal = new Posicion(pff, pfc);
                Movimiento movimiento = new Movimiento(posorigen, posfinal);
                if (tablero.hayPieza(pof, poc)) {
                    if (tablero.devuelvePieza(posorigen).validoMovimiento(movimiento, tablero, juego)) {
                        if (tablero.colorPieza(pof, poc).equals("blanco") && getTurno().equals("B")) {
                            if (tablero.jaqueBlanco(juego)) {
                                if (tablero.evitaJaque(movimiento,juego)) {
                                    if (tablero.hayPieza(pff, pfc)) {
                                        if (tablero.colorPieza(pff, pfc).equals("negro")  || tablero.enroque(movimiento,juego)) {
                                            if (!tablero.provocaJaque(movimiento,juego)) {
                                                mov = movimiento;
                                                jugadaa = true;
                                            } else {
                                                System.out.println(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                            }
                                        } else {
                                            System.out.println(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                        }
                                    } else {
                                        if (!tablero.provocaJaque(movimiento,juego)) {
                                            mov = movimiento;
                                            jugadaa = true;
                                        } else {
                                            System.out.println(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                        }
                                    }
                                } else {
                                    System.out.println(Constantes.DEBES_EVITAR_EL_JAQUE);
                                }
                            } else {
                                if (tablero.hayPieza(pff, pfc)) {
                                    if (tablero.colorPieza(pff, pfc).equals("negro")  || tablero.enroque(movimiento,juego)) {
                                        if (!tablero.provocaJaque(movimiento,juego)) {
                                            mov = movimiento;
                                            jugadaa = true;
                                        } else {
                                            System.out.println(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                        }
                                    } else {
                                        System.out.println(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                    }
                                } else {
                                    if (!tablero.provocaJaque(movimiento,juego)) {
                                        mov = movimiento;
                                        jugadaa = true;
                                    } else {
                                        System.out.println(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    }
                                }
                            }
                        } else if (tablero.colorPieza(pof, poc).equals("negro") && getTurno().equals("N")) {
                            if (tablero.jaqueNegro(juego)) {
                                if (tablero.evitaJaque(movimiento,juego)) {
                                    if (tablero.hayPieza(pff, pfc)) {
                                        if (tablero.colorPieza(pff, pfc).equals("blanco")  || tablero.enroque(movimiento,juego)) {
                                            if (!tablero.provocaJaque(movimiento,juego)) {
                                                mov = movimiento;
                                                jugadaa = true;
                                            } else {
                                                System.out.println(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                            }
                                        } else {
                                            System.out.println(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                        }
                                    } else {
                                        if (!tablero.provocaJaque(movimiento,juego)) {
                                            mov = movimiento;
                                            jugadaa = true;
                                        } else {
                                            System.out.println(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                        }
                                    }
                                } else {
                                    System.out.println(Constantes.DEBES_EVITAR_EL_JAQUE);
                                }
                            } else {
                                if (tablero.hayPieza(pff, pfc)) {
                                    if (tablero.colorPieza(pff, pfc).equals("blanco") || tablero.enroque(movimiento,juego)) {
                                        if (!tablero.provocaJaque(movimiento,juego)) {
                                            mov = movimiento;
                                            jugadaa = true;
                                        } else {
                                            System.out.println(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                        }
                                    } else {
                                        System.out.println(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                    }
                                } else {
                                    if (!tablero.provocaJaque(movimiento,juego)) {
                                        mov = movimiento;
                                        jugadaa = true;
                                    } else {
                                        System.out.println(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    }
                                }
                            }
                        } else {
                            System.out.println(Constantes.NO_PUEDES_MOVER_UNA_PIEZA_QUE_NO_ES_TUYA);
                        }
                    } else {
                        System.out.println(Constantes.EL_MOVIMIENTO_INTRODUCIDO_NO_ES_VÁLIDO);
                    }
                } else {
                    System.out.println(Constantes.NO_HAY_PIEZA_EN_LA_POSICIÓN_INTRODUCIDA);
                }
            } else {
                System.out.println(Constantes.INTRODUZCA_UNA_JUGADA_VÁLIDA_LETRA_ORIGEN_NÚMERO_ORIGEN_LETRA_DESTINO_NUMERO_DESTINO);
            }
        } else
            System.out.println(Constantes.LA_LONGITUD_DEBE_SER_DE_4_CARACTERES);
        return mov;
    }

    public boolean validadMovimiento(Tablero tablero, Posicion posoriginal, Posicion posfinal, Juego juego) {
        Movimiento movimiento = new Movimiento(posoriginal, posfinal);
        boolean jugadaa = false;
        if (posoriginal.getFila() >= 0 && posoriginal.getFila() <= 7 && posoriginal.getColumna() >= 0 && posoriginal.getColumna() <= 7 && posfinal.getFila() >= 0 && posfinal.getFila() <= 7 && posfinal.getColumna() >= 0 && posfinal.getColumna() <= 7)
            if (tablero.hayPieza(posoriginal.getFila(), posoriginal.getColumna())) {
                if (tablero.devuelvePieza(posoriginal).validoMovimiento(movimiento, tablero, juego)) {
                    if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("blanco") && getTurno().equals("B")) {
                        if (tablero.jaqueBlanco(juego)) {
                            if (tablero.evitaJaque(movimiento,juego)) {
                                if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                    if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) {
                                        if (!tablero.provocaJaque(movimiento,juego)) {
                                            jugadaa = true;
                                        }
                                    }
                                } else {
                                    if (!tablero.provocaJaque(movimiento,juego)) {
                                        jugadaa = true;
                                    }
                                }
                            }
                        } else {
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) {
                                    if (!tablero.provocaJaque(movimiento,juego)) {
                                        jugadaa = true;
                                    }
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento,juego)) {
                                    jugadaa = true;
                                }
                            }
                        }
                    } else if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("negro") && getTurno().equals("N")) {
                        if (tablero.jaqueNegro(juego)) {
                            if (tablero.evitaJaque(movimiento,juego)) {
                                if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                    if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento,juego)) {
                                        if (!tablero.provocaJaque(movimiento,juego)) {
                                            jugadaa = true;
                                        }
                                    }
                                } else {
                                    if (!tablero.provocaJaque(movimiento,juego)) {
                                        jugadaa = true;
                                    }
                                }
                            }
                        } else {
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento,juego)) {
                                    if (!tablero.provocaJaque(movimiento,juego)) {
                                        jugadaa = true;
                                    }
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento,juego)) {
                                    jugadaa = true;
                                }
                            }
                        }
                    }
                }
            }
        return jugadaa;
    }
}
