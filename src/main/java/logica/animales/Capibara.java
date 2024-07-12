package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Capibara extends Animal{
    public Capibara(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Capibara";
        descripcion = "El animal más amigable del mundo!";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.BOSQUE;
        felicidad = 25;
        apetito = 1;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Capibara) {
                grupo++;
            }
        }
        if (grupo >= 5 && !valGrupo) {
            felicidad += 25;
            if (felicidad > 100)
                felicidad = 100;
            valGrupo = true;
        } else if (grupo < 5 && valGrupo) {
            felicidad -= 25;
            if (felicidad < 0)
                felicidad = 0;
            valGrupo = false;
        }
    }
}
