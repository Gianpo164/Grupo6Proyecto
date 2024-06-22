package logica;

import java.util.ArrayList;

public class LargeHabitat implements Habitat{
    private ArrayList<Animal> animalesContenidos;
    private TipoDeHabitat habitat;

    public LargeHabitat(TipoDeHabitat habitat) {
        animalesContenidos = new ArrayList<>();
        this.habitat = habitat;
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animalesContenidos.size() < 7)
            animalesContenidos.add(animal);
        /*Dependeinedo de como avance el proyecto, incluir excepcion custom*/
    }

    @Override
    public void removeAnimal(Animal animal) {
        animalesContenidos.remove(animal);
    }

    @Override
    public ArrayList<Animal> getAnimals() {
        return animalesContenidos;
    }
}
