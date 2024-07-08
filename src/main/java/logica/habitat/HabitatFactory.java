package logica.habitat;

/**
 * Interfaz que determina el funcionamineto de las fabricas
 */
public interface HabitatFactory {
    /**
     * Devuelve un habitat chico
     * @return Habitat chico
     */
    public Habitat crearSmallHabitat();

    /**
     * Devuelve un habitat mediano
     * @return Habitat mediano
     */
    public Habitat crearMediumHabitat();

    /**
     * Devuelve un habitat grande
     * @return Habitat grande
     */
    public Habitat crearLargeHabitat();
}
