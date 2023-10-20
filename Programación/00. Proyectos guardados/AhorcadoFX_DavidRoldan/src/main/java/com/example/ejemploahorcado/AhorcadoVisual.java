package com.example.ejemploahorcado;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AhorcadoVisual extends Application {

    @Override
    public void start(Stage stage)  {
        try {
            //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(AhorcadoVisual.class.getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("David's hanged");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            System.out.printf("Ha ocurrido una excepción:\n%s", e);
        }
    }

}
