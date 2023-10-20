package org.example.common;

public class Comprobacion {
    public static void lugarOk(String lugar) throws LugarException {
        boolean esta = false;
        Lugar aux [] = Lugar.values();
        for(int i=0; i<aux.length && !esta;i++){
            if (aux[i].toString().equalsIgnoreCase(lugar))
                esta=true;
        }
        if (!esta)
            throw new LugarException(lugar);

    }

    public static void tipoOk(String tipo) throws TipoException {
        boolean esta = false;
        Tipo aux [] = Tipo.values();
        for(int i=0; i<aux.length && !esta;i++){
            if (aux[i].toString().equalsIgnoreCase(tipo))
                esta=true;
        }
        if (!esta)
            throw new TipoException(tipo);
    }

    public static void alFrances(String tipo) throws AlFrancesException {
        boolean noEsta = true;
        Pais aux [] = Pais.values();
        for(int i=0; i<aux.length && noEsta;i++){
            if (aux[i].toString().equalsIgnoreCase(tipo))
                noEsta=false;
        }
        if (!noEsta)
            throw new AlFrancesException();

    }
}
