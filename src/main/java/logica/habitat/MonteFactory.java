package logica.habitat;

/**
 * Implementa una fabrica con el tipo de habitat monte
 */
public class MonteFactory implements HabitatFactory{
    public MonteFactory() {}

    @Override
    public Habitat crearSmallHabitat() {
        return new SmallHabitat(TipoDeHabitat.MONTE);
    }

    @Override
    public Habitat crearMediumHabitat() {
        return new MediumHabitat(TipoDeHabitat.MONTE);
    }

    @Override
    public Habitat crearLargeHabitat() {
        return new LargeHabitat(TipoDeHabitat.MONTE);
    }
}
