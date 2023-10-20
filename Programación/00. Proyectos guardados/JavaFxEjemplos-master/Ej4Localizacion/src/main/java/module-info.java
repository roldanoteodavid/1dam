module com.example.ej4localizacion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ej4localizacion to javafx.fxml;
    exports com.example.ej4localizacion;
}