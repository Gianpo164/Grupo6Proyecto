package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Camello extends Animal{
    public Camello(Habitat habitat) {
        super(habitat);
        nombre = "Camello";
        descripcion = "Pueden llegar a beber 115 litros de agua";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.DESIERTO;
        felicidad = 0;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Camello) {
                grupo++;
            }
        }
        if (grupo >= 3)
            felicidad += 50;
        if (felicidad > 100)
            felicidad = 100;
    }
}
