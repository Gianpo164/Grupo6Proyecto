package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Leon extends Animal {
    public Leon(Habitat habitat) {
        super(habitat);
        nombre = "Leon";
        descripcion = "Depredador salvaje";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.SABANA;
        felicidad = 0;
    }
}
