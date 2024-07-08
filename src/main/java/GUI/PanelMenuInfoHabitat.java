package GUI;

import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;

public class PanelMenuInfoHabitat extends PanelMenu{
    private Habitat habitat;
    private PanelInfoAnimales infoAnimales;
    private JScrollPane scrollPane;
    private Image imagenInfoHabitat;


    public PanelMenuInfoHabitat(Habitat habitat, PanelPrincipal panelPrincipal) {
        this.habitat = habitat;
        imagenInfoHabitat = new ImageIcon(getClass().getClassLoader().getResource("InfoHabitat.png")).getImage();
        PanelGenaralInfo panelInfo = new PanelGenaralInfo(habitat,panelPrincipal);

        PanelAddAnimales menuAnimales = new PanelAddAnimales(habitat);

        infoAnimales = new PanelInfoAnimales(habitat);
        scrollPane = new JScrollPane(infoAnimales);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar jBar = scrollPane.getVerticalScrollBar();
        jBar.setUnitIncrement(10);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.getVerticalScrollBar().setOpaque(false);
        scrollPane.setBorder(null);


        setLayout(new BorderLayout());
        add(panelInfo, BorderLayout.NORTH);
        add(menuAnimales, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenInfoHabitat, 0, 0, null);
    }
}
