package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Leon extends Animal {
    public Leon(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Leon";
        descripcion = "Depredador salvaje";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.SABANA;
        felicidad = 0;
    }
}
