package logica.habitat;

import javax.swing.*;

/**
 * Enumeracion de los tipos de habitat
 */
public enum TipoDeHabitat {
    BOSQUE("Forest","Habitat Boscoso", 5, 30),
    DESIERTO("Desert","Habitat Desertico", 30 ,50),
    POLAR("Artic","Habitat Polar", -20, 5),
    SABANA("Savannah","Habitat de Sabana", 25, 45),
    TROPICAL("Tropical","Habitat Tropical", 15, 35),
    MONTE("Mountain","Habitat de Monte", 0, 25);

    private String habitat;
    private String  nombre;
    private ImageIcon icono;
    private int temperaturaMinima;
    private int temperaturaMaxima;

    /**
     * Asigna atributos a los tipos de habitat
     * @param habitat Identificador de una imagen
     * @param nombre Texto a mostrar en la interfaz grafica
     */
    TipoDeHabitat(String habitat,String nombre,int temperaturaMinima,int temperaturaMaxima) {
        this.habitat = habitat;
        this.nombre = nombre;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        icono = new ImageIcon("src/main/resources/icons/"+habitat+"Icon.png");
    }

    /**
     * Devuelbe el icono del tipo de habitat
     * @return el icono del tipo de habitat
     */
    public ImageIcon getIcono() {
        return icono;
    }

    /**
     * Devuelve el identificador de una imagen
     * @return el identificador de una imagen
     */
    public String getHabitat() {
        return habitat;
    }

    /**
     * Devuelve el texto a mostrar en la interfaz grafica
     * @return el texto a mostrar en la interfaz grafica
     */
    public String getNombre() {
        return nombre;
    }

    public int getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }
}
