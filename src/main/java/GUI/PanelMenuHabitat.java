package GUI;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanelMenuHabitat extends PanelMenu {
    private Font fuente;
    private Image imagenMenuHabitat;
    private JPanel panelBotones;
    private JTextField titulo;
    private JTextField informacion;
    private JTextField bosque;
    private JTextField monte;
    private JTextField polar;
    private JTextField desierto;
    private JTextField sabana;
    private JTextField tropical;


    public PanelMenuHabitat(PanelBaseHabitat panelBaseHabitat) {
        super();
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(17f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        imagenMenuHabitat = new ImageIcon(getClass().getClassLoader().getResource("MenuHabitat.png")).getImage();
        setLayout(null);
        setOpaque(false);

        titulo = new JTextField();
        configurar(titulo);
        titulo.setText("Crear Habitat");
        titulo.setFont(fuente.deriveFont(35f));
        titulo.setBounds(14,20,400,90);

        informacion = new JTextField();
        configurar(informacion);
        informacion.setText("Seleccione el tipo de Habitat a crear");
        informacion.setBounds(14,111,400,24);

        bosque = new JTextField();
        configurar(bosque);
        bosque.setText("Bosque");
        bosque.setHorizontalAlignment(JTextField.CENTER);
        bosque.setBounds(24,331,195,30);

        monte = new JTextField();
        configurar(monte);
        monte.setText("Monte");
        monte.setHorizontalAlignment(JTextField.CENTER);
        monte.setBounds(279,331,195,30);

        polar = new JTextField();
        configurar(polar);
        polar.setText("Polar");
        polar.setHorizontalAlignment(JTextField.CENTER);
        polar.setBounds(24,547,195,30);

        desierto = new JTextField();
        configurar(desierto);
        desierto.setText("Desierto");
        desierto.setHorizontalAlignment(JTextField.CENTER);
        desierto.setBounds(279,547,195,30);

        sabana = new JTextField();
        configurar(sabana);
        sabana.setText("Sabana");
        sabana.setHorizontalAlignment(JTextField.CENTER);
        sabana.setBounds(24,763,195,30);

        tropical = new JTextField();
        configurar(tropical);
        tropical.setText("Tropical");
        tropical.setHorizontalAlignment(JTextField.CENTER);
        tropical.setBounds(279,763,195,30);

        panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setBounds(24,170,450,590);
        panelBotones.setLayout(new GridLayout(3,2,60,60));
        panelBotones.add(new HabitatButton(TipoDeHabitat.BOSQUE, panelBaseHabitat));
        panelBotones.add(new HabitatButton(TipoDeHabitat.MONTE, panelBaseHabitat));
        panelBotones.add(new HabitatButton(TipoDeHabitat.POLAR, panelBaseHabitat));
        panelBotones.add(new HabitatButton(TipoDeHabitat.DESIERTO, panelBaseHabitat));
        panelBotones.add(new HabitatButton(TipoDeHabitat.SABANA, panelBaseHabitat));
        panelBotones.add(new HabitatButton(TipoDeHabitat.TROPICAL, panelBaseHabitat));


        add(titulo);
        add(bosque);
        add(monte);
        add(polar);
        add(desierto);
        add(sabana);
        add(tropical);
        add(panelBotones);
        add(informacion);
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
