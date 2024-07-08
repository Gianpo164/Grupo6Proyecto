package logica.habitat;

public enum SizeHabitat {
    SMALL(215,215,3),
    MEDIUM_HORIZONTAL(430,215,5),
    MEDIUM_VERTICAL(215,430,5),
    LARGE(430,430,7);

    private int x;
    private int y;
    private int limite;

    SizeHabitat(int x, int y, int limite) {
        this.x = x;
        this.y = y;
        this.limite = limite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLimite() {
        return limite;
    }
}
