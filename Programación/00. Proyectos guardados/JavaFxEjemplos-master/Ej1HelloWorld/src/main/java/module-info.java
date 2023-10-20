module com.example.ej1helloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ej1helloworld to javafx.fxml;
    exports com.example.ej1helloworld;
}