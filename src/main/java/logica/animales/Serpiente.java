package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Serpiente extends Animal{
    public Serpiente(Habitat habitat) {
        super(habitat);
        nombre = "Serpiente";
        descripcion = "Ten cuidado, puede ser venenosa";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.DESIERTO;
        felicidad = 0;
    }
}
