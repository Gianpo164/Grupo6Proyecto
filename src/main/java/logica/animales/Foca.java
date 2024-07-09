package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;

public class Foca extends Animal{
    public Foca(Habitat habitat, ArrayList<ImageIcon> imagen) {
        super(habitat,imagen);
        nombre = "Foca";
        descripcion = "Pueden llegar a estar 30 minutos seguidos sumergidas";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.POLAR;
        felicidad = 25;
        apetito = 2;
    }
}
