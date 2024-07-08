package GUI;

import logica.GameLoop;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel {
    private JPanel panelDibujar;
    private PanelZoo panelZoo = new PanelZoo(this);
    private ArrayList<Habitat> habitats = new ArrayList<>();
    private ArrayList<PanelHabitat> panelesHabitats = new ArrayList<>();
    private PanelMenuInicial menuInicial = new PanelMenuInicial(this, habitats);
    private ArrayList<PanelBaseHabitat> paneles = new ArrayList<>();

    public PanelPrincipal() {
        setVisible(true);
        setLayout(new BorderLayout());

        GameLoop gl = new GameLoop();
        gl.setPanel(this);
        gl.setHabitats(habitats);
        Thread test1 = new Thread(gl);
        test1.start();

        paneles = panelZoo.getPaneles();
        panelDibujar = menuInicial;

        add(panelZoo, BorderLayout.WEST);
        add(panelDibujar, BorderLayout.EAST);
    }

    public void setPanelDibujar(JPanel panel) {
        remove(panelDibujar);
        if(panel == null) {
            panelDibujar = menuInicial;
        }
        else {
            panelDibujar = panel;
        }
        add(panelDibujar, BorderLayout.EAST);
        revalidate();//no tocar
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){ //modificar
        super.paintComponent(g);
        revalidate();
        add(panelDibujar, BorderLayout.EAST);
    }

    public void addHabitat(Habitat habitat){
        habitats.add(habitat);
    }

    public void addPanelHabitat(PanelHabitat panelHabitat) {
        panelesHabitats.add(panelHabitat);
    }

    public ArrayList<PanelBaseHabitat> getPaneles() {
        return paneles;
    }

    public PanelZoo getPanelZoo() {
        return panelZoo;
    }

    public ArrayList<PanelHabitat> getPanelesHabitats() {
        return panelesHabitats;
    }
}
