package logica.habitat;

import logica.animales.Animal;

import java.util.ArrayList;

/**
 * Interfaz que moldea el funcionameinto de un habitat
 */
public interface Habitat {

    /**
     * Agrega un animal al habitat
     * @param animal Animal que pueda entrar al habitat
     */
    public void addAnimal(Animal animal);

    /**
     * Remover un animal del habitat
     * @param animal Animal que esta en el habitat
     */
    public void removeAnimal(Animal animal);

    /**
     * Devuelve la lista de animales que estan en el habitat
     * @return la lista de animales
     */
    public ArrayList<Animal> getAnimals();

    /**
     * Devuelve la cantidad de carne
     * @return la cantidad de carne que hay en el habitat
     */
    public int getComidaCarne();

    /**
     * Asigna la cantidad de comida tipo carne que tendra el habitat
     * @param comidaCarne
     */
    public void setComidaCarne(int comidaCarne);

    /**
     * Devuelve la cantidad de hierba
     * @return la cantidad de hierba que hay en el habitat
     */
    public int getComidaHierba();

    /**
     * Asigna la cantidad de comida tipo hierba que tendra el habitat
     * @param comidaHierba
     */
    public void setComidaHierba(int comidaHierba);

    /**
     * Metodo que determina el tipo de alimeto que consumio un animal
     * @return la confirmacion de comer carne
     */
    public boolean comerCarne();

    /**
     * Metodo que determina el tipo de alimeto que consumio un animal
     * @return la confirmacion de comer hierba
     */
    public boolean comerHierba();

    /**
     * Devuelve el tamaño de un habitat
     * @return el tamaño de un habitat
     */
    public SizeHabitat getSizeHabitat();

    /**
     * Asigna el tamaño a un habitat
     * @param sizeHabitat Tamaño de unn habitat
     */
    public void setSizeHabitat(SizeHabitat sizeHabitat);

    /**
     * Devuelve el tipo de habitat
     * @return el tipo de habitat
     */
    public TipoDeHabitat getTipoDeHabitat();

    /**
     * Asigna la temperatura del habitat
     * @param grados
     */
    public void setTemperatura(int grados);

    /**
     * Devuelve la temperatura del habitat
     * @return la temperatura
     */
    public int getTemperatura();
}
