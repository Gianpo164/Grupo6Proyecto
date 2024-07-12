package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Panel que funciona como menu inical y permite la interaccion con el zoologico
 */
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

    /**
     * Crea el panel y agrega sus compnentes visuales
     * @param panelPrincipal Panel que contiene y dibuja los componentes en pantalla
     * @param habitats Lista de habitats existentes en el zoo
     */
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
        panelNotificaciones = new PanelNotificaciones(habitats);    //Asignar tamaño abajo
        add(buttonPause);
        add(titulo);
        add(panelEditorHabitat);
        add(panelNotificaciones);
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
     * Detiene o reanuda el funcionamiebto logico del programa
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        boolean running = panelPrincipal.getGl().getUpdating();
        panelPrincipal.getGl().setUpdating(!running);
        if (running == true) {
            pauseButton = new ImageIcon("src/main/resources/Renaudar.png").getImage();
        } else {
            pauseButton = new ImageIcon("src/main/resources/Pausar.png").getImage();
        }
    }

    /**
     * Dibuja el boton de pausa y crea las notificaciones correspondientes
     * @param g the <code>Graphics</code> object to protect
     */
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

