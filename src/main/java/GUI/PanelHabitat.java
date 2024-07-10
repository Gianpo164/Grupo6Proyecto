package GUI;

import logica.animales.Animal;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

abstract public class PanelHabitat extends JPanel implements MouseListener {
    private Habitat habitat;
    private PanelPrincipal panelPrincipal;
    private boolean menuAnimales;
    private Image imagenFondo;
    private Image comederoHierba;
    private Image comederoCarne;
    private Image comedero;


    public PanelHabitat(Habitat habitat) {
        this.habitat = habitat;
        imagenFondo = ((new ImageIcon("src/main/resources/Habitats/"+habitat.getTipoDeHabitat().getHabitat() + habitat.getSizeHabitat().getSize()+".png")).getImage());
        comederoCarne = ((new ImageIcon("src/main/resources/ComederoC.png")).getImage());
        comederoHierba = ((new ImageIcon("src/main/resources/ComederoH.png")).getImage());
        comedero = ((new ImageIcon("src/main/resources/Comedero.png")).getImage());
        setVisible(true);
        setOpaque(false);
        setLayout(null);
        addMouseListener(this);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, null);
        g.drawImage(comederoCarne, 79, 40, null);
        g.drawImage(comederoHierba, 50, 40, null);
        if (habitat.getComidaCarne() == 0){
            g.drawImage(comedero, 79, 40, null);
        }
        if (habitat.getComidaHierba() == 0){
            g.drawImage(comedero, 50, 40, null);
        }
        if (habitat != null) {// temporal hasta que tengamos menu por defecto
            for (Animal animal : habitat.getAnimals()) {
                if(animal.getDireccionX()) {
                    g.drawImage(animal.getImagenes().get(1).getImage(), (int) animal.getPosicionX(), (int) animal.getPosicionY(), null);
                } else{
                    g.drawImage(animal.getImagenes().get(2).getImage(), (int) animal.getPosicionX(), (int) animal.getPosicionY(), null);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        PanelMenuInfoHabitat menuAnimales = new PanelMenuInfoHabitat(habitat, panelPrincipal);
        panelPrincipal.setPanelDibujar(menuAnimales);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }
}
