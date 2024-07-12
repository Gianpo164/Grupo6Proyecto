package GUI;

import logica.habitat.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Boton que determina el tipo de habitat a crear
 */
public class HabitatButton extends JButton implements ActionListener{
    private HabitatFactory fabrica;
    private PanelBaseHabitat panelBase;
    private String bioma;
    private Image imagen;

    /**
     * Crea el boton y determina el tipo de habitat a crear
     * @param habitat Tipo de habitat seleccionado
     * @param panelBase Espacio que contiene paneles para habitats
     */
    public HabitatButton(TipoDeHabitat habitat, PanelBaseHabitat panelBase) {
        switch (habitat) {
            case BOSQUE -> {
                bioma = TipoDeHabitat.BOSQUE.getHabitat();
                fabrica = new BosqueFactory();
            }
            case DESIERTO -> {
                bioma = TipoDeHabitat.DESIERTO.getHabitat();
                fabrica = new DesiertoFactory();
            }
            case POLAR -> {
                bioma = TipoDeHabitat.POLAR.getHabitat();
                fabrica = new PolarFactory();
            }
            case SABANA -> {
                bioma = TipoDeHabitat.SABANA.getHabitat();
                fabrica = new SabanaFactory();
            }
            case TROPICAL -> {
                bioma = TipoDeHabitat.TROPICAL.getHabitat();
                fabrica = new TropicalFactory();
            }
            case MONTE -> {
                bioma = TipoDeHabitat.MONTE.getHabitat();
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

    /**
     * Crea el panel donde se elegira el tamaño del habitat
     * @param ae the event to be processed
     */
    public void actionPerformed(ActionEvent ae) {
        PanelMenuSize menuSize = new PanelMenuSize(fabrica,panelBase,bioma);
        panelBase.getPanelPrincipal().setPanelDibujar(menuSize);
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
