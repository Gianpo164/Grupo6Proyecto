package logica;

import logica.animales.Cebra;
import logica.animales.Leon;
import logica.habitat.BosqueFactory;
import logica.habitat.Habitat;
import logica.habitat.HabitatFactory;

public class Main {
    public static void main(String[] args) {
        HabitatFactory HF = new BosqueFactory();
        Habitat BH = HF.crearSmallHabitat();
        Habitat Hleon = HF.crearLargeHabitat();

        BH.addAnimal(new Cebra(BH));

        Cebra a1 = (Cebra) BH.getAnimals().getFirst();
        a1.comprobacionGrupo();
        System.out.println("Felicidad de una cebra: " + a1.getFelicidad());
        BH.addAnimal(new Cebra(BH));
        BH.addAnimal(new Cebra(BH));
        a1.comprobacionGrupo();
        System.out.println("Felicidad de una cebra depues de agregar mas cebras: " + a1.getFelicidad());

        Leon leon = new Leon(Hleon);
        System.out.println("hambre leon: " + leon.getHambre());
        leon.comer();
        System.out.println("hambre leon: " + leon.getHambre());

        Thread test1 = new Thread((new GameLoop()));
        test1.start();
    }
}
