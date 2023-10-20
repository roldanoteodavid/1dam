package com.example.ej4localizacion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private VBox mainVbox;
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
    protected void onClick() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mensajes",Locale.getDefault());
        RadioButton selectedRadioButton =
                (RadioButton) tg.getSelectedToggle();
        if (textField.getText() != null && selectedRadioButton != null)
            welcomeText.setText(resourceBundle.getString("mensaje") +textField.getText()+ resourceBundle.getString("a")+((RadioButton) tg.getSelectedToggle()).getText() + ".");
        else if (textField.getText()!=null)
            welcomeText.setText(resourceBundle.getString("mensaje") +textField.getText());
        else if (selectedRadioButton !=null)
            welcomeText.setText(resourceBundle.getString("mensaje")+((RadioButton) tg.getSelectedToggle()).getText() + ".");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Locale.setDefault(Locale.ENGLISH);
        tg = new ToggleGroup();
        radioButton1.setToggleGroup(tg);
        radioButton2.setToggleGroup(tg);

    }

    public void onEnglish(ActionEvent actionEvent) throws IOException {
            Locale.setDefault(Locale.ENGLISH);
    }

    public void onSpanish(ActionEvent actionEvent) throws IOException {
        Locale.setDefault(new Locale("es"));
    }}