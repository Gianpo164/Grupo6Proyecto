package GUI;

import logica.habitat.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Panel de informacion relacionada a los habitats del zoologico
 */
public class PanelEditorHabitat extends JPanel implements ActionListener {
    private Font fuente;
    private PanelZoo panelZoo;
    private ArrayList<Habitat> habitats;
    private JButton editor;
    private JTextField habitat;
    private JTextField informacion;
    private JTextField habitatCount;
    private JTextField sabanaCount;
    private JTextField polarCount;
    private JTextField desiertoCount;
    private JTextField bosqueCount;
    private JTextField tropicalCount;
    private JTextField monteCount;


    /**
     * Crea el panel y agrega sus componentes
     * @param panelZoo Panel que contiene al zoo
     * @param habitats Lista de habitats existentes en el zoo
     */
    public PanelEditorHabitat(PanelZoo panelZoo, ArrayList habitats){
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(17f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        setBounds(11,166,478,267);
        setOpaque(false);
        setLayout(null);
        this.habitats = habitats;
        this.panelZoo = panelZoo;
        editor = new JButton("Edit");
        editor.setFont(fuente);
        editor.setBorder(null);
        editor.setFocusable(false);
        editor.setForeground(Color.white);
        editor.setContentAreaFilled(false);
        editor.setBounds(417,125,51,56);
        editor.addActionListener(this);

        informacion = new JTextField();
        configurarCounts(informacion);
        informacion.setFont(fuente.deriveFont(17f));
        informacion.setText("Cantidad de Habitats  Total");
        informacion.setBounds(114,5,291,24);

        habitatCount = new JTextField();
        configurarCounts(habitatCount);
        habitatCount.setFont(fuente.deriveFont(22f));
        habitatCount.setText(String.valueOf(habitats.size()));
        habitatCount.setHorizontalAlignment(JTextField.CENTER);
        habitatCount.setBounds(348,128,54,54);

        habitat = new JTextField();
        configurarCounts(habitat);
        habitat.setFont(fuente.deriveFont(19f));
        habitat.setText(" Habitats");
        habitat.setBounds(-4,136,406,37);

        sabanaCount = new JTextField();
        configurarCounts(sabanaCount);
        sabanaCount.setFont(fuente.deriveFont(13f));
        sabanaCount.setBounds(155,91,21,15);

        polarCount = new JTextField();
        configurarCounts(polarCount);
        polarCount.setFont(fuente.deriveFont(13f));
        polarCount.setBounds(234,91,21,15);

        desiertoCount = new JTextField();
        configurarCounts(desiertoCount);
        desiertoCount.setFont(fuente.deriveFont(13f));
        desiertoCount.setBounds(314,91,21,15);

        bosqueCount = new JTextField();
        configurarCounts(bosqueCount);
        bosqueCount.setFont(fuente.deriveFont(13f));
        bosqueCount.setBounds(155,203,21,15);

        tropicalCount = new JTextField();
        configurarCounts(tropicalCount);
        tropicalCount.setFont(fuente.deriveFont(13f));
        tropicalCount.setBounds(234,203,21,15);

        monteCount = new JTextField();
        configurarCounts(monteCount);
        monteCount.setFont(fuente.deriveFont(13f));
        monteCount.setBounds(314,203,21,15);

        add(informacion);
        add(sabanaCount);
        add(polarCount);
        add(desiertoCount);
        add(tropicalCount);
        add(bosqueCount);
        add(monteCount);
        add(habitatCount);
        add(habitat);
        add(editor);
    }

    /**
     * Configura un componente para comportarce como sus pares
     * @param j Componente a configurar
     */
    private void configurarCounts (JComponent j){
        j.setFont(fuente);
        j.setBorder(null);
        j.setFocusable(false);
        j.setForeground(new Color(255,245,213));
        j.setOpaque(false);
    }

    /**
     * Habilita los paneles base para crear habitats en ellos
     * @param ae the event to be processed
     */
    public void actionPerformed(ActionEvent ae) {
        for (PanelBaseHabitat i : panelZoo.getPaneles()) {
            i.setSelected(true);
            i.setMenuHabitat(true);
        }
    }

    /**
     * Dibuja y actualiza la inforamcion presente en el panel
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        habitatCount.setText(String.valueOf(habitats.size()));

        int[] Counters = new int[6];


        for (int i = 0; i < habitats.size(); i++) {
            switch (habitats.get(i).getTipoDeHabitat()) {
                case BOSQUE -> Counters[3]++;
                case DESIERTO -> Counters[2]++;
                case POLAR -> Counters[1]++;
                case SABANA -> Counters[0]++;
                case TROPICAL -> Counters[4]++;
                case MONTE -> Counters[5]++;
            }
        }

        bosqueCount.setText(String.valueOf(Counters[3]));
        desiertoCount.setText(String.valueOf(Counters[2]));
        polarCount.setText(String.valueOf(Counters[1]));
        sabanaCount.setText(String.valueOf(Counters[0]));
        tropicalCount.setText(String.valueOf(Counters[4]));
        monteCount.setText(String.valueOf(Counters[5]));
    }
}
