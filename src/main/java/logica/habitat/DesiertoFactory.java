package logica.habitat;

/**
 * Implementa una fabrica con el tipo de habitat desierto
 */
public class DesiertoFactory implements HabitatFactory{
    public DesiertoFactory() {}

    @Override
    public Habitat crearSmallHabitat() {
        return new SmallHabitat(TipoDeHabitat.DESIERTO);
    }

    @Override
    public Habitat crearMediumHabitat() {
        return new MediumHabitat(TipoDeHabitat.DESIERTO);
    }

    @Override
    public Habitat crearLargeHabitat() {
        return new LargeHabitat(TipoDeHabitat.DESIERTO);
    }
}
