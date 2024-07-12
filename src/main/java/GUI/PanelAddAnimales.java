package GUI;

import logica.animales.EnumAnimales;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.CENTER;

/**
 * Panel que contiene la funcionalidad de añadir animales
 */
public class PanelAddAnimales extends JPanel{
    private JPanel container;


    /**
     * Crea el panel y añade sus componentes
     * @param habitat Habitat la que se le añadiran animales
     */
    public PanelAddAnimales(Habitat habitat) {
        setPreferredSize(new Dimension(500,250));
        setOpaque(false);
        setLayout(null);
        container = new JPanel();
        container.setBounds(30,50,437,130);
        container.setLayout(new GridBagLayout());
        container.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = CENTER;
        c.weightx = 1;
        c.weighty = 1;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                c.gridy = i;
                c.gridx = j;
                JPanel aux = new JPanel();
                aux.setPreferredSize((new Dimension(0,0)));
                container.add(aux ,c);
            }
        }
        int x = 0;
        for (EnumAnimales animales : EnumAnimales.values()) {
            c.gridy = x / 3;
            c.gridx = x % 3;
            if (habitat.getTipoDeHabitat() == animales.getTipoDeHabitat()) {
                container.remove(0);
                AnimalButton animalButton = new AnimalButton(habitat, animales, this);
                container.add(animalButton,c);
                x++;
            }
        }
        add(container);
    }
}
