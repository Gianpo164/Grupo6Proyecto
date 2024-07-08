package logica.habitat;

public enum SizeHabitat {
    SMALL(215,215,3,"Small"),
    MEDIUM_HORIZONTAL(430,215,5,"Medium"),
    MEDIUM_VERTICAL(215,430,5,"MediumV"),
    LARGE(430,430,7,"Large");

    private int x;
    private int y;
    private int limite;
    private String size;

    SizeHabitat(int x, int y, int limite, String size) {
        this.x = x;
        this.y = y;
        this.limite = limite;
        this.size = size;
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

    public String getSize() {
        return size;
    }
}
