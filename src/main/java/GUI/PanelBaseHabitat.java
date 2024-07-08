package GUI;

import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PanelBaseHabitat extends JPanel implements MouseListener {
    private Image image;
    private boolean isSelected;
    private PanelPrincipal panelPrincipal;
    private PanelHabitat panelHabitat = null;
    private PosicionPanelHabitat posicionPanelHabitat;
    private ArrayList<Integer> ocupado = new ArrayList<>();
    private GridBagConstraints c = new GridBagConstraints();
    private boolean menuHabitat;


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

    public void setMenuHabitat(boolean menuHabitat) {
        this.menuHabitat = menuHabitat;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        if (menuHabitat) {
            PanelMenuHabitat menuHabitat = new PanelMenuHabitat(this);
            panelPrincipal.setPanelDibujar(menuHabitat);
            setColor(Color.gray);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

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
    public void setPaneldibujar(PanelMenu menu){
        panelPrincipal.setPanelDibujar(menu);
    }

    public void addHabitat(Habitat habitat){
        panelPrincipal.addHabitat(habitat);
    }

    public  void  setColor(Color color){ setBackground(color);}

    public void setSelected(boolean b) { isSelected = b; }

    public void setPosicionPanelHabitat(PosicionPanelHabitat posicionPanelHabitat) {
        this.posicionPanelHabitat = posicionPanelHabitat;
    }

    public ArrayList<Integer> getOcupado() {
        return ocupado;
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

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
}
