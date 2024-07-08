package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Cebra extends Animal{
    public Cebra(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Cebra";
        descripcion = "Presa indefensa";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.SABANA;
        felicidad = 0;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Cebra) {
                grupo++;
            }
        }
        if (grupo >= 3)
            felicidad += 50;
        if (felicidad > 100)
            felicidad = 100;
    }
}
