package GUI;

import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Locale;

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
