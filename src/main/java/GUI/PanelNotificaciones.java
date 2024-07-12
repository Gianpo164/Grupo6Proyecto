package GUI;

import logica.animales.Animal;
import logica.habitat.Habitat;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Panel que crea y contiene las distintas notificaciones generadas por el zoo
 */
public class PanelNotificaciones extends JPanel {
    private Font fuente;
    private ArrayList<Habitat> habitats;
    private HashMap<Animal,ArrayList<JTextField>> fieldsAnimales = new HashMap<>();
    private HashMap<Habitat,ArrayList<JTextField>> fieldsHabitats = new HashMap<>();
    private HashMap<JTextField, Integer> notificaciones = new HashMap<>();
    private ArrayList<Animal> animales;
    private int ticksDeNotiTemporales = 600;

    /**
     * Crea el panel y asigna la lista de habitats
     * @param habitats Lista de habitats existentes en el zoo
     */
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
        setBounds(17,514,464,350);  //Mover a clase que la crea
    }

    /**
     * Crea las notificaciones correspondientes a animales y habitats
     */
    public void createNotificacion() {
        animales = new ArrayList<>();

        for (Habitat i : habitats) {
            animales.addAll(i.getAnimals());
        }

        if (animales.size() != fieldsAnimales.size()) {
            for (Animal i : animales) {
                if (!fieldsAnimales.containsKey(i)) {
                    ArrayList<JTextField> textFields = new ArrayList<>();
                    textFields.add(new JTextField("Un/a " + i.getNombre() + " esta muy triste por las condiciones en las que vive"));
                    textFields.add(new JTextField("Se han llevado a un/a " + i.getNombre() + "debido a su infelicidad"));
                    fieldsAnimales.put(i, (textFields));
                }
            }
        }

        if (habitats.size() != fieldsHabitats.size()){
            for (Habitat i : habitats){
                if (!fieldsHabitats.containsKey(i)) {
                    ArrayList<JTextField> textFields = new ArrayList<>();
                    textFields.add(new JTextField("Se acabo la comida en un " + i.getTipoDeHabitat().getNombre()));
                    fieldsHabitats.put(i, (textFields));
                }
            }
            fieldsHabitats.keySet().retainAll(habitats);
        }

        if (!fieldsAnimales.isEmpty()) {
            fieldsAnimales.forEach((k, t) -> {
                if (k.getFelicidad() <= 10) {
                    configurar(t.get(0));
                    add(t.get(0));
                }else{
                    remove(t.get(0));
                }
                if (!animales.contains(k)){
                    remove(t.get(0));
                }
                if (k.getInfelicidad() >= 10) {
                    configurar(t.get(1));
                    add(t.get(1));
                    remove(t.get(0));
                    k.getHabitat().getAnimals().remove(k);
                    notificaciones.put(t.get(1),0);
                }else if (k.getInfelicidad() == 0){
                    remove(t.get(1));
                }
            });
        }

        if (!fieldsHabitats.isEmpty()) {
            fieldsHabitats.forEach((k, t) -> {
                if (k.getComidaHierba() == 0 || k.getComidaCarne() == 0) {
                    configurar(t.get(0));
                    add(t.get(0));
                } else {
                    remove(t.get(0));
                }
            });
        }
        fieldsAnimales.keySet().retainAll(animales);
    }

    /**
     * Configura un componente para que se comporte de la misma forma que sus pares
     * @param j Componente a configurar
     */
    private void configurar (JComponent j){
        j.setFont(fuente);
        j.setBorder(null);
        j.setFocusable(false);
        j.setPreferredSize(new Dimension(464,20));
        j.setForeground(new Color(255,245,213));
        j.setOpaque(false);
    }

    /**
     * Elimina las notificaciones creadas que no sean necesarias
     */
    private void quitarNotificaciones(){
        ArrayList<JTextField> notificacionesTemporales = new ArrayList<>(notificaciones.keySet());
        if (!notificaciones.isEmpty()) {
            notificaciones.forEach((n, x) -> {
                x++;
                notificaciones.replace(n, x);
                if (n == null){
                    notificacionesTemporales.remove(n);
                }
                if (x > ticksDeNotiTemporales) {
                    remove(n);
                    System.out.println(x);
                    notificacionesTemporales.remove(n);
                }
            });
            notificaciones.keySet().retainAll(notificacionesTemporales);
        }
    }

    /**
     * Dibuja el panel y elimina las notificaciones correspondientes
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        quitarNotificaciones();
    }
}
