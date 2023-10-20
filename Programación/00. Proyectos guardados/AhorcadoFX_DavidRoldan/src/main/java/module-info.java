module com.example.ejemploahorcado {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafaker;


    opens com.example.ejemploahorcado to javafx.fxml;
    exports com.example.ejemploahorcado;
    exports com.example.ui;
    opens com.example.ui to javafx.fxml;
}