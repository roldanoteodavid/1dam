package UI;

import Modelo.*;
import common.Constantes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import DAO.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Locale;

public class HelloController implements Initializable {
    public Label label2;
    public Button boton;
    @FXML
    private Label label;
    @FXML
    private GridPane mainGrid;

    private Tablero tablero;

    private Juego juego;
    private Posicion posorigen = null;
    private boolean fin;
    ResourceBundle resourceBundle;

    public HelloController() {
    }

    @FXML
    protected void onHelloButtonClick() {
        label.setText("Welcome to JavaFX Application!");
    }

    public void click(MouseEvent mouseEvent) {
        if (!fin) {
            int columna = 0;
            int fila = 0;
            Node node = null;
            for (int i = 0; i < mainGrid.getChildren().size(); i++) {
                node = mainGrid.getChildren().get(i);
                if (node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) {
                    columna = GridPane.getColumnIndex(node);
                    fila = GridPane.getRowIndex(node);
                }
            }
            if (posorigen == null) {
                Posicion pos = new Posicion(fila, columna);
                Posicion[] posiciones = movimientosValidosFx(pos);
                if (posiciones[0] != null) {
                    posorigen = pos;
                    pintarPosicionesPosibles(posiciones);
                    //label2.setText(Constantes.ELIJA_LA_POSICIÓN_A_LA_QUE_DESEA_MOVER);
                    label2.setText(resourceBundle.getString("ELIJA_LA_POSICIÓN_A_LA_QUE_DESEA_MOVER"));
                }
            } else {
                Posicion pos = new Posicion(fila, columna);
                Movimiento mov = validarPosFinalFx(pos, posorigen);
                if (mov != null) {
                    if (tablero.mover(mov, juego)) {
                        int opcion = alertaPromocion();
                        tablero.promocionPeonFx(mov, opcion);
                    }
                    juego.setTurno();
                    pintarTablero();
                    posorigen = null;
                }
            }
            if (tablero.jaqueBlanco(juego)) {
                if (tablero.jaqueMateBlanco(juego)) {
                    tablero.pintarTablero();
                    label.setText(resourceBundle.getString("JAQUE_MATE_BLANCO"));
                    fin = true;
                }
            }
            if (tablero.jaqueNegro(juego)) {
                if (tablero.jaqueMateNegro(juego)) {
                    tablero.pintarTablero();
                    //label.setText(Constantes.JAQUE_MATE_NEGRO);
                    label.setText(resourceBundle.getString("JAQUE_MATE_NEGRO"));
                    fin = true;
                }
            }
            if (!fin && tablero.finJuego(juego)) {
                fin = true;
                //label.setText(Constantes.TABLAS);
                label.setText(resourceBundle.getString("TABLAS"));
            }
            if (fin) {
                //label2.setText(Constantes.FIN_JUEGO);
                label2.setText(resourceBundle.getString("FIN_JUEGO"));
            } else {
                if (juego.getTurno().equals("B")) {
                    if (tablero.jaqueBlanco(juego)) {
                        //label2.setText(Constantes.JAQUE_BLANCO);
                        label2.setText(resourceBundle.getString("JAQUE_BLANCO"));
                    }
                    label.setText(resourceBundle.getString("TURNO_DE_BLANCAS"));
                } else {
                    if (tablero.jaqueNegro(juego)) {
                        //label2.setText(Constantes.JAQUE_NEGRO);
                        label2.setText(resourceBundle.getString("JAQUE_NEGRO"));
                    }
                    //label.setText(Constantes.TURNO_DE_NEGRAS);
                    label.setText(resourceBundle.getString("TURNO_DE_NEGRAS"));
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundlee) {
        juego = new Juego();
        tablero = new Tablero();
        fin = false;
        pintarTablero();
        //label.setText(Constantes.TURNO_DE_BLANCAS);
        resourceBundle = resourceBundlee;
        label.setText(resourceBundle.getString("TURNO_DE_BLANCAS"));
    }

    public void pintarTablero() {
        Pane pane;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                pane = new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    //pane.setStyle("-fx-background-color: #684714;");
                    pane.setStyle("-fx-background-color: #C0C0C0;");
                    //pane.setStyle("-fx-background-color: #2F2B2B;");
                } else {
                    //pane.setStyle("-fx-background-color: #ffe68e");
                    //pane.setStyle("-fx-background-color: #FF0000");
                    pane.setStyle("-fx-background-color: #d01515");
                }
                if (tablero.hayPieza(i, j)) {
                    pane.getChildren().addAll(new ImageView(tablero.devuelvePieza(i, j).toImage()));
                }
                mainGrid.add(pane, j, i);
            }
        }
    }

    public Posicion[] movimientosValidosFx(Posicion posicion) {
        Posicion[] posiciones = new Posicion[20];
        int cont = 0;
        if (tablero.hayPieza(posicion.getFila(), posicion.getColumna())) {
            if ((tablero.colorPieza(posicion.getFila(), posicion.getColumna()).equals("blanco") && juego.getTurno().equals("B")) || (tablero.colorPieza(posicion.getFila(), posicion.getColumna()).equals("negro") && juego.getTurno().equals("N"))) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        Posicion posfin = new Posicion(i, j);
                        if (juego.validadMovimiento(tablero, posicion, posfin, juego)) {
                            posiciones[cont] = new Posicion(i, j);
                            char col = (char) (j + 65);
                            cont++;
                        }
                    }
                }
                if (cont == 0) {
                    //label2.setText(Constantes.NO_PUEDE_MOVER_ESTA_PIEZA_A_NINGUNA_POSICIÓN);
                    label2.setText(resourceBundle.getString("NO_PUEDE_MOVER_ESTA_PIEZA_A_NINGUNA_POSICIÓN"));
                }
            } else {
                //label2.setText(Constantes.NO_PUEDES_MOVER_UNA_PIEZA_QUE_NO_ES_TUYA);
                label2.setText(resourceBundle.getString("NO_PUEDES_MOVER_UNA_PIEZA_QUE_NO_ES_TUYA"));
            }
        } else {
            //label2.setText(Constantes.NO_HAY_PIEZA_EN_LA_POSICIÓN_INTRODUCIDA);
            label2.setText(resourceBundle.getString("NO_HAY_PIEZA_EN_LA_POSICIÓN_INTRODUCIDA"));
        }
        return posiciones;
    }

    public Movimiento validarPosFinalFx(Posicion posfinal, Posicion posorigen) {
        Movimiento mov = null;
        mov = new Movimiento(posorigen, posfinal);
        String valido = juego.validadMovimientoFx(posorigen, posfinal, this.tablero, this.juego);
        if (valido != null) {
            mov = null;
            label2.setText(resourceBundle.getString(valido));
        }
        return mov;
    }

    public void pintarPosicionesPosibles(Posicion[] posiciones) {
        Pane pane;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                pane = new Pane();
                boolean posible = false;
                for (int k = 0; k < posiciones.length; k++) {
                    if (posiciones[k] != null && posiciones[k].getFila() == i && posiciones[k].getColumna() == j) {
                        pane.setStyle("-fx-background-color: #FFFF00;");
                        posible = true;
                    }
                }
                if (!posible) {
                    if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                        //pane.setStyle("-fx-background-color: #181818;");
                        pane.setStyle("-fx-background-color: #C0C0C0;");
                    } else {
                        pane.setStyle("-fx-background-color: #d01515");
                    }
                }
                if (tablero.hayPieza(i, j)) {
                    //addAll vs add
                    //pane.getChildren().addAll(new ImageView(new Image("File:fx/src/main/resources/com/example/imagenes/CaballoNegro.png")));
                    pane.getChildren().addAll(new ImageView(tablero.devuelvePieza(i, j).toImage()));
                }
                mainGrid.add(pane, j, i);
            }
        }
    }

    public int alertaPromocion() {
        int opcion = 0;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(resourceBundle.getString("PROMOCION_PEON"));
        alert.setHeaderText(resourceBundle.getString("QUE_PIEZA"));
        alert.setContentText(resourceBundle.getString("SUSTITUIR_PEON"));

        ButtonType reina = new ButtonType(resourceBundle.getString("REINA"));
        ButtonType caballo = new ButtonType(resourceBundle.getString("CABALLO"));
        ButtonType alfil = new ButtonType(resourceBundle.getString("ALFIL"));
        ButtonType torre = new ButtonType(resourceBundle.getString("TORRE"));

        alert.getButtonTypes().setAll(reina, caballo, alfil, torre);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get().getText().equalsIgnoreCase("Reina")) {
            opcion = 1;
        } else if (result.get().getText().equalsIgnoreCase("Caballo")) {
            opcion = 2;
        } else if (result.get().getText().equalsIgnoreCase("Torre")) {
            opcion = 3;
        } else if (result.get().getText().equalsIgnoreCase("Alfil")) {
            opcion = 4;
        }
        return opcion;
    }

    public void enroque(ActionEvent actionEvent) {
        if (resourceBundle.getLocale().equals(Locale.ROOT)){
            resourceBundle = ResourceBundle.getBundle("mensajes", new Locale("pt"));
            boton.setText("  Español  ");
        }else{
            resourceBundle = ResourceBundle.getBundle("mensajes", Locale.ROOT);
            boton.setText("Português");
        }
    }
}