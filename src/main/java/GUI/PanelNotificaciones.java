package GUI;

import logica.animales.Animal;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelNotificaciones extends JPanel {
    private Font fuente;
    private ArrayList<Habitat> habitats;
    private JTextField notificacion;

    public PanelNotificaciones(ArrayList habitats){
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(10f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        this.habitats = habitats;
        setOpaque(false);
        setBounds(17,514,464,350);
    }

    public void createNotificacion(){
        for (Habitat i : habitats){
            for (Animal j : i.getAnimals()){
                if (j.getFelicidad() <= 10){
                    notificacion = new JTextField("Un " + j.getNombre() + " esta muy triste por las condiciones en las que vive");
                    configurar(notificacion);
                    add(notificacion);
                }
            }
            if (i.getComidaHierba() == 0 || i.getComidaCarne() == 0){
                notificacion = new JTextField("Se acabo la comida en un " + i.getTipoDeHabitat().getNombre());
                configurar(notificacion);
                add(notificacion);
            }
        }
    }

    private void configurar (JComponent j){
        j.setFont(fuente);
        j.setBorder(null);
        j.setFocusable(false);
        j.setPreferredSize(new Dimension(464,20));
        j.setForeground(new Color(255,245,213));
        j.setOpaque(false);
    }
}
