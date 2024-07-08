package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Hiena extends Animal{
    public Hiena(Habitat habitat) {
        super(habitat);
        nombre = "Hiena";
        descripcion = "Son bastante alegres";
        dieta = TipoDeDieta.CARNIVORO;
        hambre = 50;
        habitatPreferido = TipoDeHabitat.SABANA;
        felicidad = 0;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Hiena) {
                grupo++;
            }
        }
        if (grupo >= 3)
            felicidad += 50;
        if (felicidad > 100)
            felicidad = 100;
    }
}
