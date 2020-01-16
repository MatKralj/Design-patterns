package mkralj_zadaca_3.osoba;

import mkralj_zadaca_3.ICloneable;

public class Osoba implements ICloneable<Osoba>{
    
    private String imePrezime;
    private int id;

    public Osoba(String imePrezime, int id) {
        this.imePrezime = imePrezime;
        this.id = id;
    }

    private Osoba(Osoba target) {
        this.id = target.id;
        this.imePrezime = target.imePrezime;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public int getId() {
        return id;
    }

    @Override
    public Osoba clone() {
        return new Osoba(this);
    }
}
