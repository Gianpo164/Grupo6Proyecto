package GUI;

import logica.habitat.Habitat;

import java.awt.*;

public class PanelSmallHabitat extends PanelHabitat{
    public PanelSmallHabitat(Habitat habitat) {
        super(habitat);
        Dimension size = new Dimension(215, 215);
        setPreferredSize(size);
    }
}
