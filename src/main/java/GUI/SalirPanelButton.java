package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Boton que cierra un panel
 */
public class SalirPanelButton extends JButton implements ActionListener{
    private PanelPrincipal panelPrincipal;
    private Image imagen = new ImageIcon("src/main/resources/SalirButton.png").getImage();

    /**
     * Crea el boton y asigna sus atributos
     * @param panelPrincipal Panel que contiene y dibuja los componentes en pantalla
     */
    public SalirPanelButton(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        setBorder(null);
        setContentAreaFilled(false);
        setFocusable(false);

        addActionListener(this);
    }

    /**
     * Reemplaza el panel actual por el panel predetermiando
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        panelPrincipal.setPanelDibujar(null);
    }

    /**
     * Dibuja la imagen del boton
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen,0,0,null);
    }
}
