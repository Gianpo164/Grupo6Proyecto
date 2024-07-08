package logica.habitat;

/**
 * Implementa una fabrica con el tipo de habitat polar
 */
public class PolarFactory implements HabitatFactory{
    public PolarFactory() {}

    @Override
    public Habitat crearSmallHabitat() {
        return new SmallHabitat(TipoDeHabitat.POLAR);
    }

    @Override
    public Habitat crearMediumHabitat() {
        return new MediumHabitat(TipoDeHabitat.POLAR);
    }

    @Override
    public Habitat crearLargeHabitat() {
        return new LargeHabitat(TipoDeHabitat.POLAR);
    }
}
