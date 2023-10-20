package common;

public class Comprobacion {

    public static void categoriaOk(String categoria) throws CategoriaException {
        boolean esta = false;
        Categoria aux [] = Categoria.values();
        for(int i=0; i<aux.length && !esta;i++){
            System.out.println(aux[i].toString()+" - ");
            if (aux[i].toString().equalsIgnoreCase(categoria))
                esta=true;
        }
        /*for(Categoria c: Categoria.values())
            System.out.println(c+"-");*/
        if (!esta)
            throw new CategoriaException(categoria);

    }
}



