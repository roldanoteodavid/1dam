package org.example.dao;

import lombok.Data;
import org.example.domain.Asesino;
import org.example.domain.Campeon;
import org.example.domain.Mago;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Data
public class Database {
    private List<Campeon> campeones;

    public Database() {
        this.campeones = new ArrayList<>();
        Mago mago1 = new Mago(1, "Corky", Math.random()*30, 4, new ArrayList<>(), 124, true);
        mago1.getHabilidades().add("inspiracion");
        mago1.getHabilidades().add("brujeria");
        mago1.getHabilidades().add("valor");
        Mago mago2 = new Mago(2, "Ashe", Math.random()*30, 2, new ArrayList<>(), 168, true);
        mago2.getHabilidades().add("precision");
        mago2.getHabilidades().add("dominacion");
        Mago mago3 = new Mago(3, "Rakan", Math.random()*30, 8, new ArrayList<>(), 177, false);
        mago3.getHabilidades().add("brujeria");
        Mago mago4 = new Mago(4, "Ahri", Math.random()*30, 15, new ArrayList<>(), 152, false);
        mago4.getHabilidades().add("valor");
        mago4.getHabilidades().add("inspiracion");
        Asesino asesino1 = new Asesino(5, "Sett", Math.random()*30, 8, new ArrayList<>(), 182, Math.random()*100);
        asesino1.getHabilidades().add("inspiracion");
        asesino1.getHabilidades().add("brujeria");
        asesino1.getHabilidades().add("valor");
        asesino1.getHabilidades().add("dominacion");
        asesino1.getHabilidades().add("precision");
        Asesino asesino2 = new Asesino(6, "Garen", Math.random()*30, 8, new ArrayList<>(), 197, Math.random()*100);
        asesino2.getHabilidades().add("dominacion");
        asesino2.getHabilidades().add("valor");
        Asesino asesino3 = new Asesino(7, "Yasuo", Math.random()*30, 8, new ArrayList<>(), 186, Math.random()*100);
        asesino3.getHabilidades().add("brujeria");
        Asesino asesino4 = new Asesino(8, "Yone", Math.random()*30, 8, new ArrayList<>(), 189, Math.random()*100);
        asesino4.getHabilidades().add("inspiracion");
        asesino4.getHabilidades().add("brujeria");
        asesino4.getHabilidades().add("valor");
        campeones.add(mago1);
        campeones.add(mago2);
        campeones.add(mago3);
        campeones.add(mago4);
        campeones.add(asesino1);
        campeones.add(asesino2);
        campeones.add(asesino3);
        campeones.add(asesino4);
    }
}
