package logica;

import GUI.PanelPrincipal;
import GUI.Ventana;
import logica.animales.Animal;
import logica.habitat.Habitat;

import java.util.ArrayList;

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
                    }
                }
            }
        }
    }

    public void render() {
        panel.repaint();
    }

    public void setPanel(PanelPrincipal panel) {
        this.panel = panel;
    }

    public void setHabitats(ArrayList<Habitat> habitats) {
        this.habitats = habitats;
    }
}
