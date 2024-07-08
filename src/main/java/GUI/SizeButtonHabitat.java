package GUI;

import logica.habitat.Habitat;
import logica.habitat.HabitatFactory;
import logica.habitat.SizeHabitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizeButtonHabitat extends JButton {
    private HabitatFactory fabrica;
    private SizeHabitat size;
    private Habitat habitatCreado;
    private PanelBaseHabitat panel;
    private PanelHabitat panelHabitat;
    private PosicionPanelHabitat posicionPanelHabitat;

    public SizeButtonHabitat(HabitatFactory fabrica, SizeHabitat size, PosicionPanelHabitat posicionPanelHabitat, PanelBaseHabitat panel) {
        this.fabrica = fabrica;
        this.size = size;
        this.panel = panel;
        this.posicionPanelHabitat = posicionPanelHabitat;

        addActionListener(new EscuchadorButton());
    }

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
            panel.addHabitat(habitatCreado);
            panel.setPanelHabitat(panelHabitat);
            panel.setPaneldibujar(null);

            for (PanelBaseHabitat i : panel.getPanelPrincipal().getPaneles()) {
                i.setSelected(false);
                i.setMenuHabitat(false);
            }
        }
    }
}
