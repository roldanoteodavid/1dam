package DAO;

import common.Constantes;
import Modelo.*;
import javafx.scene.control.Label;


public class Juego {
    private int Turno = 0;

    public String getTurno() {
        return (Turno % 2 == 0) ? "B" : "N";
    }

    public Juego() {
        this.Turno = 0;
    }

    public void setTurno() {
        this.Turno = Turno + 1;
    }

    public String validadMovimientoFx(Posicion posoriginal, Posicion posfinal, Tablero tablero, Juego juego) {
        Movimiento movimiento = new Movimiento(posoriginal, posfinal);
        //boolean jugadaa = false;
        String valido = null;
        if (tablero.hayPieza(posoriginal.getFila(), posoriginal.getColumna())) {
            if (tablero.devuelvePieza(posoriginal).validoMovimiento(movimiento, tablero, juego)) {
                if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("blanco") && juego.getTurno().equals("B")) {
                    if (tablero.jaqueBlanco(juego)) {
                        if (tablero.evitaJaque(movimiento, juego)) {
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) {
                                    if (!tablero.provocaJaque(movimiento, juego)) {
                                        //jugadaa = true;
                                    } else {
                                        //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                        valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                    }
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                    valido="NO_PUEDES_COMERTE_UNA_PIEZA_TUYA";
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento, juego)) {
                                    //jugadaa = true;
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                }
                            }
                        } else {
                            //label2.setText(Constantes.DEBES_EVITAR_EL_JAQUE);
                            valido="DEBES_EVITAR_EL_JAQUE";
                        }
                    } else {
                        if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                            if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) {
                                if (!tablero.provocaJaque(movimiento, juego)) {
                                    //jugadaa = true;
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                }
                            } else {
                                //label2.setText(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                valido="NO_PUEDES_COMERTE_UNA_PIEZA_TUYA";
                            }
                        } else {
                            if (!tablero.provocaJaque(movimiento, juego)) {
                                //jugadaa = true;
                            } else {
                                //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                            }
                        }
                    }
                } else if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("negro") && juego.getTurno().equals("N")) {
                    if (tablero.jaqueNegro(juego)) {
                        if (tablero.evitaJaque(movimiento, juego)) {
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento, juego)) {
                                    if (!tablero.provocaJaque(movimiento, juego)) {
                                        //jugadaa = true;
                                    } else {
                                        //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                        valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                    }
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                    valido="NO_PUEDES_COMERTE_UNA_PIEZA_TUYA";
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento, juego)) {
                                    //jugadaa = true;
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                }
                            }
                        } else {
                            //label2.setText(Constantes.DEBES_EVITAR_EL_JAQUE);
                            valido="DEBES_EVITAR_EL_JAQUE";
                        }
                    } else {
                        if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                            if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento, juego)) {
                                if (!tablero.provocaJaque(movimiento, juego)) {
                                    //jugadaa = true;
                                } else {
                                    //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                    valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                                }
                            } else {
                                //label2.setText(Constantes.NO_PUEDES_COMERTE_UNA_PIEZA_TUYA);
                                valido="NO_PUEDES_COMERTE_UNA_PIEZA_TUYA";
                            }
                        } else {
                            if (!tablero.provocaJaque(movimiento, juego)) {
                                //jugadaa = true;
                            } else {
                                //label2.setText(Constantes.NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE);
                                valido="NO_PUEDES_MOVER_PORQUE_GENERAS_JAQUE";
                            }
                        }
                    }
                } else {
                    //label2.setText(Constantes.NO_PUEDES_MOVER_UNA_PIEZA_QUE_NO_ES_TUYA);
                    valido="NO_PUEDES_MOVER_UNA_PIEZA_QUE_NO_ES_TUYA";
                }
            } else {
                //label2.setText(Constantes.EL_MOVIMIENTO_INTRODUCIDO_NO_ES_VÁLIDO);
                valido="EL_MOVIMIENTO_INTRODUCIDO_NO_ES_VÁLIDO";
            }
        } else {
            //label2.setText(Constantes.NO_HAY_PIEZA_EN_LA_POSICIÓN_INTRODUCIDA);
            valido="NO_HAY_PIEZA_EN_LA_POSICIÓN_INTRODUCIDA";
        }
        return valido;
    }

    public boolean validadMovimiento(Tablero tablero, Posicion posoriginal, Posicion posfinal, Juego juego) {
        Movimiento movimiento = new Movimiento(posoriginal, posfinal);
        boolean jugadaa = false;
        if (posoriginal.getFila() >= 0 && posoriginal.getFila() <= 7 && posoriginal.getColumna() >= 0 && posoriginal.getColumna() <= 7 && posfinal.getFila() >= 0 && posfinal.getFila() <= 7 && posfinal.getColumna() >= 0 && posfinal.getColumna() <= 7)
            if (tablero.hayPieza(posoriginal.getFila(), posoriginal.getColumna())) {
                if (tablero.devuelvePieza(posoriginal).validoMovimiento(movimiento, tablero, juego)) {
                    if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("blanco") && getTurno().equals("B")) {
                        if (tablero.jaqueBlanco(juego)) {
                            if (tablero.evitaJaque(movimiento, juego)) {
                                if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                    if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) {
                                        if (!tablero.provocaJaque(movimiento, juego)) {
                                            jugadaa = true;
                                        }
                                    }
                                } else {
                                    if (!tablero.provocaJaque(movimiento, juego)) {
                                        jugadaa = true;
                                    }
                                }
                            }
                        } else {
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("negro") || tablero.enroque(movimiento, juego)) {
                                    if (!tablero.provocaJaque(movimiento, juego)) {
                                        jugadaa = true;
                                    }
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento, juego)) {
                                    jugadaa = true;
                                }
                            }
                        }
                    } else if (tablero.colorPieza(posoriginal.getFila(), posoriginal.getColumna()).equals("negro") && getTurno().equals("N")) {
                        if (tablero.jaqueNegro(juego)) {
                            if (tablero.evitaJaque(movimiento, juego)) {
                                if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                    if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento, juego)) {
                                        if (!tablero.provocaJaque(movimiento, juego)) {
                                            jugadaa = true;
                                        }
                                    }
                                } else {
                                    if (!tablero.provocaJaque(movimiento, juego)) {
                                        jugadaa = true;
                                    }
                                }
                            }
                        } else {
                            if (tablero.hayPieza(posfinal.getFila(), posfinal.getColumna())) {
                                if (tablero.colorPieza(posfinal.getFila(), posfinal.getColumna()).equals("blanco") || tablero.enroque(movimiento, juego)) {
                                    if (!tablero.provocaJaque(movimiento, juego)) {
                                        jugadaa = true;
                                    }
                                }
                            } else {
                                if (!tablero.provocaJaque(movimiento, juego)) {
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
