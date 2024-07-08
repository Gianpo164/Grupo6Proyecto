package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Oveja extends Animal{
    public Oveja(Habitat habitat) {
        super(habitat);
        nombre = "Oveja";
        descripcion = "Bola de lana, lana que crece sin parar.";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.MONTE;
        felicidad = 0;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Oveja) {
                grupo++;
            }
        }
        if (grupo >= 2)
            felicidad = 100;
        else
            felicidad = 25;
    }
}
