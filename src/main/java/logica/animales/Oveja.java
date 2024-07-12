package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Oveja extends Animal{
    public Oveja(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Oveja";
        descripcion = "Bola de lana, lana que crece sin parar";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.MONTE;
        felicidad = 25;
        apetito = 1;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Oveja) {
                grupo++;
            }
        }
        if (grupo >= 2 && !valGrupo) {
            felicidad += 25;
            if (felicidad > 100)
                felicidad = 100;
            valGrupo = true;
        } else if (grupo < 2 && valGrupo) {
            felicidad -= 25;
            if (felicidad < 0)
                felicidad = 0;
            valGrupo = false;
        }
    }
}
