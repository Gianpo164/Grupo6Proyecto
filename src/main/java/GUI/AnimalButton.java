package GUI;

import logica.animales.*;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Boton que determina el tipo de animal a crear
 */
public class AnimalButton extends JButton implements ActionListener{
    private Habitat habitat;
    private EnumAnimales animales;
    private PanelAddAnimales panel;

    /**
     * Crea el boton y asigna sus atributos
     * @param habitat Habitat al cual se añadira el animal
     * @param animales Animal seleccionado
     * @param panel Panel donde se creara este boton
     */
    public AnimalButton(Habitat habitat, EnumAnimales animales, PanelAddAnimales panel) {
        this.habitat = habitat;
        this.animales = animales;
        this.panel = panel;

        setFocusable(false);
        setBorder(null);
        setContentAreaFilled(false);
        setRolloverEnabled(false);
        setIcon(animales.getIcon());

        this.setPreferredSize(new Dimension(120, 120));

        addActionListener(this);
    }

    /**
     * Crea al animal seleccionado
     * @param ae the event to be processed
     */
    public void actionPerformed(ActionEvent ae) {
            animales.crearAnimal(habitat);
        }

    /**
     * Determina que animales estaran disponibles para ser añadidos al habitat
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (habitat.getTipoDeHabitat() == animales.getTipoDeHabitat()) {
        }else {
            panel.remove(this);
        }
        if (habitat.getSizeHabitat().getLimite() == habitat.getAnimals().size()) {
            setEnabled(false);
        }
        if (habitat.getSizeHabitat().getLimite() > habitat.getAnimals().size()) {
            setEnabled(true);
        }

    }
}
