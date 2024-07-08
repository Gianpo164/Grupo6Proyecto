package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Capibara extends Animal{
    public Capibara(Habitat habitat) {
        super(habitat);
        nombre = "Capibara";
        descripcion = "El animal más amigable del mundo!";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.BOSQUE;
        felicidad = 0;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Capibara) {
                grupo++;
            }
        }
        if (grupo >= 5)
            felicidad += 50;
        if (felicidad > 100)
            felicidad = 100;
    }
}
