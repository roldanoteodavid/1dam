module com.example.ejemploahorcado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejemploahorcado to javafx.fxml;
    exports com.example.ejemploahorcado;
}