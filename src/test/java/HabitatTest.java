import logica.animales.EnumAnimales;
import logica.habitat.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HabitatTest {
    private Habitat habitat;

    @BeforeEach
    void SetUp() {
        HabitatFactory habitatFactory = new BosqueFactory();
        habitat = habitatFactory.crearMediumHabitat();
        EnumAnimales.CAPIBARA.crearAnimal(habitat);
    }
    @Test
    void HabitatSizeCorrecto() {
        assertEquals(MediumHabitat.class, habitat.getClass());
    }
    @Test
    void HabitatTipoCorrecto() {
        assertEquals(TipoDeHabitat.BOSQUE, habitat.getTipoDeHabitat());
    }
    @Test
    void HabitatAnimalesMaximo() {
        EnumAnimales.CAPIBARA.crearAnimal(habitat);
        EnumAnimales.CAPIBARA.crearAnimal(habitat);
        EnumAnimales.CAPIBARA.crearAnimal(habitat);
        EnumAnimales.CAPIBARA.crearAnimal(habitat);
        EnumAnimales.CAPIBARA.crearAnimal(habitat);

        assertEquals(SizeHabitat.MEDIUM_HORIZONTAL.getLimite(),habitat.getAnimals().size());
    }
    @Test
    void HabitatEliminarAnimal() {
        habitat.removeAnimal(habitat.getAnimals().get(0));
        assertEquals(0,habitat.getAnimals().size());
    }
}
