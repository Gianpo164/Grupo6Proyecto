package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Alpaca extends Animal{
    public Alpaca(Habitat habitat) {
        super(habitat);
        nombre = "Alpaca";
        descripcion = "Originarias de Peru";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.MONTE;
        felicidad = 0;
    }
}
