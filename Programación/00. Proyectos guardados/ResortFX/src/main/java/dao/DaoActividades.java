package dao;

import domain.modelo.Actividad;

import java.util.ArrayList;
import java.util.List;

public class DaoActividades {
    private final Database db;

    public DaoActividades() {
        this.db = new Database();
    }

    public boolean addActividad(Actividad p) {
        List<Actividad> actividades = db.loadActividades();
        if (actividades == null) {
            actividades = new ArrayList<>();
        }
        actividades.add(p);
        return db.saveActividades(actividades);
    }

    public List<Actividad> getActividades() {
        return db.loadActividades();
    }
    public boolean eliminarActividad(Actividad p) {
        List<Actividad> actividades = db.loadActividades();
        actividades.remove(p);
        return db.saveActividades(actividades);
    }

    public boolean updateActividad(Actividad a1, Actividad a2) {
        List<Actividad> actividades = db.loadActividades();
        actividades.remove(a2);
        actividades.add(a1);
        return db.saveActividades(actividades);
    }

    public boolean getActividad(Actividad actividad) {
        List<Actividad> actividades = db.loadActividades();
        return actividades.stream().anyMatch(a -> a.equals(actividad));
    }
}
