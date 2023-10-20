package servicios;

import lombok.extern.log4j.Log4j2;
import dao.DaoActividades;
import domain.modelo.Actividad;

import java.util.List;

@Log4j2
public class ServicioActividades {
    private final DaoActividades daoActividades;

    public ServicioActividades(DaoActividades daoActividades) {
        this.daoActividades = daoActividades;
    }

    public List<Actividad> getActividades() {
        return daoActividades.getActividades();
    }

    public boolean getActividad(Actividad a) {
        return daoActividades.getActividad(a);
    }

    public boolean addActividad(Actividad a) {
        if (!getActividad(a)) {
            return daoActividades.addActividad(a);
        } else {
            return false;
        }
    }

    public boolean updateActividad(Actividad a1, Actividad a2) {
        if (daoActividades.getActividad(a2)) {
            return daoActividades.updateActividad(a1, a2);
        } else {
            return false;
        }
    }

    public boolean deleteActividad(Actividad a) {
        if (daoActividades.getActividad(a)) {
            return daoActividades.eliminarActividad(a);
        } else {
            return false;
        }
    }
}
