package GUI;

import logica.habitat.Habitat;

import java.awt.*;

/**
 * Panel que representa un habitat pequeño
 */
public class PanelSmallHabitat extends PanelHabitat{
    /**
     * Crea el panel y asigna su tamaño
     * @param habitat Habitat contenido en el panel
     */
    public PanelSmallHabitat(Habitat habitat) {
        super(habitat);
        Dimension size = new Dimension(215, 215);
        setPreferredSize(size);
    }
}
