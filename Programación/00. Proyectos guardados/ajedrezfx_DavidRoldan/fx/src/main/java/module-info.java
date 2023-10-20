module UI {
    requires javafx.controls;
    requires javafx.fxml;


    exports UI;
    opens UI to javafx.fxml;
}