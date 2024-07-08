package GUI;

import javax.swing.*;
import java.awt.*;

abstract public class PanelMenu extends JPanel {
    public PanelMenu() {
        Dimension size = new Dimension(500, 900);
        setPreferredSize(size);
        setVisible(true);
    }
}
