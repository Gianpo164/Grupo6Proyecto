package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Mono extends Animal{
    public Mono(Habitat habitat) {
        super(habitat);
        nombre = "Mono";
        descripcion = "Existen muchas especies distintas de monos";
        dieta = TipoDeDieta.OMNIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.TROPICAL;
        felicidad = 0;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Mono) {
                grupo++;
            }
        }
        if (grupo >= 3)
            felicidad = 100;
        else
            felicidad = 25;
    }
}
