module com.example.ej2alertcombo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ej2alertcombo to javafx.fxml;
    exports com.example.ej2alertcombo;
}