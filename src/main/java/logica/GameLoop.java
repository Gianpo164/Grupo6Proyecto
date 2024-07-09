package logica;

import GUI.PanelPrincipal;
import logica.habitat.Habitat;

import java.util.ArrayList;

/**
 * Ciclo que se encarga de actualizar la logica y rederizar la aplicacion, los ticks por segundo determinan la velocidad del juego
 */
public class GameLoop implements Runnable {

    private boolean isRunning;
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

    /**
     * Metodo que inicia el funcionamiento de esta clase
     */
    @Override
    public void run() {
        isRunning = true;
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
                update();
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
    }

    /**
     * Actualiza la logica del programa
     */
    public void update() {
        if (!habitats.isEmpty()) {
            int x = habitats.size();
            for (int i = 0; i < x; i++) {
                Habitat habitat = habitats.get(i);
                if (!habitat.getAnimals().isEmpty()) {
                    int y = habitat.getAnimals().size();
                    for (int j = 0; j < y; j++) {
                        habitat.getAnimals().get(j).mover();
                        habitat.getAnimals().get(j).comer();
                        habitat.getAnimals().get(j).temperatura();
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
}
