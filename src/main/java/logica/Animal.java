package logica;

public abstract class Animal {
    protected String nombre;
    protected String descripcion;
    protected TipoDeDieta dieta;
    protected int hambre;

    public Animal() {}

    public void comer() {
        hambre = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHambre() {
        return hambre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoDeDieta getDieta() {
        return dieta;
    }
}
