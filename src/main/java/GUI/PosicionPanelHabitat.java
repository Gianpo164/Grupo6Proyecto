package GUI;

import static java.awt.GridBagConstraints.*;

/**
 * Enumeracion de las posibles posiciones de un habitat
 */
public enum PosicionPanelHabitat {
    GRANDE(0,0,2,2,CENTER),
    MEDIANO_N(0,0,2,1,NORTH),
    MEDIANO_S(0,1,2,1,SOUTH),
    MEDIANO_E(1,0,1,2,EAST),
    MEDIANO_O(0,0,1,2,WEST),
    CHICO_NE(1,0,1,1,NORTHEAST),
    CHICO_NO(0,0,1,1,NORTHWEST),
    CHICO_SE(1,1,1,1,SOUTHEAST),
    CHICO_SO(0,1,1,1,SOUTHWEST);

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private int anchor;

    /**
     * Asigna los distintos parametros que contiene la enumeracion
     * @param x Posicion eje x
     * @param y Posicion eje y
     * @param ancho Espacio que ocupa de ancho
     * @param alto Espacio que ocupa de alto
     * @param anchor Punto donde se posiciona
     */
    PosicionPanelHabitat(int x, int y, int ancho, int alto, int anchor) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.anchor = anchor;
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
}
