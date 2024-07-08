package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import java.util.Random;

public abstract class Animal {
    protected Random rand = new Random();
    protected int estamina = 100;
    protected String nombre;
    protected String descripcion;
    protected TipoDeDieta dieta;
    protected int sizeX;
    protected int sizeY;
    protected float objetivoPosicionX;
    protected float objetivoPosicionY;
    protected float posicionX;
    protected float posicionY;
    protected int direccionX;
    protected int direccionY;
    protected float velocidad = 1f;
    protected boolean enMovimiento = false;
    protected int hambre;
    protected TipoDeHabitat habitatPreferido;
    protected int felicidad;
    protected Habitat habitat;

    public Animal(Habitat habitat) {
        this.habitat = habitat;
        sizeX = habitat.getSizeHabitat().getX();
        sizeY = habitat.getSizeHabitat().getY();
        posicionX = rand.nextInt(sizeX);
        posicionY = rand.nextInt(sizeY);
    }

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

    public TipoDeHabitat getHabitatPreferido() {
        return habitatPreferido;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public void comprobacionGrupo() {}

    public float getPosicionX() {
        return posicionX;
    }

    public float getPosicionY() {
        return posicionY;
    }

    public void mover() {
        if (enMovimiento) {
            posicionX += velocidad * ((objetivoPosicionX - posicionX) / (Math.abs(objetivoPosicionX - posicionX) + Math.abs(objetivoPosicionY - posicionY)));//posible division 0/0
            posicionY += velocidad * ((objetivoPosicionY - posicionY) / (Math.abs(objetivoPosicionX - posicionX) + Math.abs(objetivoPosicionY - posicionY)));//posible division 0/0
            estamina -= 1;
            if (estamina <= 0) {
                enMovimiento = false;
            } else {
                if (direccionX == 1) { // derecha
                    if (posicionX - objetivoPosicionX >= 0) {
                        posicionX = objetivoPosicionX;
                        posicionY = objetivoPosicionY;
                        enMovimiento = false;
                    }
                } else if (direccionX == -1) { // izquierda quitar if
                    if (posicionX - objetivoPosicionX <= 0) {
                        posicionX = objetivoPosicionX;
                        posicionY = objetivoPosicionY;
                        enMovimiento = false;
                    }
                }
                if (direccionY == 1) { //else? abajo
                    if (posicionY - objetivoPosicionY >= 0) {
                        posicionX = objetivoPosicionX;
                        posicionY = objetivoPosicionY;
                        enMovimiento = false;
                    }
                } else if (direccionY == -1) {//arriba quitar if
                    if (posicionY - objetivoPosicionY <= 0) {
                        posicionX = objetivoPosicionX;
                        posicionY = objetivoPosicionY;
                        enMovimiento = false;
                    }
                }
            }

        } else if (estamina == 0) {
            estamina = rand.nextInt(200);
        } else {
            do {
                objetivoPosicionX = rand.nextInt(sizeX);
                objetivoPosicionY = rand.nextInt(sizeY);
            }while (objetivoPosicionX == posicionX && objetivoPosicionY == posicionY);

            if (objetivoPosicionX - posicionX >= 0) {
                direccionX = 1;
            }else {
                direccionX = -1;
            }

            if (objetivoPosicionY - posicionY >= 0) {
                direccionY = 1; //abajo
            }else {
                direccionY = -1; //arriba
            }
            enMovimiento = true;
        }
    }
}
