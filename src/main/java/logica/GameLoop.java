package logica;

import GUI.PanelPrincipal;
import logica.animales.Animal;
import logica.habitat.Habitat;

import java.util.ArrayList;

/**
 * Ciclo que se encarga de actualizar la logica y rederizar la aplicacion
 */
public class GameLoop implements Runnable {

    private boolean isRunning;
    private boolean isUpdating;
    private double ticksPorSegundo = 20;
    private double framesPorSegundo = 60;
    private final double nanoSegundosPorTicks = 1000000000 / ticksPorSegundo;
    private final double nanoSegundosPorFrame = 1000000000 / framesPorSegundo;
    private double deltaFrames;
    private double deltaTicks;
    private int ticks;
    private int frames;
    private long tiempo;
    private PanelPrincipal panel;
    private ArrayList<Habitat> habitats;
    private ArrayList<Habitat> habitatsCopia;
    private ArrayList<Animal> animalesCopia;

    /**
     * Metodo que inicia el funcionamiento de esta clase
     */
    @Override
    public void run() {
        isRunning = true;
        isUpdating = true;
        tiempo = System.currentTimeMillis();
        long ultimoInstante = System.nanoTime();

        while (isRunning) {
            long instante = System.nanoTime();
            deltaTicks += (instante - ultimoInstante) / nanoSegundosPorTicks;
            deltaFrames += (instante - ultimoInstante) / nanoSegundosPorFrame;
            ultimoInstante = instante;

            if (deltaTicks >= 1) {
                ticks++;
                deltaTicks--;
                if (isUpdating) {
                    update();
                }
            }

            if (deltaFrames >= 1) {
                frames++;
                deltaFrames--;
                this.render();
                if (System.currentTimeMillis() - tiempo >= 1000){
                    tiempo += 1000;
                    frames = 0;
                    ticks = 0;
                }
            }
        }
        System.out.println("lol");
    }

    /**
     * Actualiza la logica del programa
     */
    public void update() {
        habitatsCopia = (ArrayList<Habitat>) habitats.clone();
        if (!habitatsCopia.isEmpty()) {
            for (Habitat habitat : habitatsCopia) {
                animalesCopia = (ArrayList<Animal>) habitat.getAnimals().clone();
                if (!animalesCopia.isEmpty()) {
                    for (Animal animal : animalesCopia) {
                        animal.mover();
                        animal.temperatura();
                        animal.comer();
                    }
                }
            }
        }
    }

    /**
     * Actualiza todos los componentes graficos del programa
     */
    public void render() {
        panel.repaint();
    }

    /**
     * Asigna un panel donde iniciar e funcionamiento
     * @param panel Panel donde trabajar
     */
    public void setPanel(PanelPrincipal panel) {
        this.panel = panel;
    }

    /**
     * Asigna los habitats existentes en el programa
     * @param habitats Lista de habitats creados
     */
    public void setHabitats(ArrayList<Habitat> habitats) {
        this.habitats = habitats;
    }

    /**
     * Devuelve true si la logica esta funcionando o false si esta pausada
     * @return valor de funcionamiento de la logica
     */
    public boolean getUpdating() {
        return isUpdating;
    }

    /**
     * Asigna el valor true o false al funcionamiento de la logica
     * @param updating valor de verdad del funcionamiento
     */
    public void setUpdating(boolean updating) {
        isUpdating = updating;
    }
}
