package GUI;

import logica.animales.Animal;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Panel de informacion general de un animal
 */
public class PanelInfoAnimal extends JPanel implements ActionListener{
    private Animal animal;
    private Image imagenInfoAnimal;
    private Habitat habitat;
    private Font fuente;
    private JTextField nombre;
    private JTextField descripcion;
    private JTextField dieta;
    private JTextField felicidad;
    private JTextField hambre;

    /**
     * Crea el panel y asigna los componentes que se muestran
     * @param animal Animal del cual se mostrara informacion
     * @param habitat Habitat al cual pertenece el animal
     */
    public PanelInfoAnimal(Animal animal,Habitat habitat){
        this.setLayout(null);
        this.animal = animal;
        this.habitat = habitat;
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

        nombre = new JTextField();
        configurar(nombre);
        nombre.setFont(fuente.deriveFont(15f));
        nombre.setBounds(125,22,298,26);

        descripcion = new JTextField();
        configurar(descripcion);
        descripcion.setFont(fuente.deriveFont(10f));
        descripcion.setBounds(125,42,298,26);

        dieta = new JTextField();
        configurar(dieta);
        dieta.setFont(fuente.deriveFont(15f));
        dieta.setBounds(125,62,298,26);

        felicidad = new JTextField();
        configurar(felicidad);
        felicidad.setFont(fuente.deriveFont(15f));
        felicidad.setBounds(125,82,298,26);

        hambre = new JTextField();
        configurar(hambre);
        hambre.setFont(fuente.deriveFont(15f));
        hambre.setBounds(125,102,298,26);

        JButton eliminar = new JButton(new ImageIcon("src/main/resources/SalirButton.png"));
        eliminar.setBounds(423,18,41,40);
        eliminar.addActionListener(this);
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

    /**
     * Dibuja los componentes del panel y actualiza su informacion
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenInfoAnimal, 0, 0, null);
        nombre.setText(animal.getNombre());
        descripcion.setText(animal.getDescripcion());
        dieta.setText("Dieta: "+animal.getDieta());
        felicidad.setText("Felicidad: "+animal.getFelicidad());
        hambre.setText("Hambre: "+animal.getHambre());
    }

    /**
     * Devuelve el animal del cual se esta mostrando informacion
     * @return el animal del cual se esta mostrando informacion
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * Configura los componentes del panel para que se comporten como sus pares
     * @param j Componente a configurar
     */
    private void configurar (JComponent j){
        j.setBorder(null);
        j.setFocusable(false);
        j.setForeground(new Color(255,245,213));
        j.setOpaque(false);
    }

    /**
     * Elimina al animal correspondiente del habitat
     */
    private void eliminar(){
        habitat.removeAnimal(animal);
    }

    /**
     * Elimina el animal correspondiente y su panel de informacion
     */
    public void actionPerformed(ActionEvent e) {
        eliminar();
    }
}
