package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class OsoPolar extends Animal{
    public OsoPolar(Habitat habitat) {
        super(habitat);
        nombre = "Oso polar";
        descripcion = "Son nadadores muy fuertes";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.POLAR;
        felicidad = 0;
    }
}
