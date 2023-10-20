package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class FxmlLoader {
    private Pane view;

    public Pane getView(String filename) {
        try {
            URL fileURI = MainFX.class.getResource("/fxml/" + filename);
            if (fileURI == null)
                throw new FileNotFoundException("Fichero no encontrado");
            ResourceBundle rb = ResourceBundle.getBundle("textosFX", Locale.getDefault());
            view = new FXMLLoader().load(fileURI,rb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("FXML no cargado");
        }
        return view;

    }
}
