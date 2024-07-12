package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Mono extends Animal{
    public Mono(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Mono";
        descripcion = "Existen muchas especies de monos";
        dieta = TipoDeDieta.OMNIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.TROPICAL;
        felicidad = 25;
        apetito = 2;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Mono) {
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
