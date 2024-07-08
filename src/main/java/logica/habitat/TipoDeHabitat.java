package logica.habitat;

import javax.swing.*;

/**
 * Enumeracion de los tipos de habitat
 */
public enum TipoDeHabitat {
    BOSQUE("Forest","Habitat Boscoso"),
    DESIERTO("Desert","Habitat Desertico"),
    POLAR("Artic","Habitat Polar"),
    SABANA("Savannah","Habitat de Sabana"),
    TROPICAL("Tropical","Habitat Tropical"),
    MONTE("Mountain","Habitat de Monte");

    private String habitat;
    private String  nombre;
    private ImageIcon icono;

    /**
     * Asigna atributos a los tipos de habitat
     * @param habitat Identificador de una imagen
     * @param nombre Texto a mostrar en la interfaz grafica
     */
    TipoDeHabitat(String habitat,String nombre) {
        this.habitat = habitat;
        this.nombre = nombre;
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
     *
     * Devuelve el texto a mostrar en la interfaz grafica
     * @return el texto a mostrar en la interfaz grafica
     */
    public String getNombre() {
        return nombre;
    }
}
