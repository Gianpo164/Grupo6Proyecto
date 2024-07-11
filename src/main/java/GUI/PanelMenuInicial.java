package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelMenuInicial extends PanelMenu implements ActionListener{
    private PanelPrincipal panelPrincipal;
    private Image imagenMenu;
    private Font fuente;
    private PanelEditorHabitat panelEditorHabitat;
    private PanelNotificaciones panelNotificaciones;
    private JButton buttonPause;
    private JTextField titulo;
    private int accumulator = 0;
    private Image pauseButton = new ImageIcon("src/main/resources/Pausar.png").getImage();

    public PanelMenuInicial(PanelPrincipal panelPrincipal, ArrayList habitats) {
        super();
        this.panelPrincipal = panelPrincipal;

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
        titulo.setBounds(14,30,470,70);

        buttonPause = new JButton();
        configurar(buttonPause);
        buttonPause.setContentAreaFilled(false);
        buttonPause.setBounds(450,10,40,40);
        buttonPause.setMnemonic('p');
        buttonPause.addActionListener(this);
        buttonPause.setToolTipText("Pausa/Renaudar");

        panelEditorHabitat = new PanelEditorHabitat(panelPrincipal.getPanelZoo(), habitats);
        panelNotificaciones = new PanelNotificaciones(habitats);
        add(buttonPause);
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


    public void actionPerformed(ActionEvent e) {
        boolean running = panelPrincipal.getGl().getUpdating();
        panelPrincipal.getGl().setUpdating(!running);
        if (running == true) {
            pauseButton = new ImageIcon("src/main/resources/Renaudar.png").getImage();
        } else {
            pauseButton = new ImageIcon("src/main/resources/Pausar.png").getImage();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenMenu, 0, 0, null);
        g.drawImage(pauseButton,450,10,null);
        if (accumulator == 20){
            panelNotificaciones.createNotificacion();
            accumulator = 0;
        }
        accumulator++;
    }
}

