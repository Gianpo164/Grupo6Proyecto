package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase base para todas las representaciones de animales
 */
public abstract class Animal {
    protected Random rand = new Random();
    protected int ticksComer;
    protected int ticksTemperatura;
    protected int estamina = 100;
    protected String nombre;
    protected String descripcion;
    protected TipoDeDieta dieta;
    protected int hambre;
    protected int apetito;
    protected int temperatura;
    protected int sizeX;
    protected int sizeY;
    protected double objetivoPosicionX;
    protected double objetivoPosicionY;
    protected double posicionX;
    protected double posicionY;
    protected boolean direccionX;
    protected boolean direccionY;
    protected float velocidad = 1f;
    protected boolean enMovimiento = false;
    protected TipoDeHabitat habitatPreferido;
    protected int felicidad;
    protected int infelicidad;
    protected boolean valGrupo = false;
    protected Habitat habitat;
    protected ArrayList<ImageIcon> imagenes;
    protected int ancho;
    protected int alto;
    protected int bordeH = 20;
    protected int bordeV = 30;

    /**
     * Crea el animal y asigna sus atributos
     * @param habitat Habitat al que pertenece el animal
     * @param imagenes Arreglo de imagenes que representan al animaml
     */
    public Animal(Habitat habitat, ArrayList<ImageIcon> imagenes) {
        this.habitat = habitat;
        this.imagenes = imagenes;
        sizeX = habitat.getSizeHabitat().getX();
        sizeY = habitat.getSizeHabitat().getY();
        ancho = imagenes.get(1).getIconWidth();
        alto = imagenes.get(1).getIconHeight();
        posicionX = rand.nextInt(sizeX - ancho - 2 * bordeH) + bordeH;
        posicionY = rand.nextInt(sizeY - alto - 2 * bordeV) + bordeV;
    }

    /**
     * Representación de la alimentacion de un animal
     */
    public void comer() {
        if (ticksComer == 100) {
            if (hambre < 100){
                hambre = hambre + apetito;
            }else {
                hambre = 100;
            }
            if (hambre > 50) {
                boolean comio = false;
                if (dieta == TipoDeDieta.CARNIVORO) {
                    comio = habitat.comerCarne();
                } else if (dieta == TipoDeDieta.HERBIVORO) {
                    comio = habitat.comerHierba();
                } else if (dieta == TipoDeDieta.OMNIVORO) {
                    int random = rand.nextInt(2);
                    if (random == 0) {
                        comio = habitat.comerCarne();
                    } else {
                        comio = habitat.comerHierba();
                    }
                }
                if (comio) {
                    if (felicidad < 100){
                        felicidad++;
                        infelicidad = 0;
                    }
                    hambre = 0;
                }else {
                    if (felicidad > 0) {
                        felicidad--;
                    } else {
                        infelicidad++;
                    }
                }
            }
            ticksComer = 0;
        }
        ticksComer++;
    }

    public void temperatura(){
        if (ticksTemperatura == 200) {
            temperatura = habitat.getTemperatura();
            if (habitat.getTipoDeHabitat().getTemperaturaMinima() <= temperatura && temperatura <= habitat.getTipoDeHabitat().getTemperaturaMaxima()){
                if(felicidad > 0 && felicidad < 100) {
                    felicidad++;
                }
            }else {
                if(felicidad > 0) {
                    felicidad--;
                }
            }
            ticksTemperatura = 0;
        }
        ticksTemperatura++;
    }

    /**
     * Devuelve el nombre del animal
     * @return el nombre del animal
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el hambre del animal
     * @return el hambre del animal
     */
    public int getHambre() {
        return hambre;
    }

    /**
     * Devuelve la descripcion del animal
     * @return la descripcion del animal
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve la dieta del animal
     * @return la dieta del animal
     */
    public TipoDeDieta getDieta() {
        return dieta;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    /**
     * Devuelve el habitat correspondiente al animal
     * @return el habitat correspondiente al animal
     */
    public TipoDeHabitat getHabitatPreferido() {
        return habitatPreferido;
    }

    /**
     * Devuelve la felicidad del animal
     * @return la felicidad del animal
     */
    public int getFelicidad() {
        return felicidad;
    }

    /**
     * Devuelve la infelicidad del animal
     * @return la infelicidad del animal
     */
    public int getInfelicidad() {
        return infelicidad;
    }

    /**
     * Comprueba las necesidades de grupo de un animal
     */
    public void comprobacionGrupo() {}

    /**
     * Devuelve la posicion horizontal
     * @return la posicion horizontal
     */
    public float getPosicionX() {
        return (float) posicionX;
    }

    /**
     * Devuelve la posicion vertical
     * @return la posicion vertical
     */
    public float getPosicionY() {
        return (float) posicionY;
    }

    /**
     * Devuelve la direccion hacia la que se mueve el animal
     * @return la direccion hacia la que se mueve el animal
     */
    public boolean getDireccionX() {
        return direccionX;
    }

    /**
     * Devuelve las imagenes que representan al animal
     * @return las imagenes que representan al animal
     */
    public ArrayList<ImageIcon> getImagenes() {
        return imagenes;
    }

    /**
     * Determina el movimiento de los animales mediante un sistema de energía
     */
    public void mover() {
        if (enMovimiento) {
            posicionX += velocidad * (objetivoPosicionX - posicionX) / (Math.abs(objetivoPosicionX - posicionX) + Math.abs(objetivoPosicionY - posicionY));
            posicionY += velocidad * (objetivoPosicionY - posicionY) / (Math.abs(objetivoPosicionX - posicionX) + Math.abs(objetivoPosicionY - posicionY));
            estamina -= 1;
            if (estamina <= 0) {
                enMovimiento = false;
            } else {
                if (direccionX) {
                    if (posicionX - objetivoPosicionX >= 0) {
                        posicionX = objetivoPosicionX;
                        posicionY = objetivoPosicionY;
                        enMovimiento = false;
                    }
                } else if (posicionX - objetivoPosicionX <= 0) {
                        posicionX = objetivoPosicionX;
                        posicionY = objetivoPosicionY;
                        enMovimiento = false;
                }
                if (direccionY) {
                    if (posicionY - objetivoPosicionY >= 0) {
                        posicionX = objetivoPosicionX;
                        posicionY = objetivoPosicionY;
                        enMovimiento = false;
                    }
                } else if (posicionY - objetivoPosicionY <= 0) {
                        posicionX = objetivoPosicionX;
                        posicionY = objetivoPosicionY;
                        enMovimiento = false;
                }
            }

        } else if (estamina <= 0) {
            estamina = 10000;
        } else {
            do {
                objetivoPosicionX = rand.nextInt(sizeX - ancho - 2 * bordeH) + bordeH;
                objetivoPosicionY = rand.nextInt(sizeY - alto - 2 * bordeV) + bordeV;
            }while (objetivoPosicionX == posicionX || objetivoPosicionY == posicionY);

            if (objetivoPosicionX - posicionX >= 0) {
                direccionX = true;
            }else {
                direccionX = false;
            }

            if (objetivoPosicionY - posicionY >= 0) {
                direccionY = true;
            }else {
                direccionY = false;
            }
            enMovimiento = true;
        }
    }
}
