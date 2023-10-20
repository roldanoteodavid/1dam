package ui;

import dao.DaoActividades;
import domain.modelo.Actividad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import servicios.ServicioActividades;

public class MainViewModel {
    private final ServicioActividades servicioActividades;
    private final ObservableList<Actividad> actividades;

    private MainViewModel() {
        servicioActividades = new ServicioActividades(new DaoActividades());
        actividades = FXCollections.observableArrayList(servicioActividades.getActividades());
    }

    public MainViewModel(ServicioActividades servicioActividades) {
        this.servicioActividades = servicioActividades;
        actividades = FXCollections.observableArrayList(servicioActividades.getActividades());

    }
    public ObservableList<Actividad> getActividades() {
        return actividades;
    }

    public ServicioActividades getServicioActividades() { return servicioActividades; }
}
