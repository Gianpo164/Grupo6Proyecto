package GUI;

import logica.habitat.HabitatFactory;
import logica.habitat.SizeHabitat;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Panel que funciona como menu que continua la creacion de un habitat
 */
public class PanelMenuSize extends PanelMenu {
    private Font fuente;
    private Image imagenMenuHabitat;
    private JPanel panelBotones;
    private JTextField titulo;
    private JTextField informacion;
    private PanelBaseHabitat panel;
    private ArrayList<Integer> ocupado;

    /**
     * Crea el panel, añade sus componentes y las opciones para crear un habitat
     * @param fabrica Fabrica de habitats
     * @param panel Panel en el que se creará un panel que contiene un habitat
     * @param bioma Tipo de habitat
     */
    public PanelMenuSize(HabitatFactory fabrica, PanelBaseHabitat panel, String bioma) {
        super();
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(15f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        imagenMenuHabitat = new ImageIcon(getClass().getClassLoader().getResource("MenuHabitat.png")).getImage();
        setLayout(null);
        setOpaque(false);
        this.panel = panel;
        this.ocupado = panel.getOcupado();

        titulo = new JTextField();
        configurar(titulo);
        titulo.setText("Crear Habitat");
        titulo.setFont(fuente.deriveFont(35f));
        titulo.setBounds(14,20,400,90);

        informacion = new JTextField();
        configurar(informacion);
        informacion.setText("Seleccione el tamaño del Habitat a crear");
        informacion.setBounds(14,111,400,24);

        SizeButtonHabitat smallButton0 = new SizeButtonHabitat(fabrica, SizeHabitat.SMALL, PosicionPanelHabitat.CHICO_NO, panel,bioma+"NW");
        smallButton0.setSize(100,100);
        SizeButtonHabitat smallButton1 = new SizeButtonHabitat(fabrica, SizeHabitat.SMALL, PosicionPanelHabitat.CHICO_NE, panel,bioma+"NE");
        smallButton1.setSize(100,100);
        SizeButtonHabitat smallButton2 = new SizeButtonHabitat(fabrica, SizeHabitat.SMALL, PosicionPanelHabitat.CHICO_SO, panel,bioma+"SW");
        smallButton2.setSize(100,100);
        SizeButtonHabitat smallButton3 = new SizeButtonHabitat(fabrica, SizeHabitat.SMALL, PosicionPanelHabitat.CHICO_SE, panel,bioma+"SE");
        smallButton3.setSize(100,100);
        SizeButtonHabitat mediumButton0 = new SizeButtonHabitat(fabrica, SizeHabitat.MEDIUM_HORIZONTAL, PosicionPanelHabitat.MEDIANO_N, panel,bioma+"N");
        mediumButton0.setSize(100,100);
        SizeButtonHabitat mediumButton1 = new SizeButtonHabitat(fabrica, SizeHabitat.MEDIUM_HORIZONTAL, PosicionPanelHabitat.MEDIANO_S, panel,bioma+"S");
        mediumButton1.setSize(100,100);
        SizeButtonHabitat mediumButton2 = new SizeButtonHabitat(fabrica, SizeHabitat.MEDIUM_VERTICAL, PosicionPanelHabitat.MEDIANO_E, panel,bioma+"E");
        mediumButton2.setSize(100,100);
        SizeButtonHabitat mediumButton3 = new SizeButtonHabitat(fabrica, SizeHabitat.MEDIUM_VERTICAL, PosicionPanelHabitat.MEDIANO_O, panel,bioma+"W");
        mediumButton3.setSize(100,100);
        SizeButtonHabitat largeButton = new SizeButtonHabitat(fabrica, SizeHabitat.LARGE, PosicionPanelHabitat.GRANDE, panel,bioma);
        largeButton.setSize(100,100);

        if (ocupado.get(0) == 1) {
            smallButton0.setEnabled(false);
            mediumButton0.setEnabled(false);
            mediumButton3.setEnabled(false);
            largeButton.setEnabled(false);
        }
        if (ocupado.get(1) == 1) {
            smallButton1.setEnabled(false);
            mediumButton0.setEnabled(false);
            mediumButton2.setEnabled(false);
            largeButton.setEnabled(false);
        }
        if (ocupado.get(2) == 1){
            smallButton2.setEnabled(false);
            mediumButton1.setEnabled(false);
            mediumButton3.setEnabled(false);
            largeButton.setEnabled(false);
        }
        if (ocupado.get(3) == 1) {
            smallButton3.setEnabled(false);
            mediumButton1.setEnabled(false);
            mediumButton2.setEnabled(false);
            largeButton.setEnabled(false);
        }
        panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setBounds(115,180,275,590);
        panelBotones.setLayout(new GridLayout(5,2,60,20));
        panelBotones.add(smallButton0);
        panelBotones.add(smallButton1);
        panelBotones.add(smallButton2);
        panelBotones.add(smallButton3);
        panelBotones.add(mediumButton0);
        panelBotones.add(mediumButton1);
        panelBotones.add(mediumButton2);
        panelBotones.add(mediumButton3);
        panelBotones.add(largeButton);

        add(titulo);
        add(informacion);
        add(panelBotones);
    }

    /**
     * Configura un componente para comportarce como sus pares
     * @param j Componente a configurar
     */
    private void configurar (JComponent j){
        j.setFont(fuente);
        j.setBorder(null);
        j.setFocusable(false);
        j.setForeground(new Color(255,245,213));
        j.setOpaque(false);
    }

    /**
     * Dibuja el fondo del panel
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenMenuHabitat, 0, 0, null);
    }
}
