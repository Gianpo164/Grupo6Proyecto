package GUI;

import logica.animales.*;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalButton extends JButton implements ActionListener{
    private Habitat habitat;
    private EnumAnimales animales;
    private PanelAddAnimales panel;

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

    public void actionPerformed(ActionEvent ae) {
            animales.crearAnimal(habitat);
        }

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
    }
}
