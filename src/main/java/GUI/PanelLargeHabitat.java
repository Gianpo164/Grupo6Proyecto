package GUI;

import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Locale;

public class PanelLargeHabitat extends PanelHabitat {
    public PanelLargeHabitat(Habitat habitat) {
        super(habitat);
        Dimension size = new Dimension(430, 430);
        setPreferredSize(size);
    }
}
