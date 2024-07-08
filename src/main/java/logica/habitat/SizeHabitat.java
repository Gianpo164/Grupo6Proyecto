package logica.habitat;

/**
 * Enumeracion de los posibles tamaños de un habitat
 */
public enum SizeHabitat {
    SMALL(215,215,3,"Small"),
    MEDIUM_HORIZONTAL(430,215,5,"Medium"),
    MEDIUM_VERTICAL(215,430,5,"MediumV"),
    LARGE(430,430,7,"Large");

    private int x;
    private int y;
    private int limite;
    private String size;

    /**
     * @param x Ancho del habitat
     * @param y Alto del habitat
     * @param limite Numero maximo de animales en el habitat
     * @param size Identificador de imagenes
     */
    SizeHabitat(int x, int y, int limite, String size) {
        this.x = x;
        this.y = y;
        this.limite = limite;
        this.size = size;
    }

    /**
     * Devuelve el ancho del habitat
     * @return el ancho del habitat
     */
    public int getX() {
        return x;
    }

    /**
     * Devuelve el alto de un habitat
     * @return el alto de un habitat
     */
    public int getY() {
        return y;
    }

    /**
     * Devuelve el numero maximo de animales en el habitat
     * @return el numero maximo de animales en el habitat
     */
    public int getLimite() {
        return limite;
    }

    /**
     * Devuelve el identificador de imagenes correspondiente a los habitats
     * @return el identificador de imagenes correspondiente a los habitats
     */
    public String getSize() {
        return size;
    }
}
