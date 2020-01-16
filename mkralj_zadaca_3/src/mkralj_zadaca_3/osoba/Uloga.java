package mkralj_zadaca_3.osoba;

import mkralj_zadaca_3.ICloneable;

public class Uloga implements ICloneable<Uloga>{
 
    private int id;
    private String opis;

    public Uloga(int id, String opis) {
        this.id = id;
        this.opis = opis;
    }

    private Uloga(Uloga target) {
        this.id = target.id;
        this.opis = target.opis;
    }

    public int getId() {
        return id;
    }

    public String getOpis() {
        return opis;
    }

    @Override
    public Uloga clone() {
        return new Uloga(this);
    }
}
