package GUI;

import static java.awt.GridBagConstraints.*;

/**
 * Enumeracion de las posibles posiciones de un habitat
 */
public enum PosicionPanelHabitat {
    GRANDE(0,0,2,2,CENTER, "Large"),
    MEDIANO_N(0,0,2,1,NORTH, "MediumH"),
    MEDIANO_S(0,1,2,1,SOUTH,"MediumH"),
    MEDIANO_E(1,0,1,2,EAST,"MediumV"),
    MEDIANO_O(0,0,1,2,WEST,"MediumV"),
    CHICO_NE(1,0,1,1,NORTHEAST,"Small"),
    CHICO_NO(0,0,1,1,NORTHWEST,"Small"),
    CHICO_SE(1,1,1,1,SOUTHEAST,"Small"),
    CHICO_SO(0,1,1,1,SOUTHWEST,"Small");

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private int anchor;
    private String fondo;   //Eliminar

    /**
     * Asigna los distintos parametros que contiene la enumeracion
     * @param x Posicion eje x
     * @param y Posicion eje y
     * @param ancho Espacio que ocupa de ancho
     * @param alto Espacio que ocupa de alto
     * @param anchor Punto donde se posiciona
     * @param fondo Identificador de imagen
     */
    PosicionPanelHabitat(int x, int y, int ancho, int alto, int anchor, String fondo) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.anchor = anchor;
        this.fondo = fondo;
    }

    /**
     * Devuelve la posicion eje x
     * @return la posicion eje x
     */
    public int getX() {
        return x;
    }

    /**
     * Devuelve la posicion eje y
     * @return la posicion eje y
     */
    public int getY() {
        return y;
    }

    /**
     * Devuelve el espacio que ocupa de ancho
     * @return el espacio que ocupa de ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Devuelve el espacio que ocupa de alto
     * @return el espacio que ocupa de alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Devuelve el punto donde se posiciona
     * @return el punto donde se posiciona
     */
    public int getAnchor() {
        return anchor;
    }

    /**
     * Devuelve el identificador de imagen
     * @return el identificador de imagen
     */
    public String getFondo() {  //Eliminar
        return fondo;
    }
}
