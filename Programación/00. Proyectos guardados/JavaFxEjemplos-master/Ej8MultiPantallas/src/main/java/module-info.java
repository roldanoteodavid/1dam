module javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    requires lombok;
    requires com.google.gson;
    requires org.apache.logging.log4j;

    exports ui;

    opens domain.modelo to javafx.base, com.google.gson;
    opens ui to javafx.fxml;
    opens config to org.apache.logging.log4j;

}