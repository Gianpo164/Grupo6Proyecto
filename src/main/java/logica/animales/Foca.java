package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Foca extends Animal{
    public Foca(Habitat habitat) {
        super(habitat);
        nombre = "Foca";
        descripcion = "Pueden llegar a estar 30 minutos seguidos sumergidas";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.POLAR;
        felicidad = 0;
    }
}
