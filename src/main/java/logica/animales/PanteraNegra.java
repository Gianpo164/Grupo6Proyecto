package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class PanteraNegra extends Animal{
    public PanteraNegra(Habitat habitat) {
        super(habitat);
        nombre = "Pantera negra";
        descripcion = "Tienen una excelente visión nocturna";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.TROPICAL;
        felicidad = 0;
    }
}
