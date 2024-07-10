package GUI;

import logica.animales.Animal;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelInfoAnimales extends JPanel {
    private Habitat habitat;
    private int cantidadPaneles = 0;

    public PanelInfoAnimales(Habitat habitat) {
        this.habitat = habitat;
        setMinimumSize(new Dimension(482, 500));
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void calcularPanelesHabitat() {
        setSizePanel();
        for (Animal animal : habitat.getAnimals()) {
            PanelInfoAnimal panelAnimal = new PanelInfoAnimal(animal,habitat,this);
            add(panelAnimal);
            cantidadPaneles++;
        }
    }

    private void setSizePanel(){
        int height = 152 * habitat.getAnimals().size();
        if (height > 500) {
            setPreferredSize(new Dimension(482, height));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (habitat.getAnimals().size() != cantidadPaneles) {
            removeAll();
            cantidadPaneles = 0;
            calcularPanelesHabitat();
        }
        setSizePanel();
    }
}
