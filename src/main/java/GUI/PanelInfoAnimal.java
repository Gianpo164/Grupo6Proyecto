package GUI;

import logica.animales.Animal;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PanelInfoAnimal extends JPanel{
    private Animal animal;
    private Image imagenInfoAnimal;
    private PanelInfoAnimales panelInfoAnimales;
    private Habitat habitat;
    private Font fuente;

    public PanelInfoAnimal(Animal animal,Habitat habitat, PanelInfoAnimales panelInfoAnimales){
        this.setLayout(null);
        this.animal = animal;
        this.habitat = habitat;
        this.panelInfoAnimales = panelInfoAnimales;
        setPreferredSize(new Dimension(482,152));
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(15f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        imagenInfoAnimal = new ImageIcon(getClass().getClassLoader().getResource("InfoAnimal.png")).getImage();
        JLabel foto = new JLabel(animal.getImagenes().get(1));
        foto.setBounds(35,40,70, 70);

        JTextField nombre = new JTextField();
        configurar(nombre);
        nombre.setText(animal.getNombre());
        nombre.setFont(fuente.deriveFont(15f));
        nombre.setBounds(125,22,298,20);

        JTextField descripcion = new JTextField();
        configurar(descripcion);
        descripcion.setText(animal.getDescripcion());
        descripcion.setFont(fuente.deriveFont(10f));
        descripcion.setBounds(125,42,298,20);

        JTextField dieta = new JTextField();
        configurar(dieta);
        dieta.setText("Dieta: "+animal.getDieta());
        dieta.setFont(fuente.deriveFont(15f));
        dieta.setBounds(125,62,298,20);

        JTextField felicidad = new JTextField();
        configurar(felicidad);
        felicidad.setText("Felicidad: "+animal.getFelicidad());
        felicidad.setFont(fuente.deriveFont(15f));
        felicidad.setBounds(125,82,298,20);

        JTextField hambre = new JTextField();
        configurar(hambre);
        hambre.setText("Hambre: "+animal.getHambre());
        hambre.setFont(fuente.deriveFont(15f));
        hambre.setBounds(125,102,298,20);

        JButton eliminar = new JButton(new ImageIcon("src/main/resources/SalirButton.png"));
        eliminar.setBounds(423,18,41,40);
        eliminar.addActionListener(new EscuchadorButton());
        eliminar.setBorder(null);
        eliminar.setContentAreaFilled(false);
        eliminar.setFocusable(false);

        add(foto);
        add(nombre);
        add(descripcion);
        add(dieta);
        add(felicidad);
        add(hambre);
        add(eliminar);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenInfoAnimal, 0, 0, null);
    }

    public Animal getAnimal() {
        return animal;
    }
    private void configurar (JComponent j){
        j.setBorder(null);
        j.setFocusable(false);
        j.setForeground(new Color(0,0,0));
        j.setOpaque(false);
    }
    private void eliminar(){
        habitat.getAnimals().remove(animal);
        panelInfoAnimales.removePanelesHabitat();
        this.getParent().remove(this);

    }
    private class EscuchadorButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            eliminar();
        }
    }
}
