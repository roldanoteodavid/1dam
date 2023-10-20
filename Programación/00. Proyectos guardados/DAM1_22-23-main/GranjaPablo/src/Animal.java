public abstract class Animal {
    
    protected String id;
    protected String nombre;
    protected int fechaNac;
    protected String color;
    protected String clasificacion;
    
    
    /*
    
    */
    public Animal(){
     int aux = (int)(Math.random()*101);
     id = String.format("%03d", aux);
     nombre = Utilidades.nombres[(int)(Math.random()*Utilidades.nombres.length)];
     fechaNac =  Utilidades.anyos[(int)(Math.random()*Utilidades.anyos.length)];
     color = Utilidades.color[(int)(Math.random()*Utilidades.color.length)];
     
    }
    /**
     * Constructor que permite crear una instancia de la Clase Animal con los parámetros introducidos como argumentos de entrada
     * @param id String que servirá de identificador al animal
     * @param nombre
     * @param fechaNac
     * @param color
     * @param clasificacion 
     */
    public Animal(String id, String nombre, int fechaNac, String color, String clasificacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.color = color;
        this.clasificacion = clasificacion;
    }
    /**
     * Método que devuelve el identificador de animal
     * @return String que recoge el id
     */
    public String getId() {
        return id;
    }
    /**
     * Método que permite modificar el identificador del animal, el nuevo identificador será el introducido como argumento de entrada.
     * @param id String que representa el nuevo identificador
     */
    
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(int fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNac=" + fechaNac +
                ", color='" + color + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                '}';
    }

    public abstract boolean esRentable();

}
