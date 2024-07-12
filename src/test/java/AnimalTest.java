import logica.animales.Animal;
import logica.animales.EnumAnimales;
import logica.habitat.BosqueFactory;
import logica.habitat.Habitat;
import logica.habitat.HabitatFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    private Habitat habitat;
    private Animal animal;

    @BeforeEach
    void SetUp() {
        HabitatFactory habitatFactory = new BosqueFactory();
        habitat = habitatFactory.crearMediumHabitat();
        EnumAnimales.CAPIBARA.crearAnimal(habitat);
        animal = habitat.getAnimals().getFirst();
    }
    @Test
    void AnimalHambre() {
        for (int i = 0; i < 2501; i++) {
            animal.comer();
        }
        assertEquals(0,animal.getHambre());
    }
    @Test
    void AnimalValido() {
        assertNotEquals(animal, null);
    }
    @Test
    void comprobacionGrupo() {
        EnumAnimales.CAPIBARA.crearAnimal(habitat);
        EnumAnimales.CAPIBARA.crearAnimal(habitat);
        EnumAnimales.CAPIBARA.crearAnimal(habitat);
        EnumAnimales.CAPIBARA.crearAnimal(habitat);

        assertEquals(75, animal.getFelicidad());
    }
    @Test
    void comprobacionInfelicidad(){
        int x = habitat.getComidaHierba();
        for (int i = 0; i < 207901; i++) {
            animal.comer();
        }

        assertEquals(1, animal.getInfelicidad());
    }
    @Test
    void AnimalMover() {
        double posicionInicialX = animal.getPosicionX();
        double posicionInicialY = animal.getPosicionY();
        animal.mover();
        animal.mover();

        assertNotEquals(posicionInicialX, animal.getPosicionX());
        assertNotEquals(posicionInicialY, animal.getPosicionY());
    }
    @Test
    void AnimalTemperatura() {
        int felicidadInicial = animal.getFelicidad();
        habitat.setTemperatura(10);
        for (int i = 0; i < 200; i++) {
            animal.temperatura();
        }
        assertTrue(felicidadInicial != animal.getFelicidad());
    }
}
