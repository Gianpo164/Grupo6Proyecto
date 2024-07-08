package GUI;

import logica.habitat.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HabitatButton extends JButton implements ActionListener{
    private HabitatFactory fabrica;
    private PanelBaseHabitat panelBase;
    private Image imagen;

    public HabitatButton(TipoDeHabitat habitat, PanelBaseHabitat panelBase) {
        switch (habitat) {
            case BOSQUE -> {
                setText("Bosque");
                fabrica = new BosqueFactory();
            }
            case DESIERTO -> {
                setText("Desierto");
                fabrica = new DesiertoFactory();
            }
            case POLAR -> {
                setText("Polar");
                fabrica = new PolarFactory();
            }
            case SABANA -> {
                setText("Sabana");
                fabrica = new SabanaFactory();
            }
            case TROPICAL -> {
                setText("Tropical");
                fabrica = new TropicalFactory();
            }
            case MONTE -> {
                setText("Monte");
                fabrica = new MonteFactory();
            }
        }
        this.panelBase = panelBase;
        imagen = habitat.getIcono().getImage();
        setBorder(null);
        setFocusable(false);
        setContentAreaFilled(false);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        PanelMenuSize menuSize = new PanelMenuSize(fabrica,panelBase);
        panelBase.setPaneldibujar(menuSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen,0,0,null);
    }
}
