package GUI;

import logica.habitat.Habitat;

import java.awt.*;

public class PanelMediumHabitat extends PanelHabitat{

    public PanelMediumHabitat(Habitat habitat) {
        super(habitat);
    }

    public void setSizePanel(PosicionPanelHabitat posicion) {
        if (posicion == PosicionPanelHabitat.MEDIANO_N || posicion == PosicionPanelHabitat.MEDIANO_S) {
            setPreferredSize(new Dimension(430, 215));
        }
        else if (posicion == PosicionPanelHabitat.MEDIANO_E || posicion == PosicionPanelHabitat.MEDIANO_O) {
            setPreferredSize(new Dimension(215,430));
        }
    }
}
