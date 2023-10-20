package com.example.ej2alertcombo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;

import java.util.Optional;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Promoción del peón");
        alert.setHeaderText("¿Que pieza desea?");
        alert.setContentText("Elija la pieza por la que desee sustituir su peon");

        ButtonType reina = new ButtonType("Reina");
        ButtonType caballo = new ButtonType("Caballo");
        ButtonType alfil = new ButtonType("Alfil");
        ButtonType torre = new ButtonType("Torre");

        alert.getButtonTypes().setAll(reina, caballo, alfil, torre);

        Optional<ButtonType> result = alert.showAndWait();
        welcomeText.setText("Elegid@ " + result.get().getText());
        if (result.get().getText().equalsIgnoreCase("Reina"))
            System.out.println("Elegida Reina");
        else if (result.get() == torre)
            System.out.println("Elegida Torre");
    }

    @FXML
    public void onAdiosButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("Welcome to JavaFX Application!");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Promoción del peón");
        alert.setHeaderText("¿Que pieza desea?");
        alert.setContentText("Elija la pieza por la que desee sustituir su peon");

        ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>("Pieza Nueva");
        /* //Opción 1
        //Retrieving the observable list
        ObservableList<String> list = choiceDialog.getItems();
        //Adding items to the list
        list.add("Reina");
        list.add("Caballo");
        list.add("Alfil");
        list.add("Torre");*/
        //Opción 2
        choiceDialog.getItems().addAll("Reina", "Caballo", "Alfil", "Torre");
        choiceDialog.showAndWait();


        switch (choiceDialog.getSelectedItem()) {
            case "Reina":
                System.out.println("Reina");
                break;
            case "Caballo":
                System.out.println("Caballo");
                break;
            case "Alfil":
            case "Torre": //Para hacerlo así quitamos switch case...
                welcomeText.setText(choiceDialog.getSelectedItem());
        }
    }
}