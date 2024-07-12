package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Pinguino extends Animal{
    public Pinguino(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Pingüino";
        descripcion = "Son aves que no pueden volar";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.POLAR;
        felicidad = 25;
        apetito = 2;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Pinguino) {
                grupo++;
            }
        }
        if (grupo >= 3 && !valGrupo) {
            felicidad += 25;
            if (felicidad > 100)
                felicidad = 100;
            valGrupo = true;
        } else if (grupo < 3 && valGrupo) {
            felicidad -= 25;
            if (felicidad < 0)
                felicidad = 0;
            valGrupo = false;
        }
    }
}
