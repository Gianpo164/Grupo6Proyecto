package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Pinguino extends Animal{
    public Pinguino(Habitat habitat) {
        super(habitat);
        nombre = "Pingüino";
        descripcion = "Son aves que no pueden volar";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.POLAR;
        felicidad = 0;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Pinguino) {
                grupo++;
            }
        }
        if (grupo >= 3)
            felicidad += 50;
        if (felicidad > 100)
            felicidad = 100;
    }
}
