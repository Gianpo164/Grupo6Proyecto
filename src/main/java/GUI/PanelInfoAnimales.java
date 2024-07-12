package GUI;

import logica.animales.Animal;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que muestra la informacion de cada animal dentro de un habitat
 */
public class PanelInfoAnimales extends JPanel {
    private Habitat habitat;
    private int cantidadPaneles = 0;

    /**
     * Crea el panel y asigna sus atributos
     * @param habitat Habitat del cual se mostrara la informacion de sus animales
     */
    public PanelInfoAnimales(Habitat habitat) {
        this.habitat = habitat;
        setMinimumSize(new Dimension(482, 500));
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Agrega los paneles de informacion de los animales
     */
    private void calcularPanelesHabitat() {
        setSizePanel();
        for (Animal animal : habitat.getAnimals()) {
            PanelInfoAnimal panelAnimal = new PanelInfoAnimal(animal,habitat,this);
            add(panelAnimal);
            cantidadPaneles++;
        }
    }

    /**
     * Calcula el tamaño del panel para añadir los paneles informativos
     */
    private void setSizePanel(){
        int height = 152 * habitat.getAnimals().size();
        if (height > 500) {
            setPreferredSize(new Dimension(482, height));
        }
    }

    /**
     * Maneja los paneles de informacion existentes
     * @param g the <code>Graphics</code> object to protect
     */
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
