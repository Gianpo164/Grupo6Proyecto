package logica.habitat;

/**
 * Implementa una fabrica con el tipo de habitat sabana
 */
public class SabanaFactory implements HabitatFactory{
    public SabanaFactory() {}

    @Override
    public Habitat crearSmallHabitat() {
        return new SmallHabitat(TipoDeHabitat.SABANA);
    }

    @Override
    public Habitat crearMediumHabitat() {
        return new MediumHabitat(TipoDeHabitat.SABANA);
    }

    @Override
    public Habitat crearLargeHabitat() {
        return new LargeHabitat(TipoDeHabitat.SABANA);
    }
}
