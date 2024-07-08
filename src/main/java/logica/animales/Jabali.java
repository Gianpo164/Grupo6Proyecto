package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Jabali extends Animal{
    public Jabali(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Jabali";
        descripcion = "Se traen tremendo cortesito";
        dieta = TipoDeDieta.OMNIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.BOSQUE;
        felicidad = 0;
    }
}
