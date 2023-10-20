module com.example.javafxfaker2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires datafaker;

    opens com.example.dataFakerGenerator to javafx.fxml;
    exports com.example.dataFakerGenerator;
}