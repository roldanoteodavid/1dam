package com.example.dataFakerGenerator;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.datafaker.Faker;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(new Faker().pokemon().name());
    }
}
