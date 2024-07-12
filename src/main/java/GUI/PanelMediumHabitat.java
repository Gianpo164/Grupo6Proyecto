package GUI;

import logica.habitat.Habitat;

import java.awt.*;

/**
 * Panel que representa un habitat mediano
 */
public class PanelMediumHabitat extends PanelHabitat{
    /**
     * Crea el panel
     * @param habitat Habitat contenido en el panel
     */
    public PanelMediumHabitat(Habitat habitat) {
        super(habitat);
    }

    /**
     * Asigna el tamaño del panel
     * @param posicion Posicion del panel dentro de un panel base
     */
    public void setSizePanel(PosicionPanelHabitat posicion) {
        if (posicion == PosicionPanelHabitat.MEDIANO_N || posicion == PosicionPanelHabitat.MEDIANO_S) {
            setPreferredSize(new Dimension(430, 215));
        }
        else if (posicion == PosicionPanelHabitat.MEDIANO_E || posicion == PosicionPanelHabitat.MEDIANO_O) {
            setPreferredSize(new Dimension(215,430));
        }
    }
}
