package GUI;

import logica.habitat.Habitat;

import java.awt.*;

/**
 * Panel que representa un panel grande
 */
public class PanelLargeHabitat extends PanelHabitat {
    /**
     * Crea el panel y asigna su tamaño
     * @param habitat Habitat contenido en el panel
     */
    public PanelLargeHabitat(Habitat habitat) {
        super(habitat);
        Dimension size = new Dimension(430, 430);
        setPreferredSize(size);
    }
}
