package GUI;

import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanelGeneralInfo extends JPanel {
    private Habitat habitat;
    private Font fuente;
    private JTextField tipoHabitat;
    private JTextField size;
    private JTextField comidaCarne = new JTextField();
    private JTextField comidaHierba = new JTextField();;
    private Image imagen = new ImageIcon("src/main/resources/GeneralInfoHabitat.png").getImage();
    private Image imagenCarne = new ImageIcon("src/main/resources/Carne.png").getImage();
    private Image imagenHierba = new ImageIcon("src/main/resources/Hierba.png").getImage();

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
        tipoHabitat.setFont(fuente);
        tipoHabitat.setBounds(15,10,380,50);
        tipoHabitat.setOpaque(false);
        tipoHabitat.setBorder(null);
        tipoHabitat.setFocusable(false);
        add(tipoHabitat);

        size = new JTextField("Limite de animales: "+(habitat.getSizeHabitat().getLimite()));
        size.setFont(fuente.deriveFont(18f));
        size.setBounds(20,60,350,30);
        size.setOpaque(false);
        size.setBorder(null);
        size.setFocusable(false);
        add(size);

        comidaCarne.setFont(fuente.deriveFont(18f));
        comidaCarne.setBounds(71,100,350,30);
        comidaCarne.setOpaque(false);
        comidaCarne.setBorder(null);
        comidaCarne.setFocusable(false);
        add(comidaCarne);

        comidaHierba.setFont(fuente.deriveFont(18f));
        comidaHierba.setBounds(256,100,350,30);
        comidaHierba.setOpaque(false);
        comidaHierba.setBorder(null);
        comidaHierba.setFocusable(false);
        add(comidaHierba);


        SalirPanelButton salirButton = new SalirPanelButton(panelPrincipal);
        salirButton.setBounds(440,10,40,40);
        add(salirButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen,0,0,null);
        g.drawImage(imagenCarne, 20,90,null);
        g.drawImage(imagenHierba, 200,90,null);

        comidaCarne.setText(": "+habitat.getComidaCarne());
        comidaHierba.setText(": "+habitat.getComidaHierba());
    }
}
