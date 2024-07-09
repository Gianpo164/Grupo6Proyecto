package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelMenuInicial extends PanelMenu {
    private Image imagenMenu;
    private Font fuente;
    private PanelEditorHabitat panelEditorHabitat;
    private PanelNotificaciones panelNotificaciones;
    private JTextField titulo;

    public PanelMenuInicial(PanelPrincipal panelPrincipal, ArrayList habitats) {
        super();
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(60f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        imagenMenu = new ImageIcon(getClass().getClassLoader().getResource("MenuInicial.png")).getImage();
        setOpaque(false);
        setLayout(null);

        titulo = new JTextField();
        configurar(titulo);
        titulo.setText("Zoologico");
        titulo.setHorizontalAlignment(JTextField.CENTER);
        titulo.setBounds(14,30,470,90);

        panelEditorHabitat = new PanelEditorHabitat(panelPrincipal.getPanelZoo(), habitats);
        panelNotificaciones = new PanelNotificaciones(habitats);
        add(titulo);
        add(panelEditorHabitat);
        add(panelNotificaciones);
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
        panelEditorHabitat.repaint();
        panelNotificaciones.createNotificacion();
        g.drawImage(imagenMenu, 0, 0, null);
    }
}

