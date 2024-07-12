package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que determina aspectos basicos de los paneles que funcionan como menu
 */
abstract public class PanelMenu extends JPanel {
    /**
     * Asigna los atributos en comun que compartiran los paneles menu
     */
    public PanelMenu() {
        Dimension size = new Dimension(500, 900);
        setPreferredSize(size);
        setVisible(true);
    }
}
