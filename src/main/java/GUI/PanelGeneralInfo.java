package GUI;

import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class PanelGeneralInfo extends JPanel {
    private Habitat habitat;
    private Font fuente;
    private JTextField tipoHabitat;
    private JTextField size;
    private JTextField comidaCarne = new JTextField();
    private JTextField comidaHierba = new JTextField();
    private JTextField tempText;
    private JTextField tempValue;
    private JSlider tempSlider;
    private Image imagen = new ImageIcon("src/main/resources/GeneralInfoHabitat.png").getImage();

    public PanelGeneralInfo(Habitat habitat, PanelPrincipal panelPrincipal) {
        this.habitat = habitat;
        setPreferredSize(new Dimension(500, 150));
        setLayout(null);

        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(32f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        tipoHabitat = new JTextField(habitat.getTipoDeHabitat().getNombre());
        configurar(tipoHabitat);
        tipoHabitat.setBounds(15, 10, 380, 50);
        add(tipoHabitat);

        size = new JTextField("Limite de animales: " + (habitat.getSizeHabitat().getLimite()));
        configurar(size);
        size.setFont(fuente.deriveFont(18f));
        size.setBounds(20, 60, 250, 30);
        add(size);

        configurar(comidaCarne);
        comidaCarne.setFont(fuente.deriveFont(18f));
        comidaCarne.setBounds(71, 100, 70, 30);
        add(comidaCarne);
        ReabastecerComidaButton reabastecerCarne = new ReabastecerComidaButton(habitat, "Carne");
        reabastecerCarne.setBounds(20, 90, 50, 50);
        add(reabastecerCarne);

        configurar(comidaHierba);
        comidaHierba.setFont(fuente.deriveFont(18f));
        comidaHierba.setBounds(216,100,70,30);
        add(comidaHierba);
        ReabastecerComidaButton reabastecerHierba = new ReabastecerComidaButton(habitat, "Hierba");
        reabastecerHierba.setBounds(160, 90, 50, 50);
        add(reabastecerHierba);

        tempSlider = new JSlider(SwingConstants.VERTICAL,-20,50,habitat.getTemperatura());
        tempSlider.setBounds(250,75,120,65);
        tempSlider.setMinorTickSpacing(10);
        tempSlider.setLabelTable(tempSlider.createStandardLabels(10));
        tempSlider.setOpaque(false);
        add(tempSlider);

        tempText = new JTextField("Temperatura");
        configurar(tempText);
        tempText.setBounds(300,55,110,30);
        tempText.setFont(fuente.deriveFont(13f));
        add(tempText);

        tempValue = new JTextField();
        tempValue.setBounds(330,75,100,60);
        configurar(tempValue);
        tempValue.setFont(fuente.deriveFont(24f));
        add(tempValue);

        SalirPanelButton salirButton = new SalirPanelButton(panelPrincipal);
        salirButton.setBounds(440,10,40,40);
        add(salirButton);

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
        g.drawImage(imagen,0,0,null);

        comidaCarne.setText(": "+habitat.getComidaCarne());
        comidaHierba.setText(": "+habitat.getComidaHierba());
        habitat.setTemperatura(tempSlider.getValue());
        tempValue.setText(String.valueOf(habitat.getTemperatura()) + "C");
        if (habitat.getTemperatura() >= habitat.getTipoDeHabitat().getTemperaturaMinima() && habitat.getTemperatura() <= habitat.getTipoDeHabitat().getTemperaturaMaxima()){
            tempValue.setForeground(new Color(169,230,29));
        }
        else {
            tempValue.setForeground(new Color(255,245,213));
        }
    }
}
