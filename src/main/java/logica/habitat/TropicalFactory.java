package logica.habitat;

/**
 * Implementa una fabrica con el tipo de habitat tropical
 */
public class TropicalFactory implements HabitatFactory{
    public TropicalFactory() {}

    @Override
    public Habitat crearSmallHabitat() {
        return new SmallHabitat(TipoDeHabitat.TROPICAL);
    }

    @Override
    public Habitat crearMediumHabitat() {
        return new MediumHabitat(TipoDeHabitat.TROPICAL);
    }

    @Override
    public Habitat crearLargeHabitat() {
        return new LargeHabitat(TipoDeHabitat.TROPICAL);
    }
}
