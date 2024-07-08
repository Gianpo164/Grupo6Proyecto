package GUI;

import logica.habitat.HabitatFactory;
import logica.habitat.SizeHabitat;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelMenuSize extends PanelMenu {
    private Font fuente;
    private Image imagenMenuHabitat;
    private JPanel panelBotones;
    private JTextField titulo;
    private JTextField informacion;
    private PanelBaseHabitat panel;
    private ArrayList<Integer> ocupado;

    public PanelMenuSize(HabitatFactory fabrica, PanelBaseHabitat panel) {
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

        SizeButtonHabitat smallButton0 = new SizeButtonHabitat(fabrica, SizeHabitat.SMALL, PosicionPanelHabitat.CHICO_NO, panel);
        smallButton0.setText("Small 0");
        SizeButtonHabitat smallButton1 = new SizeButtonHabitat(fabrica, SizeHabitat.SMALL, PosicionPanelHabitat.CHICO_NE, panel);
        smallButton1.setText("Small 1");
        SizeButtonHabitat smallButton2 = new SizeButtonHabitat(fabrica, SizeHabitat.SMALL, PosicionPanelHabitat.CHICO_SO, panel);
        smallButton2.setText("Small 2");
        SizeButtonHabitat smallButton3 = new SizeButtonHabitat(fabrica, SizeHabitat.SMALL, PosicionPanelHabitat.CHICO_SE, panel);
        smallButton3.setText("Small 3");
        SizeButtonHabitat mediumButton0 = new SizeButtonHabitat(fabrica, SizeHabitat.MEDIUM_HORIZONTAL, PosicionPanelHabitat.MEDIANO_N, panel);
        mediumButton0.setText("Medium -");
        SizeButtonHabitat mediumButton1 = new SizeButtonHabitat(fabrica, SizeHabitat.MEDIUM_HORIZONTAL, PosicionPanelHabitat.MEDIANO_S, panel);
        mediumButton1.setText("Medium _");
        SizeButtonHabitat mediumButton2 = new SizeButtonHabitat(fabrica, SizeHabitat.MEDIUM_VERTICAL, PosicionPanelHabitat.MEDIANO_E, panel);
        mediumButton2.setText("Medium :|");
        SizeButtonHabitat mediumButton3 = new SizeButtonHabitat(fabrica, SizeHabitat.MEDIUM_VERTICAL, PosicionPanelHabitat.MEDIANO_O, panel);
        mediumButton3.setText("Medium |:");
        SizeButtonHabitat largeButton = new SizeButtonHabitat(fabrica, SizeHabitat.LARGE, PosicionPanelHabitat.GRANDE, panel);
        largeButton.setText("Large");

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

    private void configurar (JComponent j){
        j.setFont(fuente);
        j.setBorder(null);
        j.setFocusable(false);
        j.setForeground(new Color(255,245,213));
        j.setOpaque(false);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenMenuHabitat, 0, 0, null);
    }
}
