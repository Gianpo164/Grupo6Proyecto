package GUI;

import logica.GameLoop;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel que contienen todos los componentes mostrados en pantalla
 */
public class PanelPrincipal extends JPanel {
    private GameLoop gl;
    private JPanel panelDibujar;
    private PanelZoo panelZoo = new PanelZoo(this);
    private ArrayList<Habitat> habitats = new ArrayList<>();
    private ArrayList<PanelHabitat> panelesHabitats = new ArrayList<>();
    private PanelMenuInicial menuInicial = new PanelMenuInicial(this, habitats);
    private ArrayList<PanelBaseHabitat> paneles = new ArrayList<>();

    /**
     * Inicializa los componentes principales del programa
     */
    public PanelPrincipal() {
        setVisible(true);
        setLayout(new BorderLayout());

        gl = new GameLoop();
        gl.setPanel(this);
        gl.setHabitats(habitats);
        Thread gameLoop = new Thread(gl);
        gameLoop.start();

        paneles = panelZoo.getPaneles();
        panelDibujar = menuInicial;

        add(panelZoo, BorderLayout.WEST);
        add(panelDibujar, BorderLayout.EAST);
    }

    /**
     * Determina el panel a dibujar en el lado derecho de la interfaz
     * @param panel Panel menu que se intercambia
     */
    public void setPanelDibujar(JPanel panel) {
        remove(panelDibujar);
        if(panel == null) {
            panelDibujar = menuInicial;
        }
        else {
            panelDibujar = panel;
        }
        add(panelDibujar, BorderLayout.EAST);
        repaint();
    }

    /**
     * Dibuja los componentes graficos
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        revalidate();
        add(panelDibujar, BorderLayout.EAST);
    }

    /**
     * Añade un habitat construido a la lista de habitats existentes
     * @param habitat Habitat construido
     */
    public void addHabitat(Habitat habitat){
        habitats.add(habitat);
    }

    /**
     * Añade el panel de un habitat a la lista de paneles existentes
     * @param panelHabitat Panel donde se encuentra el habitat construido
     */
    public void addPanelHabitat(PanelHabitat panelHabitat) {
        panelesHabitats.add(panelHabitat);
    }

    /**
     * Devuelve los paneles principales que contienen habitats
     * @return los paneles principales que contienen habitats
     */
    public ArrayList<PanelBaseHabitat> getPaneles() {
        return paneles;
    }

    /**
     * Devuelve el panel que contiene los paneles que contienen habitats
     * @return el panel que contiene los paneles que contienen habitats
     */
    public PanelZoo getPanelZoo() {
        return panelZoo;
    }

    /**
     * Devuelve la clase que controla la logica del programa
     * @return la clase que controla la logica del programa
     */
    public GameLoop getGl() {
        return gl;
    }

    /**
     * Devuelve la lista de paneles de habitats
     * @return la lista de paneles de habitats
     */
    public ArrayList<PanelHabitat> getPanelesHabitats() {
        return panelesHabitats;
    }
}
