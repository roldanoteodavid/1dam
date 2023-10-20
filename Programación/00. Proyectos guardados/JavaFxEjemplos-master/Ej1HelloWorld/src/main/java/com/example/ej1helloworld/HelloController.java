package com.example.ej1helloworld;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    @FXML
    private TextField textField;
    @FXML
    private Label welcomeText;
    private ToggleGroup tg;

    @FXML
    protected void onHelloButtonClick() {
        RadioButton selectedRadioButton =
                (RadioButton) tg.getSelectedToggle();
        if (textField.getText() != null && selectedRadioButton != null)
            welcomeText.setText("Bienvenid@ " +textField.getText()+ " a " +((RadioButton) tg.getSelectedToggle()).getText() + ".");
        else if (textField.getText()!=null)
            welcomeText.setText("Bienvenid@ " +textField.getText());
        else if (selectedRadioButton !=null)
            welcomeText.setText("Bienvenid@ a" +((RadioButton) tg.getSelectedToggle()).getText() + ".");
        else
            welcomeText.setText("Bienvenid@ ");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tg = new ToggleGroup();
        radioButton1.setToggleGroup(tg);
        radioButton2.setToggleGroup(tg);

    }
}