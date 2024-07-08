package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalirPanelButton extends JButton {
    private PanelPrincipal panelPrincipal;
    private Image imagen = new ImageIcon("src/main/resources/SalirButton.png").getImage();

    public SalirPanelButton(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        setBorder(null);
        setContentAreaFilled(false);
        setFocusable(false);

        addActionListener(new EscuchadorButton());
    }

    private class EscuchadorButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panelPrincipal.setPanelDibujar(null);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen,0,0,null);
    }
}
