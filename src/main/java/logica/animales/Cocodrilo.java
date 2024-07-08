package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Cocodrilo extends Animal{
    public Cocodrilo(Habitat habitat) {
        super(habitat);
        nombre = "Cocodrilo";
        descripcion = "Tiene la mordida más fuerte";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.TROPICAL;
        felicidad = 0;
    }
}
