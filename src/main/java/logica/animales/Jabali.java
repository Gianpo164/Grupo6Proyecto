package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Jabali extends Animal{
    public Jabali(Habitat habitat) {
        super(habitat);
        nombre = "Jabali";
        descripcion = "Se traen tremendo cortesito";
        dieta = TipoDeDieta.OMNIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.BOSQUE;
        felicidad = 0;
    }
}
