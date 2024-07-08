package logica.habitat;

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
