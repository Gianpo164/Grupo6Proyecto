package logica.habitat;

import logica.animales.Animal;

import java.util.ArrayList;

public class LargeHabitat implements Habitat{
    private int comidaCarne = 300;
    private int comidaHierba = 300;;
    private ArrayList<Animal> animalesContenidos;
    private SizeHabitat sizeHabitat = SizeHabitat.LARGE;
    private TipoDeHabitat habitat;

    public LargeHabitat(TipoDeHabitat habitat) {
        animalesContenidos = new ArrayList<>();
        this.habitat = habitat;
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animalesContenidos.size() < sizeHabitat.getLimite()) {
            animalesContenidos.add(animal);
            for (Animal i : animalesContenidos)
                i.comprobacionGrupo();
        }
        /*Dependiendo de como avance el proyecto, incluir excepcion custom*/
    }

    @Override
    public void removeAnimal(Animal animal) {
        animalesContenidos.remove(animal);
        if (!animalesContenidos.isEmpty())
            for (Animal i : animalesContenidos)
                i.comprobacionGrupo();
    }

    @Override
    public ArrayList<Animal> getAnimals() {
        return animalesContenidos;
    }

    @Override
    public int getComidaCarne() {
        return comidaCarne;
    }

    @Override
    public void setComidaCarne(int comidaCarne) {
        this.comidaCarne = comidaCarne;
    }

    @Override
    public int getComidaHierba() {
        return comidaHierba;
    }

    @Override
    public void setComidaHierba(int comidaHierba) {
        this.comidaHierba = comidaHierba;
    }

    @Override
    public boolean comerCarne() {
        if (comidaCarne != 0) {
            comidaCarne -= 5;
            if (comidaCarne < 0) {
                comidaCarne = 0;
            }
            return true;
        } else
            return false;
    }

    @Override
    public boolean comerHierba() {
        if (comidaHierba != 0) {
            comidaHierba -= 5;
            if (comidaHierba < 0) {
                comidaHierba = 0;
            }
            return true;
        } else
            return false;
    }

    @Override
    public SizeHabitat getSizeHabitat() {
        return sizeHabitat;
    }

    @Override
    public void setSizeHabitat(SizeHabitat sizeHabitat) {
        this.sizeHabitat = sizeHabitat;
    }

    @Override
    public TipoDeHabitat getTipoDeHabitat() {
        return habitat;
    }
}