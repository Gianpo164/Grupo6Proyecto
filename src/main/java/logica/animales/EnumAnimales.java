package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public enum EnumAnimales {
    ALPACA(TipoDeHabitat.MONTE, "Alpaca") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Alpaca(habitat, getImagenes()));
        }
    },
    CABRA(TipoDeHabitat.MONTE, "Cabra") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Cabra(habitat, getImagenes()));
        }
    },
    CAMELLO(TipoDeHabitat.DESIERTO, "Camello") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Camello(habitat, getImagenes()));
        }
    },
    CAPIBARA(TipoDeHabitat.BOSQUE, "Capibara") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Capibara(habitat, getImagenes()));
        }
    },
    CEBRA(TipoDeHabitat.SABANA, "Cebra") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Cebra(habitat, getImagenes()));
        }
    },
    CIERVO(TipoDeHabitat.BOSQUE, "Ciervo") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Ciervo(habitat, getImagenes()));
        }
    },
    COCODRILO(TipoDeHabitat.TROPICAL, "Cocodrilo") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Cocodrilo(habitat, getImagenes()));
        }
    },
    FOCA(TipoDeHabitat.POLAR, "Foca") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Foca(habitat, getImagenes()));
        }
    },
    HIENA(TipoDeHabitat.SABANA, "Hiena") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Hiena(habitat, getImagenes()));
        }
    },
    JABALI(TipoDeHabitat.BOSQUE, "Jabali") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Jabali(habitat, getImagenes()));
        }
    },
    LEON(TipoDeHabitat.SABANA, "Leon") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Leon(habitat, getImagenes()));
        }
    },
    MONO(TipoDeHabitat.TROPICAL, "Mono") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Mono(habitat, getImagenes()));
        }
    },
    OSOPOLAR(TipoDeHabitat.POLAR, "OsoPolar") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new OsoPolar(habitat, getImagenes()));
        }
    },
    OVEJA(TipoDeHabitat.MONTE, "Oveja") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Oveja(habitat, getImagenes()));
        }
    },
    PANTERANEGRA(TipoDeHabitat.TROPICAL, "PanteraNegra") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new PanteraNegra(habitat, getImagenes()));
        }
    },
    PINGUINO(TipoDeHabitat.POLAR, "Pinguino") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Pinguino(habitat, getImagenes()));
        }
    },
    SERPIENTE(TipoDeHabitat.DESIERTO, "Serpiente") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Serpiente(habitat, getImagenes()));
        }
    },
    ZORRO(TipoDeHabitat.DESIERTO, "Zorro") {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Zorro(habitat, getImagenes()));
        }
    };

    private TipoDeHabitat tipoDeHabitat;
    private ImageIcon icono;
    private ArrayList<ImageIcon> imagenes = new ArrayList<>();

    EnumAnimales(TipoDeHabitat tipoDeHabitat, String animal) {
        this.tipoDeHabitat = tipoDeHabitat;
        icono = new ImageIcon("src/main/resources/icons/"+animal+"Icon.png");
        imagenes.add(icono);
        imagenes.add(new ImageIcon("src/main/resources/animales/"+animal+".png"));
        imagenes.add(new ImageIcon(horizontalFlip(toBufferedImage(imagenes.get(1).getImage()))));

    }

    public abstract void crearAnimal(Habitat habitat);

    public ImageIcon getIcon() {
        return icono;
    }
    public ArrayList<ImageIcon> getImagenes() {
        return imagenes;
    }
    public TipoDeHabitat getTipoDeHabitat() {
        return tipoDeHabitat;
    }

    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }
    public static BufferedImage horizontalFlip(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage flippedImage = new BufferedImage(w, h, img.getType());
        Graphics2D g = flippedImage.createGraphics();
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g.dispose();
        return flippedImage;
    }

}


