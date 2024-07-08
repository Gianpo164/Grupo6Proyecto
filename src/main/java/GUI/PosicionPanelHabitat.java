package GUI;

import static java.awt.GridBagConstraints.*;
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
    private String fondo;

    PosicionPanelHabitat(int x, int y, int ancho, int alto, int anchor, String fondo) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.anchor = anchor;
        this.fondo = fondo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getAnchor() {
        return anchor;
    }

    public String getFondo() {
        return fondo;
    }
}
