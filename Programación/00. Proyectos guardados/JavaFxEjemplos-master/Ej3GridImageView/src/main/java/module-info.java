module com.example.ej3gridimageview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ej3gridimageview to javafx.fxml;
    exports com.example.ej3gridimageview;
}