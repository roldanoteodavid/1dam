package com.example.ejemploahorcado;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;


public class FXMLDocumentController implements Initializable {

    @FXML
    private GridPane mainGrid;
    @FXML
    private Label palabra;
    @FXML
    private Label fallos;
    @FXML
    private Button boton;
    @FXML
    private ImageView imagen;
    private int estado;  //fallos
    private String adivinar; //en este label podemos ir poniendo ____ y destapando

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarTablero();
        adivinar = "casa"; //aleatoria del diccionario con nivel y dificultad elegida por el usuario
    }


    private void mostrarTablero() {
        Pane pane;
        char caracter = 'A';
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 7; j++, caracter++) {
                pane = new Pane();
                if (i * 8 + j < 26) {
                    if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                        pane.setStyle("-fx-background-color: #07244f;");
                    } else {
                        pane.setStyle("-fx-background-color: #081d3d");
                    }
                    Label letra = new Label(String.valueOf(caracter));
                    letra.setTextFill(Color.web("#ffffff"));
                    pane.getChildren().addAll(letra);
                    letra.layoutXProperty().bind(pane.widthProperty().subtract(letra.widthProperty()).divide(2));
                    letra.layoutYProperty().bind(pane.heightProperty().subtract(letra.heightProperty()).divide(2));
                    mainGrid.add(pane, j, i);
                    String message = "Click on cell [" + i + ", " + j + "]";
                    int fila = i;
                    int columna = j;
                    pane.setOnMouseClicked(e -> {
                        System.out.println(message);
                        accion(fila, columna);
                    });

                }
            }
        }
    }

    private void accion(int fila, int columna) {
        if (estado != 7) {
            int posicion_pulsada = fila * 8 + columna + 65;
            String letra_pulsada = String.valueOf((char) posicion_pulsada);
            System.out.println("Letra pulsada" + letra_pulsada);
            if (!adivinar.contains(letra_pulsada.toLowerCase())) {
                estado++;
                fallos.setText("Fallos: " + estado + "/7");
                imagen.setImage(new Image("File:src/main/resources/com/example/ejemploahorcado/images/" + estado + ".png"));
            }
        }
        if (estado == 7)
            palabra.setText("Has perdido");

    }


}
