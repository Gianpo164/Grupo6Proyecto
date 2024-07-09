package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Serpiente extends Animal{
    public Serpiente(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Serpiente";
        descripcion = "Ten cuidado, puede ser venenosa";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.DESIERTO;
        felicidad = 25;
        apetito = 2;
    }
}
