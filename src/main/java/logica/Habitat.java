package logica;

import java.util.ArrayList;

public interface Habitat {
    public void addAnimal(Animal animal);
    public void removeAnimal(Animal animal);
    public ArrayList<Animal> getAnimals();
}
