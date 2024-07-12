package GUI;

import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Panel que contiene habitats construiudos
 */
public class PanelBaseHabitat extends JPanel implements MouseListener {
    private Image image;
    private boolean isSelected;
    private PanelPrincipal panelPrincipal;
    private PanelHabitat panelHabitat = null;
    private PosicionPanelHabitat posicionPanelHabitat;
    private ArrayList<Integer> ocupado = new ArrayList<>();
    private GridBagConstraints c = new GridBagConstraints();
    private boolean menuHabitat;


    /**
     * Genera el panel
     * @param panelPrincipal panel que contiene y dibuja los componentes en pantalla
     */
    public PanelBaseHabitat(PanelPrincipal panelPrincipal) {
        image = new ImageIcon(getClass().getClassLoader().getResource("CreateHabitat.png")).getImage();
        Dimension size = new Dimension(430,430);
        setPreferredSize(size);
        setOpaque(false);
        setVisible(true);
        setLayout(new GridBagLayout());

        for (int i = 0; i<4; i++) {
            ocupado.add(0);
        }

        this.panelPrincipal = panelPrincipal;
        addMouseListener(this);
    }

    /**
     * Asigna la confirmacion para empezar con el proceso de construir un habitat
     * @param menuHabitat Booleano que determina si se crea sel panel de construccion
     */
    public void setMenuHabitat(boolean menuHabitat) {
        this.menuHabitat = menuHabitat;
    }

    /**
     * Crea el panel que inicia el proceso de crear un habitat
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (menuHabitat) {
            PanelMenuHabitat menuHabitat = new PanelMenuHabitat(this);
            panelPrincipal.setPanelDibujar(menuHabitat);
            setColor(Color.gray);
        }
    }

    /**
     * Determina el espacio y la posicion que utilizara un panel que contiene un habitat
     * @param panelHabitat Panel que contiene un habitat
     */
    public void setPanelHabitat(PanelHabitat panelHabitat) {
        c.gridx = posicionPanelHabitat.getX();
        c.gridy = posicionPanelHabitat.getY();
        c.gridheight = posicionPanelHabitat.getAlto();
        c.gridwidth = posicionPanelHabitat.getAncho();
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = posicionPanelHabitat.getAnchor();
        this.panelHabitat = panelHabitat;
        panelHabitat.setPanelPrincipal(panelPrincipal);
        panelPrincipal.addPanelHabitat(panelHabitat);

        switch (posicionPanelHabitat) {
            case GRANDE -> {
                for (int i = 0; i<4; i++) {
                    ocupado.set(i, 1);
                }
            }
            case MEDIANO_N -> {
                ocupado.set(0,1);
                ocupado.set(1,1);
            }
            case MEDIANO_S -> {
                ocupado.set(2,1);
                ocupado.set(3,1);
            }
            case MEDIANO_E -> {
                ocupado.set(1,1);
                ocupado.set(3,1);
            }
            case MEDIANO_O -> {
                ocupado.set(0,1);
                ocupado.set(2,1);
            }
            case CHICO_NE -> {
                ocupado.set(1,1);
            }
            case CHICO_NO -> {
                ocupado.set(0,1);
            }
            case CHICO_SE -> {
                ocupado.set(3,1);
            }
            case CHICO_SO -> {
                ocupado.set(2,1);
            }
        }
    }

    /**
     * Asigna el panel a dibujar en el panel principal
     * @param menu Panel tipo menu a dibujar
     */
    public void setPaneldibujar(PanelMenu menu){  //Cambiar usos para eliminar metodo
        panelPrincipal.setPanelDibujar(menu);
    }

    /**
     * Añade un habitat creado a una lista dentro del panel principal
     * @param habitat Habitat creado
     */
    public void addHabitat(Habitat habitat){    //Cambiar usos para eliminar metodo
        panelPrincipal.addHabitat(habitat);
    }

    /**
     * Asigna el color del panel
     * @param color Color a cambiar
     */
    public void setColor(Color color){ setBackground(color);}

    /**
     * Determina si el panel ha sido seleccionado
     * @param b Booleano que representa la seleccion del panel
     */
    public void setSelected(boolean b) {
        isSelected = b;
    }

    /**
     * Asigna la posicion en la que ira un panel que contiene un habitat
     * @param posicionPanelHabitat Enumeracion de las distintas posiciones en las que puede ir un panel que contiene un habitat
     */
    public void setPosicionPanelHabitat(PosicionPanelHabitat posicionPanelHabitat) {
        this.posicionPanelHabitat = posicionPanelHabitat;
    }

    /**
     * Devuelve la lista de posiciones ocupadas por un panel que contiene un habitat
     * @return Liata de posiciones ocupadas
     */
    public ArrayList<Integer> getOcupado() {
        return ocupado;
    }

    /**
     * Devuelve el panel que contiene y dibuja los componentes en pantalla
     * @return el panel que contiene y dibuja los componentes en pantalla
     */
    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * Agrega los distintos paneles que contienen habitats dentro de este panel y dibuja la identificacion de que el panel fue seleccionado
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){ //modificar
        super.paintComponent(g);

        if (panelHabitat != null) {
            add(panelHabitat,c);
        }
        if(isSelected){
            g.drawImage(image, 0, 0, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
