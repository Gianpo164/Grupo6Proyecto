package GUI;

import logica.habitat.Habitat;
import logica.habitat.HabitatFactory;
import logica.habitat.SizeHabitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Boton que determina el tamaño del habitat a crear
 */
public class SizeButtonHabitat extends JButton {
    private HabitatFactory fabrica;
    private SizeHabitat size;
    private Habitat habitatCreado;
    private PanelBaseHabitat panel;
    private PanelHabitat panelHabitat;
    private PosicionPanelHabitat posicionPanelHabitat;
    private Image imagen;

    /**
     * Crea el boton y asigna sus atributos
     * @param fabrica Fabrica que crea el habitat seleccionado
     * @param size Tamaño seleccionado
     * @param posicionPanelHabitat Posicion del panel del habitat seleccionado
     * @param panel Panel donde se añadira el panel del habitat
     * @param bioma Identificador de la imagen del tipo de habitat
     */
    public SizeButtonHabitat(HabitatFactory fabrica, SizeHabitat size, PosicionPanelHabitat posicionPanelHabitat, PanelBaseHabitat panel, String bioma) {
        this.fabrica = fabrica;
        this.size = size;
        this.panel = panel;
        this.posicionPanelHabitat = posicionPanelHabitat;
        imagen = new ImageIcon("src/main/resources/iconsButtonHabitat/"+bioma+size.getSize()+".png").getImage();

        setBorder(null);
        setContentAreaFilled(false);
        setFocusable(false);

        addActionListener(new EscuchadorButton());
    }

    /**
     * Determina el tamaño del habitat, lo crea y añade al panel que contiene paneles de habitats
     */
    private class EscuchadorButton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            switch (size) {
                case SMALL -> {
                    habitatCreado = fabrica.crearSmallHabitat();
                    panelHabitat = new PanelSmallHabitat(habitatCreado);
                }
                case MEDIUM_HORIZONTAL -> {
                    habitatCreado = fabrica.crearMediumHabitat();
                    habitatCreado.setSizeHabitat(SizeHabitat.MEDIUM_HORIZONTAL);
                    PanelMediumHabitat panelMediumHabitat = new PanelMediumHabitat(habitatCreado);
                    panelMediumHabitat.setSizePanel(posicionPanelHabitat);
                    panelHabitat = panelMediumHabitat;
                }
                case MEDIUM_VERTICAL -> {
                    habitatCreado = fabrica.crearMediumHabitat();
                    habitatCreado.setSizeHabitat(SizeHabitat.MEDIUM_VERTICAL);
                    PanelMediumHabitat panelMediumHabitat = new PanelMediumHabitat(habitatCreado);
                    panelMediumHabitat.setSizePanel(posicionPanelHabitat);
                    panelHabitat = panelMediumHabitat;
                }
                case LARGE -> {
                    habitatCreado = fabrica.crearLargeHabitat();
                    panelHabitat = new PanelLargeHabitat(habitatCreado);
                }
            }
            panel.setPosicionPanelHabitat(posicionPanelHabitat);
            panel.getPanelPrincipal().addHabitat(habitatCreado);
            panel.setPanelHabitat(panelHabitat);
            panel.getPanelPrincipal().setPanelDibujar(null);

            for (PanelBaseHabitat i : panel.getPanelPrincipal().getPaneles()) {
                i.setSelected(false);
                i.setMenuHabitat(false);
            }
        }
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
