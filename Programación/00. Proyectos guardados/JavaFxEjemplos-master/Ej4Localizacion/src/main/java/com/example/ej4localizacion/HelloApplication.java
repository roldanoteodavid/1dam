package com.example.ej4localizacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Locale.setDefault(Locale.ENGLISH);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mensajes");
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"), resourceBundle);
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 320, 340);
        stage.setTitle(resourceBundle.getString("titulo"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}