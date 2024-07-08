package logica.habitat;

import javax.swing.*;

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

    TipoDeHabitat(String habitat,String nombre) {
        this.habitat = habitat;
        this.nombre = nombre;
        icono = new ImageIcon("src/main/resources/icons/"+habitat+"Icon.png");
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getNombre() {
        return nombre;
    }
}
