package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Zorro extends Animal{
    public Zorro(Habitat habitat) {
        super(habitat);
        nombre = "Zorro";
        descripcion = "Chico y escurridizo";
        dieta = TipoDeDieta.OMNIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.DESIERTO;
        felicidad = 0;

    }
}
