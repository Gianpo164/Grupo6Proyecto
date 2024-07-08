package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Cocodrilo extends Animal{
    public Cocodrilo(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Cocodrilo";
        descripcion = "Tiene la mordida más fuerte";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.TROPICAL;
        felicidad = 0;
    }
}
