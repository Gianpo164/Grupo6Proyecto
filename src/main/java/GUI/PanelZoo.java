package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.GridBagConstraints.*;

public class PanelZoo extends JPanel {
    private ArrayList<PanelBaseHabitat> paneles = new ArrayList<>();
    private PanelPrincipal panelPrincipal;
    private Image Fondo;

    public PanelZoo(PanelPrincipal panelPrincipal) {

        Dimension size = new Dimension(1374,900);
        setPreferredSize(size);
        setVisible(true);
        Fondo = new ImageIcon(getClass().getClassLoader().getResource("Fondo.png")).getImage();

        this.panelPrincipal = panelPrincipal;
        setLayout(new GridBagLayout());

        addComponents();
    }

    private void addComponents() {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = NORTHWEST;
        c.weighty = 1;
        c.weightx = 15;
        c.gridx = 0;
        c.gridy = 0;

        PanelBaseHabitat NW = new PanelBaseHabitat(panelPrincipal);
        this.add(NW, c);
        paneles.add(NW);

        c.anchor = NORTH;
        c.gridx = 1;
        c.gridy = 0;

        PanelBaseHabitat N = new PanelBaseHabitat(panelPrincipal);
        this.add(N, c);
        paneles.add(N);

        c.anchor = NORTHEAST;
        c.gridx = 2;
        c.gridy = 0;

        PanelBaseHabitat NE = new PanelBaseHabitat(panelPrincipal);
        this.add(NE, c);
        paneles.add(NE);

        c.anchor = SOUTHWEST;
        c.gridx = 0;
        c.gridy = 1;

        PanelBaseHabitat SW = new PanelBaseHabitat(panelPrincipal);
        this.add(SW, c);
        paneles.add(SW);

        c.anchor = SOUTH;
        c.gridx = 1;
        c.gridy = 1;

        PanelBaseHabitat S = new PanelBaseHabitat(panelPrincipal);
        this.add(S, c);
        paneles.add(S);

        c.anchor = SOUTHEAST;
        c.gridx = 2;
        c.gridy = 1;

        PanelBaseHabitat SE = new PanelBaseHabitat(panelPrincipal);
        this.add(SE, c);
        paneles.add(SE);
    }

    public ArrayList<PanelBaseHabitat> getPaneles() {
        return paneles;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Fondo, 0, 0, null);
    }
}
