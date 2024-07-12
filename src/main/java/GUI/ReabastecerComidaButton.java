package GUI;

import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Boton que reabastece de comida un habitat
 */
public class ReabastecerComidaButton extends JButton implements ActionListener {
    private Habitat habitat;
    private String comida;
    private Image imagenCarne = new ImageIcon("src/main/resources/Carne.png").getImage();
    private Image imagenHierba = new ImageIcon("src/main/resources/Hierba.png").getImage();

    /**
     * Crea el boton y le asigna sus atributos
     * @param habitat Habitat al cual se le reabastecera la comida
     * @param comida Tipo de comida a reabastecer
     */
    public ReabastecerComidaButton(Habitat habitat, String comida) {
        this.habitat = habitat;
        this.comida = comida;

        setBorder(null);
        setFocusable(false);
        setContentAreaFilled(false);
        addActionListener(this);
    }

    /**
     * Reabastece la comida seleccionada del habitat
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (habitat.getSizeHabitat()) {
            case SMALL -> {
                if (comida.equals("Carne"))
                    habitat.setComidaCarne(100);
                else if (comida.equals("Hierba"))
                    habitat.setComidaHierba(100);
            }
            case MEDIUM_HORIZONTAL, MEDIUM_VERTICAL -> {
                if (comida.equals("Carne"))
                    habitat.setComidaCarne(200);
                else if (comida.equals("Hierba"))
                    habitat.setComidaHierba(200);
            }
            case LARGE -> {
                if (comida.equals("Carne"))
                    habitat.setComidaCarne(300);
                else if (comida.equals("Hierba"))
                    habitat.setComidaHierba(300);
            }
        }
    }

    /**
     * Dibuja la imagen del boton
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (comida.equals("Carne"))
            g.drawImage(imagenCarne,0,0,null);
        else
            g.drawImage(imagenHierba,0,0,null);
    }
}
