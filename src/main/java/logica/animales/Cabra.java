package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Cabra extends Animal{
    public Cabra(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Cabra";
        descripcion = "Pueden llegar a escalar pendientes de más de 60 grados.";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.MONTE;
        felicidad = 25;
        apetito = 1;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Cabra) {
                grupo++;
            }
        }
        if (grupo >= 2)
            felicidad = 100;
        else
            felicidad = 25;
    }
}
