package ui;

import dao.DaoActividades;
import domain.modelo.Actividad;
import io.github.palexdev.materialfx.controls.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import servicios.ServicioActividades;

import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class SegundaPantallaClientesController implements Initializable {

    private final MainViewModel viewModel;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MFXButton botonAdd;
    @FXML
    private MFXButton botonDelete;
    @FXML
    private MFXButton botonUpdate;
    @FXML
    private TableView<Actividad> tablaActividades;
    @FXML
    private TableColumn<Actividad, String> columna1;
    @FXML
    private TableColumn<Actividad, Integer> columna2;
    @FXML
    private TableColumn<Actividad, String> columna3;
    @FXML
    private TableColumn<Actividad, String> columna4;
    @FXML
    private TableColumn<Actividad, String> columna5;
    @FXML
    private MFXDatePicker fecha;
    @FXML
    private MFXTextField nombre;
    @FXML
    private MFXTextField lugar;
    @FXML
    private MFXTextField id;
    @FXML
    private MFXTextField precio;
    @FXML
    private Label label;
    @FXML
    private MFXToggleButton toggleidioma;

    @FXML
    private MFXToggleButton modooscuro;


    public SegundaPantallaClientesController() {
        viewModel = new MainViewModel(new ServicioActividades(new DaoActividades()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablaActividades.setItems(viewModel.getActividades());
        //mapeo de los atributos a las columnas
        columna1.setCellValueFactory(new PropertyValueFactory<>("id"));
        columna2.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columna3.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        columna4.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columna5.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        //comboBox.getItems().addAll(resourceBundle.getString("combo1"), resourceBundle.getString("combo2"), resourceBundle.getString("combo3"), resourceBundle.getString("combo4"));
        //si queremos que al seleccionar un elemento de la tabla se rellenen los textField hay que añadir un listener a la tabla para que
        //ejecute el método onEdit cada vez que ocurra..
        tablaActividades.setOnMouseClicked((MouseEvent event) -> onEdit());
    }

    public void onEdit() {
        //check si se ha seleccionado un elemento y actualiza los textField con los valores de los atributos del elemento seleccionado
        //Con esto no haría falta la imagen de ayuda puesto que el usuario no tendría que introducirlo en los textField
        if (tablaActividades.getSelectionModel().getSelectedItem() != null) {
            Actividad selectedActividad = tablaActividades.getSelectionModel().getSelectedItem();
            id.setText(String.valueOf(selectedActividad.getId()));
            nombre.setText(selectedActividad.getNombre());
            lugar.setText(String.valueOf(selectedActividad.getLugar()));
            precio.setText(String.valueOf(selectedActividad.getPrecio()));
            fecha.setText(String.valueOf(selectedActividad.getFecha()));
            //comboBox.setValue(selectedActividad.getFecha());
        }
    }

    @FXML
    private void cambioIdioma() {
        ResourceBundle bundle;
        if (toggleidioma.isSelected()) {
            bundle = ResourceBundle.getBundle("textosFX", new Locale("pt"));
        } else {
            bundle = ResourceBundle.getBundle("textosFX", Locale.getDefault());
        }
        label.setText(bundle.getString("titulo"));
        columna1.setText(bundle.getString("columnaId"));
        columna2.setText(bundle.getString("columnaNombre"));
        columna3.setText(bundle.getString("columnaLugar"));
        columna4.setText(bundle.getString("columnaPrecio"));
        columna5.setText(bundle.getString("columnaFecha"));
        botonAdd.setText(bundle.getString("botonAdd"));
        botonDelete.setText(bundle.getString("botonDelete"));
        botonUpdate.setText(bundle.getString("botonUpdate"));
        nombre.setPromptText(bundle.getString("columnaNombre"));
        lugar.setPromptText(bundle.getString("columnaLugar"));
        id.setPromptText(bundle.getString("columnaId"));
        precio.setPromptText(bundle.getString("columnaPrecio"));
        fecha.setPromptText(bundle.getString("columnaFecha"));
        //comboBox.setPromptText(bundle.getString("columnaRaza"));
        toggleidioma.setText(bundle.getString("idioma"));
        modooscuro.setText(bundle.getString("modooscuro"));
        //comboBox.getItems().clear();
        //comboBox.getItems().addAll(bundle.getString("combo1"), bundle.getString("combo2"), bundle.getString("combo3"), bundle.getString("combo4"));
    }

    @FXML
    private void modoOscuro() {
        if (modooscuro.isSelected()) {
            toggleidioma.setTextFill(Color.WHITE);
            modooscuro.setTextFill(Color.WHITE);
            anchorPane.setStyle("-fx-background-color: #000000;");
            label.setTextFill(Color.WHITE);
            label.setStyle("-fx-background-color: #000000");
            botonAdd.setStyle("-fx-text-fill: white; -fx-background-color: #4B0082;");
            botonDelete.setStyle("-fx-text-fill: white; -fx-background-color: #4B0082;");
            botonUpdate.setStyle("-fx-text-fill: white; -fx-background-color: #4B0082;");
        } else {
            toggleidioma.setTextFill(Color.BLACK);
            modooscuro.setTextFill(Color.BLACK);
            anchorPane.setStyle("-fx-background-color: #ffffff;");
            label.setTextFill(Color.BLACK);
            label.setStyle("-fx-background-color: #ffffff");
            botonAdd.setStyle("-fx-text-fill: black; -fx-background-color: #e6e9eb;");
            botonDelete.setStyle("-fx-text-fill: black; -fx-background-color: #e6e9eb;");
            botonUpdate.setStyle("-fx-text-fill: black; -fx-background-color: #e6e9eb;");
        }
    }

    @FXML
    private void addActividad() {
        if (id.getText().isEmpty() || nombre.getText().isEmpty() || lugar.getText().isEmpty() || precio.getText().isEmpty() || fecha.getValue().toString().isEmpty()) {
            alertaErrorAddActividad();
        } else {
            Actividad Actividad = new Actividad(Integer.parseInt(id.getText()), nombre.getText(), lugar.getText(), Double.parseDouble(precio.getText()), fecha.getValue());
            if (viewModel.getServicioActividades().addActividad(Actividad)) {
                tablaActividades.getItems().add(Actividad);
                alertaOKAddActividad();
                limpiarCampos();
            } else {
                alertaErrorAddActividad();
            }
        }
    }

    @FXML
    private void deleteActividad() {
        Actividad Actividad = tablaActividades.getSelectionModel().getSelectedItem();
        if (Actividad != null && viewModel.getServicioActividades().deleteActividad(Actividad)) {
            alertaConfirmationDeleteActividad(Actividad);
            alertaOkDeleteActividad();
            limpiarCampos();
        } else {
            alertaErrorDeleteActividad();
        }
    }

    @FXML
    private void updateActividad() {
        if (nombre.getText() == null || lugar.getText() == null || id.getText() == null || precio.getText() == null || fecha.getText() == null) {
            alertaErrorUpdateActividad();
        } else {
            Actividad Actividad1 = new Actividad(Integer.parseInt(id.getText()), nombre.getText(), lugar.getText(), Double.parseDouble(precio.getText()), fecha.getValue());
            Actividad Actividad2 = tablaActividades.getSelectionModel().getSelectedItem();
            if (viewModel.getServicioActividades().updateActividad(Actividad1, Actividad2)) {
                tablaActividades.getItems().remove(Actividad2);
                tablaActividades.getItems().add(Actividad1);
                alertaOKUpdateActividad();
                limpiarCampos();
                tablaActividades.refresh();
            } else {
                alertaErrorUpdateActividad();
            }
        }
    }

    private void limpiarCampos() {
        id.clear();
        nombre.clear();
        lugar.clear();
        precio.clear();
        fecha.clear();
    }

    @FXML
    private void ayuda() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Ayuda");
        a.setHeaderText("Ayuda");
        a.setContentText("Selecciona la actividad a actualizar en la tabla e introduce los nuevos datos");
        a.show();
    }

    @FXML
    private void alertaErrorAddActividad() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al añadir la actividad");
        alert.setContentText("No se ha podido añadir la actividad");
        alert.show();
    }

    private void alertaOKAddActividad() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Actividad añadida correctamente");
        alert.setHeaderText("Actividad añadida correctamente");
        alert.setContentText("Se ha añadido correctamente");
        alert.show();
    }

    private void alertaOKUpdateActividad() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Actividad actualizada con éxito");
        alert.setHeaderText("Actividad actualizada con éxito");
        alert.setContentText("Se ha actualizado correctamente");
        alert.show();
    }

    @FXML
    private void alertaErrorUpdateActividad() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al actualizar actividad");
        alert.setContentText("Problemas al actualizar la actividad");
        alert.show();
    }

    private void alertaConfirmationDeleteActividad(Actividad actividad) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Diálogo de Confirmación");
        alert.setHeaderText("Diálogo confirmación");
        alert.setContentText("Confirma el borrado de " + actividad + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            tablaActividades.getItems().remove(actividad);
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setTitle("Actividad eliminada con éxito");
            alert2.setHeaderText("Actividad eliminada con éxito");
            alert2.setContentText("Se ha eliminado correctamente");
            alert2.show();
        }

    }

    private void alertaOkDeleteActividad() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Actividad eliminada con éxito");
        alert.setHeaderText("Actividad eliminada con éxito");
        alert.setContentText("Se ha eliminado correctamente");
        alert.show();
    }

    @FXML
    private void alertaErrorDeleteActividad() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al eliminar el Actividad");
        alert.setContentText("No se ha podido eliminar el Actividad");
        alert.show();
    }

}