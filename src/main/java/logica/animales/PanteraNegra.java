package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class PanteraNegra extends Animal{
    public PanteraNegra(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Pantera negra";
        descripcion = "Tienen una excelente visión nocturna!";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.TROPICAL;
        felicidad = 25;
        apetito = 3;
    }
}
