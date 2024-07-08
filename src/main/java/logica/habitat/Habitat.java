package logica.habitat;

import logica.animales.Animal;

import java.util.ArrayList;

public interface Habitat {

    public void addAnimal(Animal animal);
    public void removeAnimal(Animal animal);
    public ArrayList<Animal> getAnimals();
    public int getComidaCarne();
    public void setComidaCarne(int comidaCarne);
    public int getComidaHierba();
    public void setComidaHierba(int comidaHierba);
    public boolean comerCarne();
    public boolean comerHierba();
    public SizeHabitat getSizeHabitat();
    public void setSizeHabitat(SizeHabitat sizeHabitat);
    public TipoDeHabitat getTipoDeHabitat();
}
