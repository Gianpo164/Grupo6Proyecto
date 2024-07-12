package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Cebra extends Animal{
    public Cebra(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Cebra";
        descripcion = "Pueden dormir pie!";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.SABANA;
        felicidad = 25;
        apetito = 2;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Cebra) {
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
