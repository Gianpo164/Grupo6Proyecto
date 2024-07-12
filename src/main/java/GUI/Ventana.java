package GUI;

import javax.swing.*;

/**
 * Ventana que genera el programa
 */
public class Ventana extends JFrame {
    public Ventana() {
        PanelPrincipal panel = new PanelPrincipal();
        add(panel);
        setVisible(true);
        setResizable(false);
        setTitle("Proyecto Zoo");
        setIconImage(new ImageIcon("src/main/resources/icons/LeonIcon.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
