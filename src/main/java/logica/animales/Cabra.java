package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public class Cabra extends Animal{
    public Cabra(Habitat habitat) {
        super(habitat);
        nombre = "Cabra";
        descripcion = "Pueden llegar a escalar pendientes de más de 60 grados.";
        dieta = TipoDeDieta.HERBIVORO;
        hambre = 25;
        habitatPreferido = TipoDeHabitat.MONTE;
        felicidad = 0;
    }

    public void comprobacionGrupo() {
        int grupo = 0;
        for (Animal animal : habitat.getAnimals()) {
            if (animal instanceof Cabra) {
                grupo++;
            }
        }
        if (grupo >= 2)
            felicidad = 100;
        else
            felicidad = 25;
    }
}
