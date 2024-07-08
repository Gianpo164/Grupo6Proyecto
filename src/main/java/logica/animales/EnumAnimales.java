package logica.animales;

import logica.habitat.Habitat;
import logica.habitat.TipoDeHabitat;

public enum EnumAnimales {
    ALPACA(TipoDeHabitat.MONTE) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Alpaca(habitat));
        }
    },
    CABRA(TipoDeHabitat.MONTE) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Cabra(habitat));
        }
    },
    CAMELLO(TipoDeHabitat.DESIERTO) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Camello(habitat));
        }
    },
    CAPIBARA(TipoDeHabitat.BOSQUE) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Capibara(habitat));
        }
    },
    CEBRA(TipoDeHabitat.SABANA) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Cebra(habitat));
        }
    },
    CIERVO(TipoDeHabitat.BOSQUE) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Ciervo(habitat));
        }
    },
    COCODRILO(TipoDeHabitat.TROPICAL) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Cocodrilo(habitat));
        }
    },
    FOCA(TipoDeHabitat.POLAR) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Foca(habitat));
        }
    },
    HIENA(TipoDeHabitat.SABANA) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Hiena(habitat));
        }
    },
    JABALI(TipoDeHabitat.BOSQUE) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Jabali(habitat));
        }
    },
    LEON(TipoDeHabitat.SABANA) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Leon(habitat));
        }
    },
    MONO(TipoDeHabitat.TROPICAL) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Mono(habitat));
        }
    },
    OSOPOLAR(TipoDeHabitat.POLAR) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new OsoPolar(habitat));
        }
    },
    OVEJA(TipoDeHabitat.MONTE) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Oveja(habitat));
        }
    },
    PANTERANEGRA(TipoDeHabitat.TROPICAL) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new PanteraNegra(habitat));
        }
    },
    PINGUINO(TipoDeHabitat.POLAR) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Pinguino(habitat));
        }
    },
    SERPIENTE(TipoDeHabitat.DESIERTO) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Serpiente(habitat));
        }
    },
    ZORRO(TipoDeHabitat.DESIERTO) {
        @Override
        public void crearAnimal(Habitat habitat) {
            habitat.addAnimal(new Zorro(habitat));
        }
    };

    private TipoDeHabitat tipoDeHabitat;

    EnumAnimales(TipoDeHabitat tipoDeHabitat) {
        this.tipoDeHabitat = tipoDeHabitat;
    }

    public abstract void crearAnimal(Habitat habitat);

    public TipoDeHabitat getTipoDeHabitat() {
        return tipoDeHabitat;
    }
}


