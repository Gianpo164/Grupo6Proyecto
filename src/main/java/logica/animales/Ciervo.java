package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Ciervo extends Animal{
    public Ciervo(Habitat habitat) {
        super(habitat);
        nombre = "Ciervo";
        descripcion = "Sus cuernos se llaman cornamentas";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.BOSQUE;
        felicidad = 0;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Ciervo) {
                grupo++;
            }
        }
        if (grupo >= 3)
            felicidad += 50;
        if (felicidad > 100)
            felicidad = 100;
    }
}
